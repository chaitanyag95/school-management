package com.chaitanya.schoolmanagement.validation;

import java.util.Optional;

public interface Validator<K> {

    Optional<ValidationError> validate(K k);

    Optional<ValidationError> validateUpdateEntity(K k);

}
