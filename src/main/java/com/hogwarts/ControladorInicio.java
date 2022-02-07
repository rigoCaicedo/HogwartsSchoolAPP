package com.hogwarts;

import com.hogwarts.domain.Estudiante;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import clienteRest.LlamarAPI;

@Controller
@Slf4j
public class ControladorInicio {

    @Value("${index.saludo}")
    private String saludo;

    @GetMapping("/")
    public String inicio(Model model) {
        //obj para consumo de api
        var rest = new LlamarAPI();
        
        //respuesta API de estudiantes
        var listEstudiantes=rest.listarAlumnos();
        
        ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
        for (Estudiante est : listEstudiantes) {
            estudiantes.add(est);
        }

        log.info("Ejecutando el controlador");

        
        model.addAttribute("estudiantes", estudiantes);
        return "index";
    }

    @GetMapping("/response.json")
    public String inicio() {
        return "response.json";
    }
}
