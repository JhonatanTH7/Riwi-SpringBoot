package com.riwi.BeautySalon.infrastructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.BeautySalon.api.dto.request.ServiceEntityReq;
import com.riwi.BeautySalon.api.dto.response.ServiceEntityResp;
import com.riwi.BeautySalon.domain.repositories.ServiceEntityRepository;
import com.riwi.BeautySalon.infrastructure.abstract_services.IServiceEntityService;
import com.riwi.BeautySalon.utils.enums.SortType;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class SericeEntityService implements IServiceEntityService {

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
        this.objServiceEntityRepository.findAll(pagination);
        return null;
    }

    @Override
    public ServiceEntityResp get(Long id) {
        return null;
    }

    @Override
    public ServiceEntityResp create(ServiceEntityReq request) {
        return null;
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public ServiceEntityResp update(ServiceEntityReq request, Long id) {
        return null;
    }

    @Override
    public List<ServiceEntityResp> search(String name) {
        return null;
    }

}
