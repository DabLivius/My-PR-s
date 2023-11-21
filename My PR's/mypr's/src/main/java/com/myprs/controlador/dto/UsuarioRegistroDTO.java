package com.myprs.controlador.dto;

/**
 * Representa un objeto de transferencia de datos (DTO) utilizado para la creación de nuevos usuarios.
 * Contiene información como el nombre completo, nombre de usuario, correo electrónico y contraseña.
 */
public class UsuarioRegistroDTO {

    /** Identificador único del usuario. */
    private Long id;

    /** Nombre completo del usuario. */
    private String nombreCompleto; // Cambia el nombre del campo

    /** Nombre de usuario único. */
    private String username; // Agrega un campo para el nombre de usuario

    /** Correo electrónico del usuario. */
    private String email;

    /** Contraseña del usuario. */
    private String password;

    /**
     * Obtiene el identificador único del usuario.
     *
     * @return El identificador único del usuario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del usuario.
     *
     * @param id El nuevo identificador único del usuario.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre completo del usuario.
     *
     * @return El nombre completo del usuario.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo del usuario.
     *
     * @param nombreCompleto El nuevo nombre completo del usuario.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Obtiene el nombre de usuario único.
     *
     * @return El nombre de usuario único.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el nombre de usuario único.
     *
     * @param username El nuevo nombre de usuario único.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return El correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param email El nuevo correo electrónico del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param password La nueva contraseña del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Constructor que permite crear un objeto UsuarioRegistroDTO con los parámetros especificados.
     *
     * @param nombreCompleto El nombre completo del usuario.
     * @param username       El nombre de usuario único.
     * @param email          El correo electrónico del usuario.
     * @param password       La contraseña del usuario.
     */
    public UsuarioRegistroDTO(String nombreCompleto, String username, String email, String password) {
        super();
        this.nombreCompleto = nombreCompleto;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor predeterminado sin parámetros para la creación de un objeto UsuarioRegistroDTO vacío.
     */
    public UsuarioRegistroDTO() {

    }
}
