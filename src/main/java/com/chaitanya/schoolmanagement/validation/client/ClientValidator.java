package com.chaitanya.schoolmanagement.validation.client;


import com.chaitanya.schoolmanagement.model.ClientEntity;
import com.chaitanya.schoolmanagement.validation.ValidationError;
import com.chaitanya.schoolmanagement.validation.ValidationSupport;
import com.chaitanya.schoolmanagement.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.chaitanya.schoolmanagement.util.constant.ConstMessagesPL.ValidationMessages.PESEL_LENGTH_INCORRECT;
import static com.chaitanya.schoolmanagement.util.constant.ConstMessagesPL.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;


@Component
public class ClientValidator extends ValidationSupport implements Validator<ClientEntity> {

    private static final int PESEL_LENGTH = 11;

    @Override
    public Optional<ValidationError> validate(ClientEntity client) {
        if (isNullOrEmptyString(client.getName()) ||
                isNullOrEmptyString(client.getSurname()) ||
                isNullOrEmptyString(client.getPesel()) ||
                isNullOrEmptyString(client.getPhoneNumber()) ||
                isNullOrEmptyString(client.getEmail())){
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        if (PESEL_LENGTH != client.getPesel().length()) {
            return Optional.of(new ValidationError(PESEL_LENGTH_INCORRECT));
        }
        return Optional.empty();
    }

}
