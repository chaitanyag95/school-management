package com.chaitanya.schoolmanagement.ui.forms.teacher.controller;

import com.chaitanya.schoolmanagement.model.course.Course;
import com.chaitanya.schoolmanagement.model.teacher.Teacher;
import com.chaitanya.schoolmanagement.service.course.CourseService;
import com.chaitanya.schoolmanagement.service.teacher.TeacherService;
import com.chaitanya.schoolmanagement.ui.forms.student.model.CourseComboBoxModel;
import com.chaitanya.schoolmanagement.ui.forms.teacher.model.TeacherTableModel;
import com.chaitanya.schoolmanagement.ui.forms.teacher.view.TeacherFrame;
import com.chaitanya.schoolmanagement.ui.forms.teacher.view.TeacherTableBtnPanel;
import com.chaitanya.schoolmanagement.ui.forms.teacher.view.UpdateTeacherFrame;
import com.chaitanya.schoolmanagement.ui.forms.teacher.view.modal.*;
import com.chaitanya.schoolmanagement.ui.shared.controller.AbstractFrameController;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import com.chaitanya.schoolmanagement.util.notification.Notifications;
import com.chaitanya.schoolmanagement.validation.ValidationError;
import com.chaitanya.schoolmanagement.validation.teacher.TeacherValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@Slf4j
public class TeacherController extends AbstractFrameController {
    private final TeacherFrame teacherFrame;
    private final AddTeacherFrame addTeacherFrame;
    private final TeacherTableModel teacherTableModel;
    private final TeacherService teacherService;
    private final TeacherValidator teacherValidator;
    private final CourseService courseService;
    private final CourseComboBoxModel courseComboBoxModel;
    private final UpdateTeacherFrame updateTeacherFrame;
    private final UpdateTeacherFormPanel updateTeacherFormPanel;


    @PostConstruct
    private void prepareListeners() {
        TeacherTableBtnPanel tableBtnPanel = teacherFrame.getTeacherTableBtnPanel();
        TeacherFormBtnPanel formBtnPanel = addTeacherFrame.getTeacherFormBtnPanel();
        UpdateTeacherFormBtnPanel updateTeacherFormBtnPanel = updateTeacherFrame.getFormBtnPanel();
        registerAction(tableBtnPanel.getRemoveBtn(), (e) -> removeClient());
        registerAction(formBtnPanel.getSaveBtn(), (e) -> saveClient());
        registerAction(tableBtnPanel.getAddBtn(), (e) -> showAddTeacherModal());
        registerAction(formBtnPanel.getCancelBtn(), (e) -> closeModalWindow());
        registerAction(tableBtnPanel.getEditBtn(), (e) -> updateTeacher());
        registerAction(updateTeacherFormBtnPanel.getSaveBtn(), (e) -> updateStudentDetails());
        registerAction(updateTeacherFormBtnPanel.getCancelBtn(), (e) -> closeUpdateModalWindow());
    }

    @Override
    public void prepareAndOpenFrame() {
        loadTeachers();
        showTeachersFrame();
        loadAddresses();
    }

    private void loadTeachers() {
        List<Teacher> teachers = teacherService.findAll();
        teacherTableModel.clear();
        teacherTableModel.addEntities(teachers);
    }

    private void loadTeacher(Teacher teacher) {
        updateTeacherFormPanel.setTeacherForm(teacher);
    }

    private void loadAddresses() {
        List<Course> addresses = courseService.findAll();
        courseComboBoxModel.clear();
        courseComboBoxModel.addElements(addresses);
    }


    private void showTeachersFrame() {
        teacherFrame.setVisible(true);
    }

    private void showUpdateStudentFrame() {
        updateTeacherFrame.setVisible(true);
    }

    private void showAddTeacherModal() {
        addTeacherFrame.setVisible(true);
    }


    private void saveClient() {
        TeacherFormPanel teacherFormPanel = addTeacherFrame.getTeacherFormPanel();
        Teacher teacher = teacherFormPanel.getTeacherFromForm();
        Optional<ValidationError> errors = teacherValidator.validate(teacher);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            teacherService.save(teacher);
            teacherTableModel.addEntity(teacher);
            closeModalWindow();
        }
    }

    private void updateStudentDetails() {
        log.info("********** updating existing teacher record ***********");
        UpdateTeacherFormPanel updateTeacherFormPanel = updateTeacherFrame.getFormPanel();
        Teacher teacher = updateTeacherFormPanel.getTeacherFromUpdateTeacherForm();
        Optional<ValidationError> errors = teacherValidator.validate(teacher);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            teacherService.updateTeacherDetails(teacher);
            teacherTableModel.addEntity(teacher);
            closeModalWindow();
        }
    }

    private void closeModalWindow() {
        addTeacherFrame.getTeacherFormPanel().clearForm();
        addTeacherFrame.dispose();
    }

    private void closeUpdateModalWindow() {
        updateTeacherFrame.getFormPanel().clearForm();
        updateTeacherFrame.dispose();
    }

    private void removeClient() {
        try {
            JTable teacherTable = teacherFrame.getTeacherTablePanel().getTeacherTable();
            int selectedRow = teacherTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null,
                        ConstMessagesEN.Messages.NON_ROW_SELECTED,
                        ConstMessagesEN.Messages.ALERT_TILE,
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Teacher teacher = teacherTableModel.getEntityByRow(selectedRow);
                teacherService.remove(teacher);
                teacherTableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

    private void updateTeacher() {
        try {
            JTable studentTable = teacherFrame.getTeacherTablePanel().getTeacherTable();
            int selectedRow = studentTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null,
                        ConstMessagesEN.Messages.NON_ROW_SELECTED,
                        ConstMessagesEN.Messages.ALERT_TILE,
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Teacher teacher = teacherTableModel.getEntityByRow(selectedRow);
                showUpdateTeacherForm(teacher);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

    private void showUpdateTeacherForm(Teacher teacher) {
        loadTeacher(teacher);
        showUpdateStudentFrame();
    }
}
