package com.chaitanya.schoolmanagement.validation.teacher;


import com.chaitanya.schoolmanagement.model.teacher.Teacher;
import com.chaitanya.schoolmanagement.service.teacher.TeacherService;
import com.chaitanya.schoolmanagement.validation.ValidationError;
import com.chaitanya.schoolmanagement.validation.ValidationSupport;
import com.chaitanya.schoolmanagement.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;
import static com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN.ValidationMessages.USER_ALREADY_EXIST;


@Component
public class TeacherValidator extends ValidationSupport implements Validator<Teacher> {
    @Autowired
    private TeacherService teacherService;


    @Override
    public Optional<ValidationError> validate(Teacher teacher) {
        if (isNullOrEmptyString(teacher.getFullName()) ||
                isNullOrEmptyString(teacher.getPhoneNumber()) ||
                isNullOrEmptyString(teacher.getEmail())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        if (teacherService.isTeacherExistByEmail(teacher.getEmail())) {
            return Optional.of(new ValidationError(USER_ALREADY_EXIST));
        }
        return Optional.empty();
    }

}
