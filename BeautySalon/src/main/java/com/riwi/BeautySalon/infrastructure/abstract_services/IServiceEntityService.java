package com.riwi.BeautySalon.infrastructure.abstract_services;

import java.util.List;

import com.riwi.BeautySalon.api.dto.request.ServiceEntityReq;
import com.riwi.BeautySalon.api.dto.response.ServiceEntityResp;

public interface IServiceEntityService extends CrudService<ServiceEntityReq, ServiceEntityResp, Long> {

    public List<ServiceEntityResp> search(String name);

    public String FIELD_BY_SORT = "price";
}