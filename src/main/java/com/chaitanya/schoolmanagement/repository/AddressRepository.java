package com.chaitanya.schoolmanagement.repository;


import com.chaitanya.schoolmanagement.model.address.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
