package com.chaitanya.schoolmanagement.service.login;

import com.chaitanya.schoolmanagement.model.admin.Admin;
import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.model.teacher.Teacher;
import com.chaitanya.schoolmanagement.payload.LoginDto;
import com.chaitanya.schoolmanagement.payload.StudentLoginDto;
import com.chaitanya.schoolmanagement.payload.TeacherLoginDto;
import com.chaitanya.schoolmanagement.service.admin.AdminService;
import com.chaitanya.schoolmanagement.service.exam.QuestionPaperService;
import com.chaitanya.schoolmanagement.service.student.StudentService;
import com.chaitanya.schoolmanagement.service.teacher.TeacherService;
import com.opencsv.CSVWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
    @Autowired
    private QuestionPaperService questionPaperService;


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
                writeTeacherDetailsToCSVFile(teacher);
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
                writeStudentDetailsToCSVFile(student);
                return true;
            }
        }
        return false;
    }

    private void writeStudentDetailsToCSVFile(Student student) {
        // first create file object for file placed at location
        // specified by filepath
        log.info(" ********** reading user details . csv file stored in resource directory ************* ");
        File file = new File("/home/chaitannya/Persistence/src/main/resources/userDetails.csv");
        try {
            // create FileWriter object with file as parameter
            FileWriter outputFile = new FileWriter(file);

            // create CSVWriter object file writer object as parameter
            CSVWriter writer = new CSVWriter(outputFile);

            // adding header to csv
            String[] header = {"userId", "fullName", "email", "course"};
            writer.writeNext(header);


            // add data to csv
            String[] userDetails = {student.getId(), student.getFullName(), student.getEmail(), student.getCourse().getName()};
            writer.writeNext(userDetails);
            log.info(" ********** saving user details to  . csv file stored in resource directory ************* ");

            // closing writer connection
            writer.close();
        } catch (IOException e) {
            log.info("  Exception Occurred in saving login details   " + e.getMessage());
        }
    }

    private void writeTeacherDetailsToCSVFile(Teacher teacher) {
        // first create file object for file placed at location
        // specified by filepath
        log.info(" ********** reading teacher details . csv file stored in resource directory ************* ");
        File file = new File("/home/chaitannya/Persistence/src/main/resources/userDetails.csv");
        try {
            // create FileWriter object with file as parameter
            FileWriter outputFile = new FileWriter(file);
            // create CSVWriter object file writer object as parameter
            CSVWriter writer = new CSVWriter(outputFile);
            // adding header to csv
            String[] header = {"userId", "fullName", "email", "course"};
            writer.writeNext(header);
            // add data to csv
            String[] userDetails = {teacher.getId(), teacher.getFullName(), teacher.getEmail(), teacher.getCourse().getName()};
            writer.writeNext(userDetails);
            log.info(" ********** saving user details to  . csv file stored in resource directory ************* ");
            // closing writer connection
            writer.close();
        } catch (IOException e) {
            log.info("  Exception Occurred in saving login details   " + e.getMessage());
        }
    }

}
