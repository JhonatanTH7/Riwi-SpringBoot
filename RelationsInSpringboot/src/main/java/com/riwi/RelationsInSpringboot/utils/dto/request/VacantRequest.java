package com.riwi.RelationsInSpringboot.utils.dto.request;

import com.riwi.RelationsInSpringboot.utils.enums.StatusVacant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacantRequest {
    @Size(min = 0, max = 255)
    @NotBlank(message = "El Titulo es requerido")
    private String title;
    @NotBlank(message = "La Descripción es requerida")
    private String description;
    private StatusVacant status;
    @Size(min = 0, max = 36)
    @NotBlank(message = "el id de la Compañia es requerido")
    private String idCompany;
}
