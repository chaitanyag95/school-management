package com.chaitanya.schoolmanagement.ui.forms.course.controller;


import com.chaitanya.schoolmanagement.model.course.Course;
import com.chaitanya.schoolmanagement.service.course.CourseService;
import com.chaitanya.schoolmanagement.ui.forms.course.model.CourseTableModel;
import com.chaitanya.schoolmanagement.ui.forms.course.view.CourseTableBtnPanel;
import com.chaitanya.schoolmanagement.ui.forms.course.view.CourseTableFrame;
import com.chaitanya.schoolmanagement.ui.forms.course.view.modal.AddCourseFrame;
import com.chaitanya.schoolmanagement.ui.forms.course.view.modal.CourseFormBtnPanel;
import com.chaitanya.schoolmanagement.ui.forms.course.view.modal.CourseFormPanel;
import com.chaitanya.schoolmanagement.ui.shared.controller.AbstractFrameController;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import com.chaitanya.schoolmanagement.util.notification.Notifications;
import com.chaitanya.schoolmanagement.validation.ValidationError;
import com.chaitanya.schoolmanagement.validation.course.CourseValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class CourseController extends AbstractFrameController {

    private final CourseTableFrame tableFrame;
    private final AddCourseFrame addFrame;
    private final CourseTableModel tableModel;
    private final CourseService courseService;
    private final CourseValidator validator;

    @PostConstruct
    private void prepareListeners() {
        CourseTableBtnPanel tableBtnPanel = tableFrame.getTableBtnPanel();
        CourseFormBtnPanel formBtnPanel = addFrame.getFormBtnPanel();

        registerAction(tableBtnPanel.getAddBtn(), (e) -> showAddModal());
        registerAction(tableBtnPanel.getRemoveBtn(), (e) -> removeEntity());
        registerAction(formBtnPanel.getSaveBtn(), (e) -> saveEntity());
        registerAction(formBtnPanel.getCancelBtn(), (e) -> closeModalWindow());
    }

    @Override
    public void prepareAndOpenFrame() {
        loadEntities();
        showTableFrame();
    }

    private void loadEntities() {
        List<Course> entities = courseService.findAll();
        tableModel.clear();
        tableModel.addEntities(entities);
    }

    private void showTableFrame() {
        tableFrame.setVisible(true);
    }

    private void showAddModal() {
        addFrame.setVisible(true);
    }

    private void saveEntity() {
        CourseFormPanel formPanel = addFrame.getFormPanel();
        Course entity = formPanel.getEntityFromForm();
        Optional<ValidationError> errors = validator.validate(entity);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            courseService.save(entity);
            tableModel.addEntity(entity);
            closeModalWindow();
        }
    }

    private void closeModalWindow() {
        addFrame.getFormPanel().clearForm();
        addFrame.dispose();
    }

    private void removeEntity() {
        try {
            JTable clientTable = tableFrame.getTablePanel().getTable();
            int selectedRow = clientTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null,
                        ConstMessagesEN.Messages.NON_ROW_SELECTED,
                        ConstMessagesEN.Messages.ALERT_TILE,
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Course entity = tableModel.getEntityByRow(selectedRow);
                courseService.remove(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}
