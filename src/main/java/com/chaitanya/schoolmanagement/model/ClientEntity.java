package com.chaitanya.schoolmanagement.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ClientEntity {
    @Id
    private String id = UUID.randomUUID().toString();

    private String name;

    private String surname;

    private String pesel;

    private String phoneNumber;

    private String email;

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
