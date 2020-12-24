package com.chaitanya.schoolmanagement.ui.forms.student.controller;

import com.chaitanya.schoolmanagement.model.course.Course;
import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.service.course.CourseService;
import com.chaitanya.schoolmanagement.service.student.StudentService;
import com.chaitanya.schoolmanagement.ui.forms.student.model.CourseComboBoxModel;
import com.chaitanya.schoolmanagement.ui.forms.student.model.StudentTableModel;
import com.chaitanya.schoolmanagement.ui.forms.student.view.StudentFrame;
import com.chaitanya.schoolmanagement.ui.forms.student.view.TableBtnPanel;
import com.chaitanya.schoolmanagement.ui.forms.student.view.UpdateStudentFrame;
import com.chaitanya.schoolmanagement.ui.forms.student.view.modal.*;
import com.chaitanya.schoolmanagement.ui.shared.controller.AbstractFrameController;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import com.chaitanya.schoolmanagement.util.notification.Notifications;
import com.chaitanya.schoolmanagement.validation.ValidationError;
import com.chaitanya.schoolmanagement.validation.client.ClientValidator;
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
public class StudentController extends AbstractFrameController {

    private final StudentFrame studentFrame;
    private final AddStudentFrame addStudentFrame;
    private final StudentTableModel studentTableModel;
    private final StudentService studentService;
    private final ClientValidator clientValidator;
    private final CourseService courseService;
    private final CourseComboBoxModel courseComboBoxModel;
    private final UpdateStudentFrame updateStudentFrame;
    private final UpdateStudentFormPanel updateStudentFormPanel;


    @PostConstruct
    private void prepareListeners() {
        TableBtnPanel tableBtnPanel = studentFrame.getTableBtnPanel();
        FormBtnPanel formBtnPanel = addStudentFrame.getFormBtnPanel();
        UpdateStudentFormBtnPanel updateStudentFormBtnPanel = updateStudentFrame.getFormBtnPanel();

        registerAction(tableBtnPanel.getAddBtn(), (e) -> showAddClientModal());
        registerAction(tableBtnPanel.getRemoveBtn(), (e) -> removeClient());
        registerAction(formBtnPanel.getSaveBtn(), (e) -> saveClient());
        registerAction(formBtnPanel.getCancelBtn(), (e) -> closeModalWindow());
        registerAction(tableBtnPanel.getEditBtn(), (e) -> updateStudent());
        registerAction(updateStudentFormBtnPanel.getSaveBtn(), (e) -> updateStudentDetails());
        registerAction(updateStudentFormBtnPanel.getSaveBtn(), (e) -> closeUpdateModalWindow());
    }

    @Override
    public void prepareAndOpenFrame() {
        loadClients();
        showClientsFrame();
        loadAddresses();
    }

    private void loadClients() {
        List<Student> students = studentService.findAll();
        studentTableModel.clear();
        studentTableModel.addEntities(students);
    }

    private void loadStudent(Student student) {
        updateStudentFormPanel.setStudentForm(student);
    }

    private void loadAddresses() {
        List<Course> addresses = courseService.findAll();
        courseComboBoxModel.clear();
        courseComboBoxModel.addElements(addresses);
    }


    private void showClientsFrame() {
        studentFrame.setVisible(true);
    }

    private void showUpdateStudentFrame() {
        updateStudentFrame.setVisible(true);
    }

    private void showAddClientModal() {
        addStudentFrame.setVisible(true);
    }


    private void saveClient() {
        FormPanel formPanel = addStudentFrame.getFormPanel();
        Student student = formPanel.getStudentFromForm();
        Optional<ValidationError> errors = clientValidator.validate(student);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            studentService.save(student);
            studentTableModel.addEntity(student);
            closeModalWindow();
        }
    }

    private void updateStudentDetails() {
        log.info("********** updating existing student record ***********");
        UpdateStudentFormPanel formPanel = updateStudentFrame.getFormPanel();
        Student student = formPanel.getStudentFromUpdateStudentForm();
        Optional<ValidationError> errors = clientValidator.validate(student);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            studentService.updateStudentDetails(student);
            studentTableModel.addEntity(student);
            closeModalWindow();
        }
    }

    private void closeModalWindow() {
        addStudentFrame.getFormPanel().clearForm();
        addStudentFrame.dispose();
    }

    private void closeUpdateModalWindow() {
        updateStudentFrame.getFormPanel().clearForm();
        updateStudentFrame.dispose();
    }

    private void removeClient() {
        try {
            JTable studentTable = studentFrame.getStudentTablePanel().getStudentTable();
            int selectedRow = studentTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null,
                        ConstMessagesEN.Messages.NON_ROW_SELECTED,
                        ConstMessagesEN.Messages.ALERT_TILE,
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Student student = studentTableModel.getEntityByRow(selectedRow);
                studentService.remove(student);
                studentTableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

    private void updateStudent() {
        try {
            JTable studentTable = studentFrame.getStudentTablePanel().getStudentTable();
            int selectedRow = studentTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null,
                        ConstMessagesEN.Messages.NON_ROW_SELECTED,
                        ConstMessagesEN.Messages.ALERT_TILE,
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Student student = studentTableModel.getEntityByRow(selectedRow);
                showUpdateStudentForm(student);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

    private void showUpdateStudentForm(Student student) {
        loadStudent(student);
        showUpdateStudentFrame();
    }


}
