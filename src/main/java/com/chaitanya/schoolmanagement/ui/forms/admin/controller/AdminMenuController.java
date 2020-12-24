package com.chaitanya.schoolmanagement.ui.forms.admin.controller;

import com.chaitanya.schoolmanagement.ui.forms.admin.view.AdminMenuFrame;
import com.chaitanya.schoolmanagement.ui.forms.course.controller.CourseController;
import com.chaitanya.schoolmanagement.ui.forms.student.controller.StudentController;
import com.chaitanya.schoolmanagement.ui.forms.teacher.controller.TeacherController;
import com.chaitanya.schoolmanagement.ui.shared.controller.AbstractFrameController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class AdminMenuController extends AbstractFrameController {

    private final AdminMenuFrame adminMenuFrame;
    private final StudentController studentController;
    private final TeacherController teacherController;
    private final CourseController courseController;



    public void prepareAndOpenFrame() {
        registerAction(adminMenuFrame.getStudentBtn(), (e) -> createStudentWindow());
        registerAction(adminMenuFrame.getTeacherBtn(), (e) -> teacherWindow());
        registerAction(adminMenuFrame.getCourseBtn(), (e) -> courseWindow());
        adminMenuFrame.setVisible(true);
    }

    private void courseWindow() {
        courseController.prepareAndOpenFrame();
    }

    private void teacherWindow() {
        teacherController.prepareAndOpenFrame();
    }

    private void createStudentWindow() {
        studentController.prepareAndOpenFrame();
    }


}
