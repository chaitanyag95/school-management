package com.chaitanya.schoolmanagement.ui.forms.teacher.model;


import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.model.teacher.Teacher;
import com.chaitanya.schoolmanagement.ui.shared.model.DefaultTableModel;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class TeacherTableModel extends DefaultTableModel<Teacher> {

    private static final int NAME_INDEX = 0;
    private static final int COURSE_INDEX = 1;
    private static final int PHONE_NUMBER_INDEX = 2;
    private static final int EMAIL_INDEX = 3;


    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.NAME,
                ConstMessagesEN.Labels.COURSE,
                ConstMessagesEN.Labels.PHONE_NUMBER,
                ConstMessagesEN.Labels.EMAIL
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Teacher teacher = entities.get(rowIndex);

        switch (columnIndex) {
            case NAME_INDEX:
                return teacher.getFullName();
            case COURSE_INDEX:
                return teacher.getCourse();
            case PHONE_NUMBER_INDEX:
                return teacher.getPhoneNumber();
            case EMAIL_INDEX:
                return teacher.getEmail();
            default:
                return Strings.EMPTY;
        }
    }
}
