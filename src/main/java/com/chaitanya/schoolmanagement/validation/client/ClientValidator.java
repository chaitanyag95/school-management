package com.chaitanya.schoolmanagement.validation.client;


import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.validation.ValidationError;
import com.chaitanya.schoolmanagement.validation.ValidationSupport;
import com.chaitanya.schoolmanagement.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Optional;


import static com.chaitanya.schoolmanagement.util.constant.ConstMessagesPL.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;


@Component
public class ClientValidator extends ValidationSupport implements Validator<Student> {



    @Override
    public Optional<ValidationError> validate(Student student) {
        if (isNullOrEmptyString(student.getFullName()) ||
                isNullOrEmptyString(student.getCourse()) ||
                isNullOrEmptyString(student.getCourse()) ||
                isNullOrEmptyString(student.getPhoneNumber()) ||
                isNullOrEmptyString(student.getEmail())){
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}
