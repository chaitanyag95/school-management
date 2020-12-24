package com.chaitanya.schoolmanagement.ui.forms.course.model;

import com.chaitanya.schoolmanagement.model.course.Course;
import com.chaitanya.schoolmanagement.ui.shared.model.DefaultTableModel;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class CourseTableModel extends DefaultTableModel<Course> {

    private static final int STREET_INDEX = 0;


    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.COURSE_NAME};
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Course course = entities.get(rowIndex);

        switch (columnIndex) {
            case STREET_INDEX:
                return course.getName();
            default:
                return Strings.EMPTY;
        }
    }

}
