package com.riwi.RelationsInSpringboot.services.interfaces;

import com.riwi.RelationsInSpringboot.utils.dto.request.CompanyRequest;
import com.riwi.RelationsInSpringboot.utils.dto.response.CompanyResponse;

public interface ICompanyService extends CrudService<CompanyRequest, CompanyResponse, String> {

}
