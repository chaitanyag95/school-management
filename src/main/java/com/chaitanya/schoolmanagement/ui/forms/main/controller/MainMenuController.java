package com.chaitanya.schoolmanagement.ui.forms.main.controller;

import com.chaitanya.schoolmanagement.ui.forms.course.controller.CourseController;
import com.chaitanya.schoolmanagement.ui.forms.admin.controller.AdminMenuController;
import com.chaitanya.schoolmanagement.ui.forms.login.admin.controller.AdminLoginController;
import com.chaitanya.schoolmanagement.ui.forms.login.student.controller.StudentLoginController;
import com.chaitanya.schoolmanagement.ui.forms.login.teacher.controller.TeacherLoginController;
import com.chaitanya.schoolmanagement.ui.forms.main.view.MainMenuFrame;
import com.chaitanya.schoolmanagement.ui.shared.controller.AbstractFrameController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class MainMenuController extends AbstractFrameController {

    private final MainMenuFrame mainMenuFrame;
    private final TeacherLoginController teacherLoginController;
    private final CourseController courseController;
    private final AdminMenuController adminMenuController;
    private final AdminLoginController adminLoginController;
    private final StudentLoginController studentLoginController;


    public void prepareAndOpenFrame() {
        registerAction(mainMenuFrame.getStudentBtn(), (e) -> openStudentWindow());
        registerAction(mainMenuFrame.getTeacherBtn(), (e) -> openTeacherWindow());
        registerAction(mainMenuFrame.getAdminBtn(), (e) -> openAdminWindow());
        mainMenuFrame.setVisible(true);
    }

    private void openAdminWindow() {
        adminLoginController.prepareAndOpenFrame();
    }

    private void openTeacherWindow() {
        teacherLoginController.prepareAndOpenFrame();
    }

    private void openStudentWindow() {
        studentLoginController.prepareAndOpenFrame();
    }


}
