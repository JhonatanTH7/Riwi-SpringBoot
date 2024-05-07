package com.riwi.BeautySalon.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

import com.riwi.BeautySalon.utils.enums.SortType;

public interface CrudService<RQ, RS, ID> {
    public Page<RS> getAll(int page, int size, SortType sortType);

    public RS get(ID id);

    public RS create(RQ request);

    public void delete(ID id);

    public RS update(RQ request, ID id);

}
