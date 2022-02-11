package com.hogwarts.dao;

import com.hogwarts.domain.Estudiante;
import org.springframework.data.repository.CrudRepository;

public interface EstudianteDao extends CrudRepository<Estudiante, Long>{
    
}
