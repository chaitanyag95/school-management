package com.chaitanya.schoolmanagement.service.exam;

import com.chaitanya.schoolmanagement.model.exam.ExamResult;
import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.repository.ExamResultRepository;
import com.chaitanya.schoolmanagement.service.student.StudentService;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ExamResultService {
    @Autowired
    private ExamResultRepository examResultRepository;
    @Autowired
    private QuestionPaperService questionPaperService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private QuestionService questionService;

    public boolean isExamResultExist(String examResultId) {
        Optional<ExamResult> examResultOptional = examResultRepository.findById(examResultId);
        ExamResult examResult = examResultOptional.get();
        if (examResult != null) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void save(ExamResult examResult) {
        examResultRepository.save(examResult);
    }


    public ExamResult getExamResultById(String id) {
        return examResultRepository.findById(id).get();
    }

    public boolean isExamResultExistByQuestionPaperAndStudentId(String questionPaperId, String studentId) {
        QuestionPaper questionPaper = questionPaperService.getQuestionPaperById(questionPaperId).get();
        Student student = studentService.getStudentById(studentId);
        ExamResult examResult = examResultRepository.findByStudentAndQuestionPaper(student, questionPaper);
        if (examResult != null) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public ExamResult getExamResultByQuestionPaperAndStudentId(String questionPaperId, String studentId) {
        QuestionPaper questionPaper = questionPaperService.getQuestionPaperById(questionPaperId).get();
        Student student = studentService.getStudentById(studentId);
        ExamResult examResult = examResultRepository.findByStudentAndQuestionPaper(student, questionPaper);
        return examResult;
    }

    public ExamResult getExamResultByIdAndStudentAndQuestionPaper(String examResultId, String studentId, String questionPaperId) {
        QuestionPaper questionPaper = questionPaperService.getQuestionPaperById(questionPaperId).get();
        Student student = studentService.getStudentById(studentId);
        return examResultRepository.findByIdAndStudentAndQuestionPaper(examResultId, student, questionPaper);
    }

    public void saveExamResult(String questionPaperId, String studentId) {
        if (!isExamResultExistByQuestionPaperAndStudentId(questionPaperId, studentId)) {
            ExamResult examResult = new ExamResult();
            Student student = studentService.getStudentById(studentId);
            QuestionPaper questionPaper = questionPaperService.getQuestionPaperById(questionPaperId).get();
            examResult.setStudent(student);
            examResult.setQuestionPaper(questionPaper);
            examResult.setTotalQuestion(questionService.findAllQuestionsByQuestionPaperId(questionPaperId).size());
            examResult.setRemainingQuestion(questionService.findAllQuestionsByQuestionPaperId(questionPaperId).size());
            examResultRepository.save(examResult);
            setQuestionPaperIdAndResultIdInStore(examResult.getId(), questionPaperId);
        } else {
            ExamResult examResult = getExamResultByQuestionPaperAndStudentId(questionPaperId, studentId);
            setQuestionPaperIdAndResultIdInStore(examResult.getId(), questionPaperId);
        }
    }

    public void setQuestionPaperIdAndResultIdInStore(String examResultId, String questionPaperId) {
        try {
            FileReader fileReader = new FileReader("/home/chaitannya/Persistence/src/main/resources/userDetails.csv");
            CSVReader csvReader = new CSVReaderBuilder(fileReader).build();
            List<String[]> allData = csvReader.readAll();
            ArrayList<String> headers = new ArrayList<String>(Arrays.asList(allData.get(0)));
            headers.add("examResultId");
            headers.add("questionPaperId");
            ArrayList<String> storeInfo = new ArrayList<String>(Arrays.asList(allData.get(1)));
            storeInfo.add(examResultId);
            storeInfo.add(questionPaperId);
            csvReader.close();
            FileWriter fileWriter = new FileWriter("/home/chaitannya/Persistence/src/main/resources/userDetails.csv");
            CSVWriter writer = new CSVWriter(fileWriter);
            writer.writeNext(headers.toArray(new String[headers.size()]));
            writer.writeNext(storeInfo.toArray(new String[headers.size()]));
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
