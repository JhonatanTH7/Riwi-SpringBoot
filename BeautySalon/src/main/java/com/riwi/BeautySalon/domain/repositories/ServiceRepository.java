package com.riwi.BeautySalon.domain.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.riwi.BeautySalon.domain.entities.ServiceEntity;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {

    @Query("SELECT s FROM service s WHERE s.price BETWEEN :min AND :max")
    public List<ServiceEntity> selectBetweenPrice(BigDecimal min, BigDecimal max);

    @Query("SELECT s FROM service s WHERE s.name LIKE :search")
    public List<ServiceEntity> findByNameContains(String search);
}
