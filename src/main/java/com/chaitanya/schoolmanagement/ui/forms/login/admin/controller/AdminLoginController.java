package com.chaitanya.schoolmanagement.ui.forms.login.admin.controller;


import com.chaitanya.schoolmanagement.payload.LoginDto;
import com.chaitanya.schoolmanagement.service.login.LoginService;
import com.chaitanya.schoolmanagement.ui.forms.admin.controller.AdminMenuController;
import com.chaitanya.schoolmanagement.ui.forms.login.admin.view.AdminLoginFormBtnPanel;
import com.chaitanya.schoolmanagement.ui.forms.login.admin.view.AdminLoginFormPanel;
import com.chaitanya.schoolmanagement.ui.forms.login.admin.view.AdminLoginFrame;
import com.chaitanya.schoolmanagement.ui.shared.controller.AbstractFrameController;
import com.chaitanya.schoolmanagement.util.notification.Notifications;
import com.chaitanya.schoolmanagement.validation.ValidationError;
import com.chaitanya.schoolmanagement.validation.login.LoginValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class AdminLoginController extends AbstractFrameController {

    private final AdminLoginFrame adminLoginFrame;
    private final LoginService loginService;
    private final LoginValidator loginValidator;
    private final AdminMenuController adminMenuController;

    @PostConstruct
    private void prepareListeners() {
        AdminLoginFormBtnPanel formBtnPanel = adminLoginFrame.getAdminLoginFormBtnPanel();
        registerAction(formBtnPanel.getLoginBtn(), (e) -> login());
        registerAction(formBtnPanel.getCancelBtn(), (e) -> closeModalWindow());
    }

    @Override
    public void prepareAndOpenFrame() {
        showClientsFrame();
    }

    private void showClientsFrame() {
        adminLoginFrame.setVisible(true);
    }


    private void login() {
        AdminLoginFormPanel formPanel = adminLoginFrame.getAdminLoginFormPanel();
        LoginDto admin = formPanel.getClientFromForm();
        Optional<ValidationError> errors = loginValidator.validate(admin);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            if (loginService.verifyAdminCredentials(admin)) {
                adminMenuController.prepareAndOpenFrame();
                closeModalWindow();
            }
        }
    }

    private void closeModalWindow() {
        adminLoginFrame.getAdminLoginFormPanel().clearForm();
        adminLoginFrame.dispose();
    }

}
