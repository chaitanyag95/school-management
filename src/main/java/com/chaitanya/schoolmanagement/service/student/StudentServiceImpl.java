package com.chaitanya.schoolmanagement.service.student;


import com.chaitanya.schoolmanagement.model.course.Course;
import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.payload.EmailDto;
import com.chaitanya.schoolmanagement.repository.StudentRepository;
import com.chaitanya.schoolmanagement.service.course.CourseService;
import com.chaitanya.schoolmanagement.service.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Autowired
    private CourseService courseService;

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
            if (!isStudentExistByEmail(student.getEmail())) {
                existingStudent.setEmail(student.getEmail());
            }
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
                Course course = student.getCourse();
                student.setCourse(courseService.getCourseByName(course.getName()));
                save(student);
            }
        }
    }

    @Override
    public void downloadCsvFile() throws IOException {
        log.info(" *********** download csv file ***********");
        List<Student> students = studentRepository.findAll();
        FileWriter fileWriter = new FileWriter("studentList.csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".csv";

        ICsvBeanWriter csvWriter = new CsvBeanWriter(fileWriter, CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Id", "Full Name", "E-mail", "Phone Number", "Password", "Course"};
        String[] nameMapping = {"id", "email", "fullName", "phoneNumber", "password", "course"};

        csvWriter.writeHeader(csvHeader);

        for (Student student : students) {
            csvWriter.write(student, nameMapping);
        }
        csvWriter.close();
    }

    @Override
    public void saveAsExcelFile() throws IOException {
        log.info(" *********** writing into excel file ***********");
        String[] columns = {"id", "Full Name", "E-mail", "Phone Number", "Password", "Course"};
        List<Student> students = studentRepository.findAll();
        // Create a Workbook
        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        /* CreationHelper helps us create instances of various things like DataFormat,
           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
        CreationHelper createHelper = workbook.getCreationHelper();

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Student Record");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Create Cell Style for formatting Date
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

        // Create Other rows and cells with employees data
        int rowNum = 1;
        for (Student student : students) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(student.getId());

            row.createCell(1)
                    .setCellValue(student.getFullName());


            row.createCell(3)
                    .setCellValue(student.getEmail());

            row.createCell(4)
                    .setCellValue(student.getPhoneNumber());

            row.createCell(5)
                    .setCellValue(student.getPassword());

            row.createCell(6)
                    .setCellValue(student.getCourse().getName());
        }

        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("student-record.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();


    }
}
