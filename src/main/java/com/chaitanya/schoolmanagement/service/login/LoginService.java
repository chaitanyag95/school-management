package com.chaitanya.schoolmanagement.service.login;

import com.chaitanya.schoolmanagement.model.admin.Admin;
import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.model.teacher.Teacher;
import com.chaitanya.schoolmanagement.payload.LoginDto;
import com.chaitanya.schoolmanagement.payload.StudentLoginDto;
import com.chaitanya.schoolmanagement.payload.TeacherLoginDto;
import com.chaitanya.schoolmanagement.service.admin.AdminService;
import com.chaitanya.schoolmanagement.service.student.StudentService;
import com.chaitanya.schoolmanagement.service.teacher.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginService {
    @Autowired
    private AdminService adminService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;


    public Boolean verifyAdminCredentials(LoginDto adminLoginDto) {
        log.info(" ********* admin login  from login service ********** ");
        Admin admin = adminService.findAdminByEmail(adminLoginDto.getEmail());
        if (admin != null) {
            if (bCryptPasswordEncoder.matches(adminLoginDto.getPassword(), admin.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public Boolean verifyTeacherCredentials(LoginDto teacherLoginDto) {
        log.info(" ********* teacher login  from login service ********** ");
        Teacher teacher = teacherService.findTeacherByEmail(teacherLoginDto.getEmail());
        if (teacher != null) {
            if (bCryptPasswordEncoder.matches(teacherLoginDto.getPassword(), teacher.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public Boolean verifyStudentCredentials(LoginDto studentLoginDto) {
        log.info(" ********* student login  from login service ********** ");
        Student student = studentService.getStudentByEmail(studentLoginDto.getEmail());
        if (student != null) {
            if (bCryptPasswordEncoder.matches(studentLoginDto.getPassword(), student.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
