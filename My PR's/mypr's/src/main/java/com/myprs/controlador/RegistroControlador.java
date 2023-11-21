package com.myprs.controlador;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myprs.servicio.UsuarioServicio;

/**
 * Controlador que gestiona las operaciones relacionadas con la página de inicio y el registro de usuarios.
 */
@Controller
public class RegistroControlador {

    @Autowired
    private UsuarioServicio servicio;

    /**
     * Muestra la página de inicio y redirige al perfil del usuario si ya ha iniciado sesión.
     *
     * @param request   La solicitud HTTP actual.
     * @param modelo    El modelo utilizado para la vista.
     * @param principal Objeto que representa al usuario autenticado.
     * @return La vista de la página de inicio o la redirección al perfil del usuario.
     */
    @GetMapping("/")
    public String verPaginaDeInicio(HttpServletRequest request, Model modelo, Principal principal) {
        modelo.addAttribute("usuarios", servicio.listarUsuarios());
        String referer = request.getHeader("Referer"); // Obtiene la URL de referencia

        // Verifica si el usuario ha iniciado sesión y la URL de referencia es la página de inicio de sesión
        if (referer != null && referer.contains("/login") && principal != null) {
            return "redirect:/perfil"; // Redirige a la página de perfil después de iniciar sesión desde /login
        } else if (referer != null) {
            return "redirect:" + referer; // Redirige de nuevo a la URL de referencia si no es /login
        } else {
            // Si no hay una URL de referencia, redirige a una página predeterminada
            return "redirect:/perfil"; // Cambia "/perfil" a la página que desees
        }
    }
}
