package com.hogwarts.servicio;

import com.hogwarts.domain.Estudiante;
import java.util.List;

public interface EstudianteService {

    public List<Estudiante> listarPersonas();
    
    public void guardar(Estudiante personas);
    public void eliminar (Estudiante persona);
    public Estudiante encontrarPersona(Estudiante persona);
}
