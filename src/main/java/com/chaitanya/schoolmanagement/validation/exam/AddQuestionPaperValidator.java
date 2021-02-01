package com.chaitanya.schoolmanagement.validation.exam;

import com.chaitanya.schoolmanagement.payload.AddQuestionPaperDto;
import com.chaitanya.schoolmanagement.service.exam.QuestionPaperService;
import com.chaitanya.schoolmanagement.validation.ValidationError;
import com.chaitanya.schoolmanagement.validation.ValidationSupport;
import com.chaitanya.schoolmanagement.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN.ValidationMessages.*;

@Component
public class AddQuestionPaperValidator extends ValidationSupport implements Validator<AddQuestionPaperDto> {
    @Autowired
    private QuestionPaperService questionPaperService;


    @Override
    public Optional<ValidationError> validate(AddQuestionPaperDto addQuestionPaperDto) {
        if (isNullOrEmptyString(addQuestionPaperDto.getPaperTitle()) ||
                isNullOrEmptyString(addQuestionPaperDto.getPaperDsc())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        if (questionPaperService.isQuestionPaperExistByPaperCode(addQuestionPaperDto)) {
            return Optional.of(new ValidationError(QUESTION_PAPER_ALREADY_EXIST));
        }
        return Optional.empty();
    }

    @Override
    public Optional<ValidationError> validateUpdateEntity(AddQuestionPaperDto addQuestionPaperDto) {
        if (isNullOrEmptyString(addQuestionPaperDto.getPaperTitle()) ||
                isNullOrEmptyString(addQuestionPaperDto.getPaperDsc())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}
