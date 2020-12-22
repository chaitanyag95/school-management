package com.chaitanya.schoolmanagement.model.address;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;


@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AddressEntity {
    @Id
    private String id = UUID.randomUUID().toString();

    private String street;

    private String flatNumber;

    private String city;

    private String postalCode;

    public AddressEntity(String street, String flatNumber, String city, String postalCode) {
        this.street = street;
        this.flatNumber = flatNumber;
        this.city = city;
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return street + " " +
                flatNumber + "/" +
                city + " " +
                postalCode;
    }
}
