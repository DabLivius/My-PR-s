package com.myprs.servicio.Impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myprs.controlador.dto.UsuarioRegistroDTO;
import com.myprs.modelo.Rol;
import com.myprs.modelo.Usuario;
import com.myprs.repositorio.UsuarioRepositorio;
import com.myprs.servicio.UsuarioServicio;

/**
 * Implementación del servicio de usuario que proporciona la lógica de negocio relacionada con los usuarios.
 */
@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * Constructor de la clase.
     *
     * @param usuarioRepositorio Repositorio de usuario.
     */
    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
        super();
        this.usuarioRepositorio = usuarioRepositorio;
    }

    /**
     * Registra un nuevo usuario a partir de un DTO de registro.
     *
     * @param registroDTO DTO de registro del usuario.
     * @return Usuario registrado.
     */
    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO) {
        Usuario usuario = new Usuario(registroDTO.getNombreCompleto(),
                registroDTO.getUsername(), registroDTO.getEmail(),
                passwordEncoder.encode(registroDTO.getPassword()), Arrays.asList(new Rol("ROLE_USER")));
        return usuarioRepositorio.save(usuario);
    }

    /**
     * Carga un usuario por su nombre de usuario para la autenticación.
     *
     * @param username Nombre de usuario.
     * @return Detalles del usuario para la autenticación.
     * @throws UsernameNotFoundException Si el usuario no es encontrado.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }

    /**
     * Mapea las autoridades (roles) de la aplicación a las autoridades de Spring Security.
     *
     * @param roles Roles del usuario.
     * @return Lista de autoridades (GrantedAuthority).
     */
    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }

    /**
     * Obtiene la lista de todos los usuarios registrados.
     *
     * @return Lista de usuarios.
     */
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    /**
     * Obtiene un usuario por su dirección de correo electrónico.
     *
     * @param email Dirección de correo electrónico del usuario.
     * @return Usuario correspondiente a la dirección de correo electrónico proporcionada.
     */
    @Override
    public Usuario obtenerPorEmail(String email) {
        return usuarioRepositorio.findByEmail(email);
    }
}
