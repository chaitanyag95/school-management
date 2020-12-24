package com.chaitanya.schoolmanagement.validation.client;


import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.service.student.StudentService;
import com.chaitanya.schoolmanagement.validation.ValidationError;
import com.chaitanya.schoolmanagement.validation.ValidationSupport;
import com.chaitanya.schoolmanagement.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;
import static com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN.ValidationMessages.USER_ALREADY_EXIST;


@Component
public class ClientValidator extends ValidationSupport implements Validator<Student> {
    @Autowired
    private StudentService studentService;


    @Override
    public Optional<ValidationError> validate(Student student) {
        if (isNullOrEmptyString(student.getFullName()) ||
                isNullOrEmptyString(student.getPhoneNumber()) ||
                isNullOrEmptyString(student.getEmail())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        if (studentService.isStudentExistByEmail(student.getEmail())) {
            return Optional.of(new ValidationError(USER_ALREADY_EXIST));
        }
        return Optional.empty();
    }

}
