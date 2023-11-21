package com.myprs.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.myprs.controlador.dto.UsuarioRegistroDTO;
import com.myprs.modelo.Usuario;

/**
 * Interfaz para el servicio de gestión de usuarios.
 */
public interface UsuarioServicio extends UserDetailsService {

    /**
     * Guarda un nuevo usuario en el sistema.
     *
     * @param registroDTO Datos del usuario a ser registrado.
     * @return El usuario guardado.
     */
    public Usuario guardar(UsuarioRegistroDTO registroDTO);

    /**
     * Obtiene una lista de todos los usuarios en el sistema.
     *
     * @return Lista de usuarios.
     */
    public List<Usuario> listarUsuarios();

    /**
     * Obtiene un usuario por su dirección de correo electrónico.
     *
     * @param email Dirección de correo electrónico del usuario.
     * @return El usuario correspondiente a la dirección de correo electrónico proporcionada.
     */
    public Usuario obtenerPorEmail(String email);

}
