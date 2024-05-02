package com.riwi.RelationsInSpringboot.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.RelationsInSpringboot.entities.Company;
import com.riwi.RelationsInSpringboot.entities.Vacant;
import com.riwi.RelationsInSpringboot.repositories.CompanyRepository;
import com.riwi.RelationsInSpringboot.repositories.VacantRepository;
import com.riwi.RelationsInSpringboot.services.interfaces.IVacantService;
import com.riwi.RelationsInSpringboot.utils.dto.request.VacantRequest;
import com.riwi.RelationsInSpringboot.utils.dto.response.CompanyToVacantResponse;
import com.riwi.RelationsInSpringboot.utils.dto.response.VacantResponse;
import com.riwi.RelationsInSpringboot.utils.enums.StatusVacant;
import com.riwi.RelationsInSpringboot.utils.exceptions.IdNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VacantService implements IVacantService {

    @Autowired
    private final VacantRepository objVacantRepository;
    @Autowired
    private final CompanyRepository objCompanyRepository;

    @Override
    public Page<VacantResponse> getAll(int page, int size) {
        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        return this.objVacantRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public VacantResponse create(VacantRequest request) {
        Company objCompany = this.objCompanyRepository.findById(request.getIdCompany())
                .orElseThrow(() -> new IdNotFoundException("Company"));

        Vacant objVacant = this.requestToVacant(request, new Vacant());
        objVacant.setCompany(objCompany);
        return this.entityToResponse(this.objVacantRepository.save(objVacant));
    }

    @Override
    public VacantResponse update(VacantRequest request, String id) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public VacantResponse getById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    private VacantResponse entityToResponse(Vacant entity) {
        VacantResponse response = new VacantResponse();
        BeanUtils.copyProperties(entity, response);
        CompanyToVacantResponse companyDto = new CompanyToVacantResponse();
        BeanUtils.copyProperties(entity.getCompany(), companyDto);
        response.setCompany(companyDto);
        return response;
    }

    private Vacant requestToVacant(VacantRequest request, Vacant entity) {
        BeanUtils.copyProperties(request, entity);
        entity.setStatus(StatusVacant.ACTIVE);
        return entity;
    }
}
