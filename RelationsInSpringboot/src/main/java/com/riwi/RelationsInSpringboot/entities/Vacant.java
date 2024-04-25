package com.riwi.RelationsInSpringboot.entities;

import com.riwi.RelationsInSpringboot.utils.enums.StatusVacant;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;

@Entity(name = "vacancies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vacant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private StatusVacant status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCompany", referencedColumnName = "id")
    private Company company;
}