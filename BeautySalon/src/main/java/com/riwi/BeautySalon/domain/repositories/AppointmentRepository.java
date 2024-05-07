package com.riwi.BeautySalon.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.riwi.BeautySalon.domain.entities.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("SELECT p FROM appointment p JOIN FETCH p.client c WHERE c.id = :idClient")
    public Optional<Appointment> findByClientId(Long idClient);
}
