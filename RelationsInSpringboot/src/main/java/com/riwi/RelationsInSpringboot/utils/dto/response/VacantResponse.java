package com.riwi.RelationsInSpringboot.utils.dto.response;

import com.riwi.RelationsInSpringboot.utils.enums.StatusVacant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VacantResponse {
    private String id;
    private String title;
    private String description;
    private StatusVacant status;
    private CompanyToVacantResponse company;
}
