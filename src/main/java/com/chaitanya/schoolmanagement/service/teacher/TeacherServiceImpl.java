package com.chaitanya.schoolmanagement.service.teacher;


import com.chaitanya.schoolmanagement.model.teacher.Teacher;
import com.chaitanya.schoolmanagement.payload.EmailDto;
import com.chaitanya.schoolmanagement.payload.TeacherLoginDto;
import com.chaitanya.schoolmanagement.repository.TeacherRepository;
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
            if (isTeacherExistByEmail(teacher.getEmail())) {
                existingTeacher.setEmail(teacher.getEmail());
            }
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

    @Override
    public void downloadCsvFile() throws IOException {
        log.info(" *********** download csv file ***********");
        List<Teacher> teachers = teacherRepository.findAll();
        FileWriter fileWriter = new FileWriter("teacherList.csv");
        ICsvBeanWriter csvWriter = new CsvBeanWriter(fileWriter, CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Id", "Full Name", "E-mail", "Phone Number", "Password", "Course"};
        String[] nameMapping = {"id", "email", "fullName", "phoneNumber", "password", "course"};
        csvWriter.writeHeader(csvHeader);
        for (Teacher teacher : teachers) {
            csvWriter.write(teacher, nameMapping);
        }
        csvWriter.close();
    }

    @Override
    public void saveAsExcelFile() throws IOException {
        log.info(" *********** writing into excel file ***********");
        String[] columns = {"id", "Full Name", "E-mail", "Phone Number", "Password", "Course"};
        List<Teacher> teachers = teacherRepository.findAll();
        // Create a Workbook
        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        /* CreationHelper helps us create instances of various things like DataFormat,
           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
        CreationHelper createHelper = workbook.getCreationHelper();

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Teacher Record");

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
        for (Teacher teacher : teachers) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(teacher.getId());

            row.createCell(1)
                    .setCellValue(teacher.getFullName());


            row.createCell(3)
                    .setCellValue(teacher.getEmail());

            row.createCell(4)
                    .setCellValue(teacher.getPhoneNumber());

            row.createCell(5)
                    .setCellValue(teacher.getPassword());

            row.createCell(6)
                    .setCellValue(teacher.getCourse().getName());
        }

        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("teacher-record.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();


    }
}
