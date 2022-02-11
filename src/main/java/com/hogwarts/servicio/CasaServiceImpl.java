package com.hogwarts.servicio;

import com.hogwarts.dao.CasaDao;
import com.hogwarts.domain.Casa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CasaServiceImpl implements CasaService{

    @Autowired
    private CasaDao casaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Casa> listarCasas() {
        return (List<Casa>) casaDao.findAll();
    }

    


    
}
