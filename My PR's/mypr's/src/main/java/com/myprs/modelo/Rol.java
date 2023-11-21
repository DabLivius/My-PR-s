package com.myprs.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad que representa un rol en la base de datos.
 */
@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    // Constructores

    /**
     * Constructor con parámetros para crear un objeto Rol.
     *
     * @param id     El identificador del rol.
     * @param nombre El nombre del rol.
     */
    public Rol(Long id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Constructor por defecto necesario para JPA.
     */
    public Rol() {
        
    }

    /**
     * Constructor con parámetros para crear un objeto Rol con el nombre del rol.
     *
     * @param nombre El nombre del rol.
     */
    public Rol(String nombre) {
        super();
        this.nombre = nombre;
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
}

