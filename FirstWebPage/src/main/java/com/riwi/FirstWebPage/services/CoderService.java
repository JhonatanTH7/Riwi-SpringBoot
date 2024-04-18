package com.riwi.FirstWebPage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.FirstWebPage.entity.Coder;
import com.riwi.FirstWebPage.repository.CoderRepository;

// Indica que la clase será un servicio
@Service
public class CoderService {

    // Indica que habrá una inyección de dependencias
    @Autowired
    private CoderRepository objCoderRepository;

    // Servicio para obtener todos los coders
    public List<Coder> findAll() {
        return this.objCoderRepository.findAll();
    }

    // Servicio para guardar un coder
    public Coder insert(Coder objCoder) {
        return this.objCoderRepository.save(objCoder);
    }

    // Servicio para actualizar un coder
    public Coder update(Long id, Coder objCoder) {
        // Buscar al coder con el id recibido
        Coder objCoderDB = this.finById(id);
        // Verificar que exista
        if (objCoderDB == null) {
            return null;
        }
        // Actualizar el coder antiguo
        objCoderDB = objCoder;
        // Guardarlo
        return this.objCoderRepository.save(objCoderDB);
    }

    // Servicio para encontrar por id
    public Coder finById(Long id) {
        return this.objCoderRepository.findById(id).orElse(null);
    }

    // Servicio para borrar por id
    public void delete(Long id) {
        this.objCoderRepository.deleteById(id);
    }

    // Servicio para obtener todos los Coders paginados
    public Page<Coder> findPaginated(int page, int size) {
        if (page < 0) {
            page = 1;
        }
        // Crear objeto de tipo paginación
        Pageable objPageable = PageRequest.of(page, size);
        return this.objCoderRepository.findAll(objPageable);
    }
}
