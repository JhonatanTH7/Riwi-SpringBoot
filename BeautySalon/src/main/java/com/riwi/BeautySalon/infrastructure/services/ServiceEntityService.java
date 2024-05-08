package com.riwi.BeautySalon.infrastructure.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.BeautySalon.api.dto.request.ServiceEntityReq;
import com.riwi.BeautySalon.api.dto.response.ServiceEntityResp;
import com.riwi.BeautySalon.domain.entities.ServiceEntity;
import com.riwi.BeautySalon.domain.repositories.ServiceEntityRepository;
import com.riwi.BeautySalon.infrastructure.abstract_services.IServiceEntityService;
import com.riwi.BeautySalon.utils.enums.SortType;
import com.riwi.BeautySalon.utils.exceptions.BadRequestException;
import com.riwi.BeautySalon.utils.messages.ErrorMessages;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ServiceEntityService implements IServiceEntityService {

    @Autowired
    private final ServiceEntityRepository objServiceEntityRepository;

    @Override
    public Page<ServiceEntityResp> getAll(int page, int size, SortType sortType) {
        if (page < 0)
            page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }
        return this.objServiceEntityRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public ServiceEntityResp getById(Long id) {
        return entityToResponse(this.find(id));
    }

    @Override
    public ServiceEntityResp create(ServiceEntityReq request) {
        ServiceEntity objServiceEntity = this.requestToEntity(request);
        return this.entityToResponse(this.objServiceEntityRepository.save(objServiceEntity));
    }

    @Override
    public void delete(Long id) {
        this.objServiceEntityRepository.delete(find(id));
    }

    @Override
    public ServiceEntityResp update(ServiceEntityReq request, Long id) {
        ServiceEntity objServiceEntity = this.find(id);
        objServiceEntity = this.requestToEntity(request);
        objServiceEntity.setId(id);
        return this.entityToResponse(this.objServiceEntityRepository.save(objServiceEntity));
    }

    @Override
    public List<ServiceEntityResp> search(String name) {
        return null;
    }

    private ServiceEntityResp entityToResponse(ServiceEntity objServiceEntity) {
        ServiceEntityResp objServiceEntityResp = new ServiceEntityResp();
        BeanUtils.copyProperties(objServiceEntity, objServiceEntityResp);
        return objServiceEntityResp;
    }

    private ServiceEntity requestToEntity(ServiceEntityReq objServiceEntityReq) {
        ServiceEntity objServiceEntity = new ServiceEntity();
        BeanUtils.copyProperties(objServiceEntityReq, objServiceEntity);
        return objServiceEntity;
    }

    private ServiceEntity find(Long id) {
        return this.objServiceEntityRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("service")));
    }

}
