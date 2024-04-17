package com.riwi.FirstWebPage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.FirstWebPage.entity.Coder;

// Indicamos que es un repositorio
@Repository
// JpaRepository recibe la entidad y el tipo de dato de la clave primaria
public interface CoderRepository extends JpaRepository<Coder, Long> {
}
