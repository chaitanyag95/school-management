package com.chaitanya.schoolmanagement.validation.login;

import com.chaitanya.schoolmanagement.payload.LoginDto;
import com.chaitanya.schoolmanagement.service.login.LoginService;
import com.chaitanya.schoolmanagement.validation.ValidationError;
import com.chaitanya.schoolmanagement.validation.ValidationSupport;
import com.chaitanya.schoolmanagement.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN.ValidationMessages.INVALID_CREDENTIALS;
import static com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class TeacherLoginValidator extends ValidationSupport implements Validator<LoginDto> {
    @Autowired
    private LoginService loginService;


    @Override
    public Optional<ValidationError> validate(LoginDto loginDto) {
        if (isNullOrEmptyString(loginDto.getEmail()) ||
                isNullOrEmptyString(loginDto.getPassword())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        if (!loginService.verifyTeacherCredentials(loginDto)) {
            return Optional.of(new ValidationError(INVALID_CREDENTIALS));
        }
        return Optional.empty();
    }

    @Override
    public Optional<ValidationError> validateUpdateEntity(LoginDto loginDto) {
        return Optional.empty();
    }
}
