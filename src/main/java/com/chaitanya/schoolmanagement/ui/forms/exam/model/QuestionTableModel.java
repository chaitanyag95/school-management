package com.chaitanya.schoolmanagement.ui.forms.exam.model;

import com.chaitanya.schoolmanagement.model.exam.Question;
import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import com.chaitanya.schoolmanagement.ui.shared.model.DefaultTableModel;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class QuestionTableModel extends DefaultTableModel<Question> {

    private static final int QUESTION_NO_INDEX = 0;
    private static final int QUESTION_INDEX = 1;


    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.QUESTION_NO,
                ConstMessagesEN.Labels.QUESTION_NO,
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Question question = entities.get(rowIndex);

        switch (columnIndex) {
            case QUESTION_NO_INDEX:
                return question.getQuestionNo();
            case QUESTION_INDEX:
                return question.getQuestion();
            default:
                return Strings.EMPTY;
        }
    }
}
