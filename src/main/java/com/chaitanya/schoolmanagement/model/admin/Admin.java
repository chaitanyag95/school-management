package com.chaitanya.schoolmanagement.model.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Admin {
    @Id
    private String id = UUID.randomUUID().toString();
    private String email;
    private String password;


    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return email;
    }
}
