package com.myprs.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador que gestiona las operaciones relacionadas con la página principal y la navegación.
 */
@Controller
public class HomeControlador {

    /**
     * Muestra la página de ejercicios.
     *
     * @return La vista de la página de ejercicios.
     */
    @GetMapping("/ejercicios")
    public String mostrarPaginaEjercicios() {
        return "ejercicios";
    }

    /**
     * Muestra la página de perfil del usuario.
     *
     * @return La vista de la página de perfil.
     */
    @GetMapping("/perfil")
    public String mostrarPerfil() {
        return "perfil";
    }

    /**
     * Muestra la página de entrenamiento.
     *
     * @return La vista de la página de entrenamiento.
     */
    @GetMapping("/entrenamiento")
    public String mostrarEntrenamiento() {
        return "entrenamiento";
    }

    /**
     * Muestra la página de inicio de sesión.
     *
     * @return La vista de la página de inicio de sesión.
     */
    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }
}
