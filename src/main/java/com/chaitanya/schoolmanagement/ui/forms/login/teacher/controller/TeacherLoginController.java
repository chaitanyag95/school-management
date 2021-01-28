package com.chaitanya.schoolmanagement.ui.forms.login.teacher.controller;


import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.model.teacher.Teacher;
import com.chaitanya.schoolmanagement.payload.LoginDto;
import com.chaitanya.schoolmanagement.service.login.LoginService;
import com.chaitanya.schoolmanagement.service.teacher.TeacherService;
import com.chaitanya.schoolmanagement.ui.forms.admin.controller.AdminMenuController;
import com.chaitanya.schoolmanagement.ui.forms.login.teacher.view.TeacherLoginFormBtnPanel;
import com.chaitanya.schoolmanagement.ui.forms.login.teacher.view.TeacherLoginFormPanel;
import com.chaitanya.schoolmanagement.ui.forms.login.teacher.view.TeacherLoginFrame;
import com.chaitanya.schoolmanagement.ui.forms.student.welcome.controller.WelcomeStudentController;
import com.chaitanya.schoolmanagement.ui.forms.teacher.dashboard.controller.TeacherDashboardController;
import com.chaitanya.schoolmanagement.ui.shared.controller.AbstractFrameController;
import com.chaitanya.schoolmanagement.util.notification.Notifications;
import com.chaitanya.schoolmanagement.validation.ValidationError;
import com.chaitanya.schoolmanagement.validation.login.LoginValidator;
import com.chaitanya.schoolmanagement.validation.login.TeacherLoginValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Controller
@AllArgsConstructor
@Slf4j
public class TeacherLoginController extends AbstractFrameController {

    private final TeacherLoginFrame teacherLoginFrame;
    private final LoginService loginService;
    private final TeacherLoginValidator loginValidator;
    private final TeacherDashboardController teacherDashboardController;
    private final TeacherService teacherService;

    @PostConstruct
    private void prepareListeners() {
        TeacherLoginFormBtnPanel formBtnPanel = teacherLoginFrame.getTeacherLoginFormBtnPanel();
        registerAction(formBtnPanel.getLoginBtn(), (e) -> login());
        registerAction(formBtnPanel.getCancelBtn(), (e) -> closeModalWindow());
    }

    @Override
    public void prepareAndOpenFrame() {
        showClientsFrame();
    }

    private void showClientsFrame() {
        teacherLoginFrame.setVisible(true);
    }


    private void login() {
        log.info(" ********* login teacher from Teacher Login Controller ************* ");
        TeacherLoginFormPanel formPanel = teacherLoginFrame.getTeacherLoginFormPanel();
        LoginDto teacherLoginDto = formPanel.getTeacherFromForm();
        Optional<ValidationError> errors = loginValidator.validate(teacherLoginDto);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            if (loginService.verifyTeacherCredentials(teacherLoginDto)) {
                Teacher teacher = teacherService.getTeacherByEmail(teacherLoginDto.getEmail());
                teacherDashboardController.prepareAndOpenFrame(teacher);
                closeModalWindow();
            }
        }
    }

    private void closeModalWindow() {
        teacherLoginFrame.getTeacherLoginFormPanel().clearForm();
        teacherLoginFrame.dispose();
    }

}
