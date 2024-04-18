package com.riwi.FirstWebPage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.FirstWebPage.entity.Coder;
import com.riwi.FirstWebPage.repository.CoderRepository;

// Indica que la clase será un servicio
@Service
public class CoderService {

    // Indica que habrá una inyección de dependencias
    @Autowired
    private CoderRepository objCoderRepository;

    public List<Coder> findAll() {
        return this.objCoderRepository.findAll();
    }

    // Servicio para guardar un coder
    public Coder insert(Coder objCoder) {
        return this.objCoderRepository.save(objCoder);
    }
}
