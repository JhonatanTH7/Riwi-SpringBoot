package com.riwi.RelationsInSpringboot.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "companies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 40, nullable = false)
    private String name;
    @Column(length = 60, nullable = false)
    private String location;
    @Column(length = 15, nullable = false)
    private String contact;
    // mappedBy: Para especificar donde se esta mapeando en la otra entidad
    // cascade: Para especificar el tipo de cascada
    // orphanRemoval: Para especificar que un objeto huerfano (Sin llave foranea) será eliminado
    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Vacant> vacants;
}
