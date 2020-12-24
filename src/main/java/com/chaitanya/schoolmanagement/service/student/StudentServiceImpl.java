package com.chaitanya.schoolmanagement.service.student;


import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.payload.EmailDto;
import com.chaitanya.schoolmanagement.repository.StudentRepository;
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
class StudentServiceImpl implements StudentService {

    public static final int NAME_INDEX = 0;
    public static final int EMAIL_INDEX = 1;
    public static final int COUNT_INDEX = 2;

    private final StudentRepository studentRepository;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void save(Student student) {
        log.info("********** Saving student record ***********");
        String password = student.getPassword();
        student.setPassword(bCryptPasswordEncoder.encode(password));
        studentRepository.save(student);
        String content = "Welcome " + student.getFullName() + " to our school management application. Your Credentials are Username : " + student.getEmail() + " and  Password : " + password;
        EmailDto emailDto = new EmailDto(student.getEmail(), "Student Account Creation", content, student.getFullName());
        try {
            log.info("****** notifying student for account creation ********");
            notificationService.sendEmail(emailDto);
        } catch (Exception e) {
            log.info("****** exception occurred in notifying student for account creation ********");
        }
    }

    public void remove(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public Student updateStudentDetails(Student student) {
        Student existingStudent = studentRepository.findAllById(student.getId());
        if (existingStudent != null) {
            log.info("********** updating existing student record ***********" + existingStudent.getId());
            existingStudent.setFullName(student.getFullName());
            existingStudent.setCourse(student.getCourse());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setPhoneNumber(student.getPhoneNumber());
            studentRepository.save(existingStudent);
            return existingStudent;
        }
        log.info("********** Student record not found, Error occurred ***********");
        return null;
    }

    @Override
    public Student getStudentById(String studentId) {
        log.info("********** getting student from id ***********" + studentId);
        Student student = studentRepository.findAllById(studentId);
        return student;
    }

    @Override
    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public Boolean isStudentExistByEmail(String email) {
        log.info("********* checking if student is exist by email or not from student service implementation **********");
        Student student = studentRepository.findByEmail(email);
        if (student != null) {
            log.info(" ******* student with entered email already exist ******* ");
            return true;
        }
        return false;
    }

    @Override
    public void saveStudentsByBatch(List<Student> students) {
        log.info("*********** saving students list through batch job ************");
        for (Student student : students) {
            if (!isStudentExistByEmail(student.getEmail())) {
                save(student);
            }
        }
    }
}
