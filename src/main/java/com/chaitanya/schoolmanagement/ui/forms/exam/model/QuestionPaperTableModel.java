package com.chaitanya.schoolmanagement.ui.forms.exam.model;

import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.ui.shared.model.DefaultTableModel;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class QuestionPaperTableModel extends DefaultTableModel<QuestionPaper> {

    private static final int PAPER_CODE_INDEX = 0;
    private static final int PAPER_TITLE_INDEX = 1;
    private static final int COURSE_INDEX = 2;

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.PAPER_CODE,
                ConstMessagesEN.Labels.PAPER_TITLE,
                ConstMessagesEN.Labels.COURSE
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        QuestionPaper questionPaper = entities.get(rowIndex);

        switch (columnIndex) {
            case PAPER_CODE_INDEX:
                return questionPaper.getPaperCode();
            case PAPER_TITLE_INDEX:
                return questionPaper.getPaperTitle();
            case COURSE_INDEX:
                return questionPaper.getCourse();
            default:
                return Strings.EMPTY;
        }
    }
}
