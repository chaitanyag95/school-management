package com.chaitanya.schoolmanagement.model.course;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    private String id = UUID.randomUUID().toString();

    private String name;


    public Course(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
