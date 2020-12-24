package com.chaitanya.schoolmanagement.service.teacher;


import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.model.teacher.Teacher;
import com.chaitanya.schoolmanagement.payload.EmailDto;
import com.chaitanya.schoolmanagement.payload.TeacherLoginDto;
import com.chaitanya.schoolmanagement.repository.TeacherRepository;
import com.chaitanya.schoolmanagement.service.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
class TeacherServiceImpl implements TeacherService {

    public static final int NAME_INDEX = 0;
    public static final int EMAIL_INDEX = 1;
    public static final int COUNT_INDEX = 2;

    private final TeacherRepository teacherRepository;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public void save(Teacher teacher) {
        log.info("********** Saving teacher record ***********");
        String password = teacher.getPassword();
        teacher.setPassword(bCryptPasswordEncoder.encode(password));
        String content = "Welcome " + teacher.getFullName() + " to our school management application. Your Credentials are Username : " + teacher.getEmail() + " and  Password : " + password;
        EmailDto emailDto = new EmailDto(teacher.getEmail(), "Teacher Account Creation", content, teacher.getFullName());
        teacherRepository.save(teacher);
        try {
            log.info("****** notifying teacher for account creation ********");
            notificationService.sendEmail(emailDto);
        } catch (Exception e) {
            log.info("****** exception occurred in notifying teacher for account creation ********");
        }
    }

    public void remove(Teacher teacher) {
        teacherRepository.delete(teacher);
    }

    @Override
    public Teacher updateTeacherDetails(Teacher teacher) {
        Teacher existingTeacher = teacherRepository.findAllById(teacher.getId());
        if (existingTeacher != null) {
            log.info("********** updating existing teacher record ***********" + existingTeacher.getId());
            existingTeacher.setFullName(teacher.getFullName());
            existingTeacher.setCourse(teacher.getCourse());
            existingTeacher.setEmail(teacher.getEmail());
            existingTeacher.setPhoneNumber(teacher.getPhoneNumber());
            teacherRepository.save(existingTeacher);
            return existingTeacher;
        }
        log.info("********** Teacher record not found, Error occurred ***********");
        return null;
    }

    @Override
    public Teacher getTeacherById(String teacherId) {
        log.info("********** getting teacher from id ***********" + teacherId);
        Teacher teacher = teacherRepository.findAllById(teacherId);
        return teacher;
    }

    @Override
    public Boolean loginTeacher(TeacherLoginDto teacherLoginDto) {
        return null;
    }

    @Override
    public Teacher findTeacherByEmail(String email) {
        return teacherRepository.findTeacherByEmail(email);
    }

    @Override
    public boolean isTeacherExistByEmail(String email) {
        log.info("********* checking if teacher is exist by email or not from teacher service implementation **********");
        Teacher teacher = teacherRepository.findTeacherByEmail(email);
        if (teacher != null) {
            log.info(" ******* teacher with entered email already exist ******* ");
            return true;
        }
        return false;
    }
}
