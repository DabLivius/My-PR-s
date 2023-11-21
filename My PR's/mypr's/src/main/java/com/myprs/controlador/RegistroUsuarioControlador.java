package com.myprs.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myprs.controlador.dto.UsuarioRegistroDTO;
import com.myprs.servicio.UsuarioServicio;

/**
 * Controlador que gestiona las operaciones relacionadas con el registro de nuevos usuarios.
 */
@Controller
@RequestMapping(value = {"/registro"})
public class RegistroUsuarioControlador {

    private UsuarioServicio usuarioServicio;

    /**
     * Constructor del controlador con inyección de dependencias.
     *
     * @param usuarioServicio El servicio de usuario.
     */
    public RegistroUsuarioControlador(UsuarioServicio usuarioServicio) {
        super();
        this.usuarioServicio = usuarioServicio;
    }

    /**
     * Atributo del modelo para un nuevo objeto UsuarioRegistroDTO.
     *
     * @return Un nuevo objeto UsuarioRegistroDTO.
     */
    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    /**
     * Muestra el formulario de registro.
     *
     * @return La vista del formulario de registro.
     */
    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registro";
    }

    /**
     * Registra una nueva cuenta de usuario.
     *
     * @param registroDTO El objeto UsuarioRegistroDTO con los datos del registro.
     * @return Redirige al formulario de registro con un mensaje de éxito.
     */
    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
        usuarioServicio.guardar(registroDTO);
        return "redirect:/registro?exito";
    }
}
