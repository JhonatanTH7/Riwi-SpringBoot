package com.riwi.RelationsInSpringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.RelationsInSpringboot.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

}
