package com.riwi.BeautySalon.api.dto.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceEntityResp {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
}
