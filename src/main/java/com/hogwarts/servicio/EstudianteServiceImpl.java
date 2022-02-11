package com.hogwarts.servicio;

import com.hogwarts.dao.EstudianteDao;
import com.hogwarts.domain.Estudiante;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstudianteServiceImpl implements EstudianteService{

    @Autowired
    private EstudianteDao estudianteDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Estudiante> listarEstudiantes() {
        return (List<Estudiante>) estudianteDao.findAll();
    }

    @Override
    @Transactional()
    public void guardar(Estudiante estudiante) {
        estudianteDao.save(estudiante);
    }

    @Override
    @Transactional()
    public void eliminar(Estudiante estudiante) {
        estudianteDao.delete(estudiante);
    }

    @Override
    @Transactional(readOnly = true)
    public Estudiante encontrarEstudiante(Estudiante estudiante) {
        return estudianteDao.findById(estudiante.getId()).orElse(null);
    }
    
}
