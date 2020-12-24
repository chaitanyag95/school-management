package com.chaitanya.schoolmanagement.validation.course;


import com.chaitanya.schoolmanagement.model.course.Course;
import com.chaitanya.schoolmanagement.validation.ValidationError;
import com.chaitanya.schoolmanagement.validation.ValidationSupport;
import com.chaitanya.schoolmanagement.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;


@Component
public class CourseValidator extends ValidationSupport implements Validator<Course> {

    @Override
    public Optional<ValidationError> validate(Course course) {
        if (isNullOrEmptyString(course.getName())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}
