package com.chaitanya.schoolmanagement.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherLoginDto {
    private String email;
    private String password;
}
