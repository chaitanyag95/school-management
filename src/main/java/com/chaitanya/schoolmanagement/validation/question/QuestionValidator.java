package com.chaitanya.schoolmanagement.validation.question;

import com.chaitanya.schoolmanagement.model.exam.Question;
import com.chaitanya.schoolmanagement.validation.ValidationError;
import com.chaitanya.schoolmanagement.validation.ValidationSupport;
import com.chaitanya.schoolmanagement.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class QuestionValidator extends ValidationSupport implements Validator<Question> {

    @Override
    public Optional<ValidationError> validate(Question question) {
        if (isNullOrEmptyString(question.getAnswerFour()) ||
                isNullOrEmptyString(question.getAnswerThree()) ||
                isNullOrEmptyString(question.getAnswerTwo()) ||
                isNullOrEmptyString(question.getAnswerOne()) ||
                isNullValue(question.getQuestionNo()) ||
                isNullOrEmptyString(question.getQuestion())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }

        return Optional.empty();
    }

    @Override
    public Optional<ValidationError> validateUpdateEntity(Question question) {
        return Optional.empty();
    }


}
