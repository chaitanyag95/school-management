package com.chaitanya.schoolmanagement.service.address;


import com.chaitanya.schoolmanagement.model.address.AddressEntity;
import com.chaitanya.schoolmanagement.util.annotation.TransactionalReadOnly;
import com.chaitanya.schoolmanagement.util.annotation.TransactionalWrite;

import java.util.List;

public interface AddressService {

    @TransactionalReadOnly
    List<AddressEntity> findAll();

    @TransactionalWrite
    void remove(AddressEntity address);

    @TransactionalWrite
    void save(AddressEntity address);
}
