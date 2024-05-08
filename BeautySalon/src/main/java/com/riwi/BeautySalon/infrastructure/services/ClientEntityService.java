package com.riwi.BeautySalon.infrastructure.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.BeautySalon.api.dto.request.ClientEntityReq;
import com.riwi.BeautySalon.api.dto.response.AppointmentToClient;
import com.riwi.BeautySalon.api.dto.response.ClientEntityResp;
import com.riwi.BeautySalon.api.dto.response.EmployeeResp;
import com.riwi.BeautySalon.api.dto.response.ServiceEntityResp;
import com.riwi.BeautySalon.domain.entities.Appointment;
import com.riwi.BeautySalon.domain.entities.ClientEntity;
import com.riwi.BeautySalon.domain.repositories.ClientEntityRepository;
import com.riwi.BeautySalon.infrastructure.abstract_services.IClientEntityService;
import com.riwi.BeautySalon.utils.enums.SortType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientEntityService implements IClientEntityService {

    @Autowired
    private final ClientEntityRepository objClientEntityRepository;

    @Override
    public Page<ClientEntityResp> getAll(int page, int size, SortType sortType) {
        if (page < 0)
            page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }
        return this.objClientEntityRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public ClientEntityResp getById(Long id) {
        return null;
    }

    @Override
    public ClientEntityResp create(ClientEntityReq request) {
        return null;
    }

    @Override
    public ClientEntityResp update(ClientEntityReq request, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
    }

    public ClientEntityResp entityToResponse(ClientEntity entity) {
        List<AppointmentToClient> listAppointmentsToClient = entity.getAppointments().stream()
                .map(this::appointmentToAppointmentToClient).toList();

        return ClientEntityResp.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .appointments(listAppointmentsToClient)
                .build();
    }

    public AppointmentToClient appointmentToAppointmentToClient(Appointment appointment) {
        ServiceEntityResp objServiceEntityResp = new ServiceEntityResp();

        BeanUtils.copyProperties(appointment.getService(), objServiceEntityResp);

        EmployeeResp objEmployeeResp = new EmployeeResp();

        BeanUtils.copyProperties(appointment.getEmployee(), objEmployeeResp);

        return AppointmentToClient.builder()
                .id(appointment.getId())
                .dateTime(appointment.getDateTime())
                .duration(appointment.getDuration())
                .comments(appointment.getComments())
                .service(objServiceEntityResp)
                .employee(objEmployeeResp)
                .build();
    }

}
