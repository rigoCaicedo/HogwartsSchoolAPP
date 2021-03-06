package com.hogwarts.web;

import com.hogwarts.domain.Casa;
import com.hogwarts.domain.Estudiante;
import com.hogwarts.servicio.CasaService;
import com.hogwarts.servicio.EstudianteService;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private EstudianteService estudianteService;
    
    @Autowired
    private CasaService casaService;

    @GetMapping("/")
    public String inicio(Model model) {
        var estudiantes = estudianteService.listarEstudiantes();
        log.info("Ejecutando el controlador Spring MVC");

        model.addAttribute("estudiantes", estudiantes);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Estudiante estudiante,Model model) {
        List<Casa>casas=casaService.listarCasas();
        
        model.addAttribute("casas", casas);
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Estudiante estudiante, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar";
        }
        estudianteService.guardar(estudiante);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(Estudiante estudiante, Model model) {
        estudiante = estudianteService.encontrarEstudiante(estudiante);
        List<Casa>casas=casaService.listarCasas();
        model.addAttribute("estudiante", estudiante);
        model.addAttribute("casas", casas);
        return "modificar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Estudiante estudiante, Model model) {
        estudianteService.eliminar(estudiante);
        return "redirect:/";
    }
}
