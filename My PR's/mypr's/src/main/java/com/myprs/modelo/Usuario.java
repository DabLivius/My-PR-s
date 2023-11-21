package com.myprs.modelo;

import java.util.Collection;
import java.util.List;

import javax.persistence.*;

/**
 * Entidad que representa un usuario en la base de datos.
 */
@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")
    )
    private Collection<Rol> roles;

    // Constructores

    /**
     * Constructor por defecto necesario para JPA.
     */
    public Usuario() {
        // Constructor por defecto necesario para JPA
    }

    /**
     * Constructor con parámetros para crear un objeto Usuario.
     *
     * @param id       El identificador del usuario.
     * @param nombre   El nombre del usuario.
     * @param apellido El apellido del usuario.
     * @param email    El correo electrónico del usuario.
     * @param password La contraseña del usuario.
     * @param roles    Los roles asociados al usuario.
     */
    public Usuario(Long id, String nombre, String apellido, String email, String password, Collection<Rol> roles) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    /**
     * Constructor con parámetros para crear un objeto Usuario.
     *
     * @param nombre   El nombre del usuario.
     * @param apellido El apellido del usuario.
     * @param email    El correo electrónico del usuario.
     * @param password La contraseña del usuario.
     * @param roles    Los roles asociados al usuario.
     */
    public Usuario(String nombre, String apellido, String email, String password, Collection<Rol> roles) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }
}