package com.riwi.RelationsInSpringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.RelationsInSpringboot.entities.Vacant;

@Repository
public interface VacantRepository extends JpaRepository<Vacant, String> {

}
