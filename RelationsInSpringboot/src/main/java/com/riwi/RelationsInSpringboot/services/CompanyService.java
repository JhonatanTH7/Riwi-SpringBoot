package com.riwi.RelationsInSpringboot.services;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.RelationsInSpringboot.entities.Company;
import com.riwi.RelationsInSpringboot.entities.Vacant;
import com.riwi.RelationsInSpringboot.repositories.CompanyRepository;
import com.riwi.RelationsInSpringboot.services.interfaces.ICompanyService;
import com.riwi.RelationsInSpringboot.utils.dto.request.CompanyRequest;
import com.riwi.RelationsInSpringboot.utils.dto.response.CompanyResponse;
import com.riwi.RelationsInSpringboot.utils.dto.response.VacantToCompanyResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService {

    @Autowired
    private final CompanyRepository objCompanyRepository;

    @Override
    public Page<CompanyResponse> getAll(int page, int size) {
        if (page > 0) {
            page = 0;
        }
        PageRequest pagination = PageRequest.of(page, size);

        return this.objCompanyRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public CompanyResponse create(CompanyRequest request) {
        Company objCompany = this.requestToEntity(request, new Company());
        return this.entityToResponse(this.objCompanyRepository.save(objCompany));
    }

    @Override
    public CompanyResponse update(CompanyRequest request, String id) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public CompanyResponse getById(String id) {
        Company objCompany = this.find(id);
        return this.entityToResponse(objCompany);
    }

    private CompanyResponse entityToResponse(Company entity) {
        CompanyResponse response = new CompanyResponse();
        BeanUtils.copyProperties(entity, response);
        response.setVacants(entity.getVacants().stream().map(this::vacantToResponse).toList());
        return response;
    }

    private VacantToCompanyResponse vacantToResponse(Vacant entity) {
        VacantToCompanyResponse response = new VacantToCompanyResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }

    private Company requestToEntity(CompanyRequest entity, Company objCompany) {
        Company response = new Company();
        BeanUtils.copyProperties(entity, response);
        response.setVacants(new ArrayList<>());
        return response;
    }

    private Company find(String id) {
        return this.objCompanyRepository.findById(id).orElseThrow();
    }
}
