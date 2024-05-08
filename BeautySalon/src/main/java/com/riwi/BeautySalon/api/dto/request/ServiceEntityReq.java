package com.riwi.BeautySalon.api.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceEntityReq {

    @NotNull(message = "El nombre del servicio es requerido")
    @NotBlank(message = "El nombre del servicio es requerido")
    private String name;
    private String description;
    @NotNull
    @DecimalMin(value = "0.01", message = "El valor del servicio debe ser mayor a 0")
    private BigDecimal price;
}
