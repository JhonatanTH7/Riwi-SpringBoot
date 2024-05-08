package com.riwi.BeautySalon.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.BeautySalon.domain.entities.ClientEntity;

@Repository
public interface ClientEntityRepository extends JpaRepository<ClientEntity, Long> {

}
