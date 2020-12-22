package com.chaitanya.schoolmanagement.service.address;


import com.chaitanya.schoolmanagement.model.address.AddressEntity;
import com.chaitanya.schoolmanagement.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public List<AddressEntity> findAll() {
        return addressRepository.findAll();
    }

    public void remove(AddressEntity address) {
        addressRepository.delete(address);
    }

    public void save(AddressEntity address) {
        addressRepository.save(address);
    }
}
