package com.riwi.BeautySalon.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntityResp {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private List<AppointmentToClient> appointments;
}
