package com.chaitanya.schoolmanagement.ui.forms.student.exam.view;

import com.chaitanya.schoolmanagement.model.exam.ExamResult;
import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.service.student.StudentService;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
@Getter
@Slf4j
public class StudentResultWindow extends JFrame {

    // Variables declaration - do not modify                     
    private JLabel attemptedQuesLbl;
    private JTextField attemptedQuestTF;
    private JLabel correctQuesLbl;
    private JTextField correctQuestTF;
    private JLabel incorrectQuesLbl;
    private JTextField incorrectQuestTF;
    private JLabel jLabel11;
    private JLabel jLabel7;
    private JLabel paperCodeLbl;
    private JLabel percentageLbl;
    private JTextField percentageTF;
    private JTextField remainQuestTF;
    private JLabel remainingQuesLbl;
    private JLabel resultLbl;
    private JLabel totalQuesLbl;
    private JTextField totalQuestTF;
    // End of variables declaration
    @Autowired
    private StudentService studentService;

   
    /*public Result(String total, String attempt, String correct, String incorrect, String remain, String name) {
        initComponents();
        jLabel7.setText(name);
        totalQuestTF.setText(total);
        attemptedQuestTF.setText(attempt);
        remainQuestTF.setText(remain);
        correctQuestTF.setText(correct);
        incorrectQuestTF.setText(incorrect);
        try {
            int a = Integer.parseInt(correctQuestTF.getText().trim());
            int b = Integer.parseInt(totalQuestTF.getText().trim());
            int r = (a * 100) / b;
            percentageTF.setText("" + r);
        } catch (ArithmeticException ex) {
            ex.printStackTrace();
        }
    }*/

    @PostConstruct
    private void preparePanel() {
        setPanelUp();
        initComponents();
        pack();
    }

    private void setPanelUp() {
        setTitle("Result");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //  setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        totalQuestTF = new JTextField();
        attemptedQuestTF = new JTextField();
        remainQuestTF = new JTextField();
        correctQuestTF = new JTextField();
        incorrectQuestTF = new JTextField();
        totalQuesLbl = new JLabel();
        attemptedQuesLbl = new JLabel();
        remainingQuesLbl = new JLabel();
        correctQuesLbl = new JLabel();
        incorrectQuesLbl = new JLabel();
        resultLbl = new JLabel();
        jLabel7 = new JLabel();
        percentageLbl = new JLabel();
        percentageTF = new JTextField();
        jLabel11 = new JLabel();
        paperCodeLbl = new JLabel();


        totalQuestTF.setEditable(false);
        totalQuestTF.setForeground(new java.awt.Color(0, 0, 0));

        attemptedQuestTF.setEditable(false);
        attemptedQuestTF.setText("                    ");

        remainQuestTF.setEditable(false);
        remainQuestTF.setText("                   ");


        correctQuestTF.setEditable(false);
        correctQuestTF.setText("                     ");

        incorrectQuestTF.setEditable(false);
        incorrectQuestTF.setText("                  ");

        totalQuesLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        totalQuesLbl.setForeground(new java.awt.Color(0, 0, 0));
        totalQuesLbl.setText("Total Questions -");

        attemptedQuesLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        attemptedQuesLbl.setForeground(new java.awt.Color(0, 0, 0));
        attemptedQuesLbl.setText("Attempted Questions -");

        remainingQuesLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        remainingQuesLbl.setForeground(new java.awt.Color(0, 0, 0));
        remainingQuesLbl.setText("Remaining Questions -");

        correctQuesLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        correctQuesLbl.setForeground(new java.awt.Color(0, 0, 0));
        correctQuesLbl.setText("Correct Questions -");

        incorrectQuesLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        incorrectQuesLbl.setForeground(new java.awt.Color(0, 0, 0));
        incorrectQuesLbl.setText("Incorrect Questions -");

        resultLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        resultLbl.setForeground(new java.awt.Color(0, 0, 0));
        resultLbl.setText("Result of -");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Pass/Failed");

        percentageLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        percentageLbl.setForeground(new java.awt.Color(0, 0, 0));
        percentageLbl.setText("Percentage -");

        percentageTF.setEditable(false);
        percentageTF.setText(" ");


        jLabel11.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("%");

        paperCodeLbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        paperCodeLbl.setForeground(new java.awt.Color(255, 255, 255));
        paperCodeLbl.setText("Get Course Name");


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(remainingQuesLbl)
                                                                        .addComponent(correctQuesLbl)
                                                                        .addComponent(attemptedQuesLbl)
                                                                        .addComponent(incorrectQuesLbl)
                                                                        .addComponent(percentageLbl))
                                                                .addGap(91, 91, 91)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(correctQuestTF, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(incorrectQuestTF, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(remainQuestTF, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(attemptedQuestTF, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(totalQuestTF, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(totalQuesLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(resultLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(paperCodeLbl)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(percentageTF, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel11)))
                                .addGap(216, 216, 216))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(resultLbl)
                                        .addComponent(jLabel7)
                                        .addComponent(paperCodeLbl))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(totalQuestTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(totalQuesLbl))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(attemptedQuestTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(attemptedQuesLbl))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(remainQuestTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(remainingQuesLbl))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(correctQuestTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(correctQuesLbl))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(incorrectQuesLbl)
                                        .addComponent(incorrectQuestTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(percentageTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(percentageLbl)))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    public void setExamResult(ExamResult examResult, QuestionPaper questionPaper, String studentId) {
        Student student = studentService.getStudentById(studentId);
        attemptedQuestTF.setText(String.valueOf(examResult.getAttemptedQuestion()));
        totalQuestTF.setText(String.valueOf(examResult.getTotalQuestion()));
        correctQuestTF.setText(String.valueOf(examResult.getCorrectQuestion()));
        incorrectQuestTF.setText(String.valueOf(examResult.getInCorrectQuestion()));
        percentageTF.setText(String.valueOf(examResult.getPercentage()));
        remainQuestTF.setText(String.valueOf(examResult.getRemainingQuestion()));
        jLabel7.setText(student.getFullName() + " " + questionPaper.getPaperCode() + " " + examResult.getResult().toString());
    }
}
