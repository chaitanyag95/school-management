package com.chaitanya.schoolmanagement.ui.forms.exam.view;

import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

@Component
@Getter
@Slf4j
public class QuestionDashboardFrame extends JFrame {
    // Variables declaration - do not modify
    private JButton addQuestionBtn;
    private JButton viewQuestionBtn;
    private JButton backBtn;
    private JLabel examsTitleLbl;
    private JLabel jLabel2;
    private JColorChooser jColorChooser1;

    // End of variables declaration
    private QuestionPaper questionPaper;
    private String questionPaperId;

    @PostConstruct
    private void preparePanel() {
        setPanelUp();
        initComponents();
        pack();
    }

    private void setPanelUp() {
        setTitle(ConstMessagesEN.Labels.QUESTION_DASHBOARD);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {


        examsTitleLbl = new JLabel();
        addQuestionBtn = new JButton();
        viewQuestionBtn = new JButton();
        backBtn = new JButton();
        jLabel2 = new JLabel();
        jColorChooser1 = new JColorChooser();


        examsTitleLbl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        examsTitleLbl.setForeground(new java.awt.Color(255, 255, 255));
        examsTitleLbl.setText("QUESTION PAPER DASHBOARD");

        addQuestionBtn.setIcon(new ImageIcon("/home/chaitannya/Persistence/src/main/resources/Webp.net-resizeimage (1).png")); // NOI18N
        addQuestionBtn.setText("Add Question");


        viewQuestionBtn.setIcon(new ImageIcon("/home/chaitannya/Persistence/src/main/resources/sear.jpg")); // NOI18N
        viewQuestionBtn.setText("View All Questions");


        backBtn.setText("Back");


        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setIcon(new ImageIcon("/home/chaitannya/Persistence/src/main/resources/1.jpg")); // NOI18N
        jLabel2.setText("jLabel2");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(175, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(examsTitleLbl)
                                                .addGap(94, 94, 94)
                                                .addComponent(backBtn)
                                                .addGap(17, 17, 17))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(viewQuestionBtn, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(addQuestionBtn, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
                                                .addGap(172, 172, 172))))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 567, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(backBtn)
                                        .addComponent(examsTitleLbl, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                                .addGap(92, 92, 92)
                                .addComponent(addQuestionBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(viewQuestionBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(132, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 426, Short.MAX_VALUE))
        );


    }

    public void setQuestionPaper(QuestionPaper questionPaper) {
        questionPaperId = questionPaper.getId();
        questionPaper = questionPaper;
        log.info(" ******** question paper ->   " + questionPaper.getPaperCode() + " ->  " + questionPaper.getPaperTitle());
    }
}
