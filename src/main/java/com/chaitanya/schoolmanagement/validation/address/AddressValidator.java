package com.chaitanya.schoolmanagement.validation.address;


import com.chaitanya.schoolmanagement.model.address.AddressEntity;
import com.chaitanya.schoolmanagement.validation.ValidationError;
import com.chaitanya.schoolmanagement.validation.ValidationSupport;
import com.chaitanya.schoolmanagement.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.chaitanya.schoolmanagement.util.constant.ConstMessagesPL.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;


@Component
public class AddressValidator extends ValidationSupport implements Validator<AddressEntity> {

    @Override
    public Optional<ValidationError> validate(AddressEntity address) {
        if (isNullOrEmptyString(address.getStreet())  ||
                isNullOrEmptyString(address.getFlatNumber()) ||
                isNullOrEmptyString(address.getCity()) ||
                isNullOrEmptyString(address.getPostalCode())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}
