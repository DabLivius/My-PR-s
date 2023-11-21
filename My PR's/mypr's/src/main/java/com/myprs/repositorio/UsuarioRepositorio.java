package com.myprs.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myprs.modelo.Usuario;

/**
 * Interfaz que proporciona operaciones de acceso a datos para la entidad Usuario.
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    /**
     * Busca y devuelve un usuario por su dirección de correo electrónico.
     *
     * @param email La dirección de correo electrónico del usuario.
     * @return El usuario correspondiente a la dirección de correo electrónico proporcionada.
     */
    public Usuario findByEmail(String email);
}
