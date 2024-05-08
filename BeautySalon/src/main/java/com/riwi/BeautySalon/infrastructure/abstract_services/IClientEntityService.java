package com.riwi.BeautySalon.infrastructure.abstract_services;

import com.riwi.BeautySalon.api.dto.request.ClientEntityReq;
import com.riwi.BeautySalon.api.dto.response.ClientEntityResp;

public interface IClientEntityService extends CrudService<ClientEntityReq, ClientEntityResp, Long> {
    public String FIELD_BY_SORT = "firstName";
}