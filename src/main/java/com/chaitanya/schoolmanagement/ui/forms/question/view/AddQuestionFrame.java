package com.chaitanya.schoolmanagement.ui.forms.question.view;

import com.chaitanya.schoolmanagement.model.exam.Question;
import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import com.chaitanya.schoolmanagement.service.exam.QuestionPaperService;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

@Component
@Getter
@Slf4j
public class AddQuestionFrame extends JFrame {

    private JTextField answer_four;
    private JTextField answer_one;
    private JTextField answer_three;
    private JTextField answer_two;
    private JTextField correctAnswerTF;
    private JButton saveBtn;
    private JButton backBtn;
    private JComboBox<String> correctAnsCB;
    private JLabel addQuestionTitle;
    private JLabel questionIdLbl;
    private JLabel ansOneLbl;
    private JLabel ansTwoLbl;
    private JLabel ansThreeLbl;
    private JLabel ansFourLbl;
    private JLabel correctAnsLbl;
    private JScrollPane jScrollPane1;
    private JTextArea ques;
    private JSpinner questionNoSpinner;
    private JTextField ques_id;
    private QuestionPaper questionPaper;
    private String questionPaperId;
    @Autowired
    private QuestionPaperService questionPaperService;

    private static final int DEFAULT_WIDTH = 750;
    private static final int DEFAULT_HEIGHT = 340;


    @PostConstruct
    private void preparePanel() {
        setPanelUp();
        initComponents();
        pack();
    }

    private void setPanelUp() {
        setTitle(ConstMessagesEN.Labels.ADD_QUESTION);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setBackground(new java.awt.Color(51, 51, 51));
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {

        addQuestionTitle = new JLabel();
        questionIdLbl = new JLabel();
        ques_id = new JTextField();
        jScrollPane1 = new JScrollPane();
        ques = new JTextArea();
        ansOneLbl = new JLabel();
        ansTwoLbl = new JLabel();
        ansThreeLbl = new JLabel();
        ansFourLbl = new JLabel();
        answer_one = new JTextField();
        answer_two = new JTextField();
        answer_three = new JTextField();
        answer_four = new JTextField();
        correctAnsLbl = new JLabel();
        correctAnsCB = new JComboBox<String>();
        saveBtn = new JButton();
        backBtn = new JButton();
        questionNoSpinner = new JSpinner();


        addQuestionTitle.setText("ADD QUESTIONS");

        questionIdLbl.setText("Question_ID -");

        ques_id.setText(" ");

        ques.setColumns(20);
        ques.setRows(5);
        jScrollPane1.setViewportView(ques);

        ansOneLbl.setText("Answer One ");

        ansTwoLbl.setText("Answer Two ");

        ansThreeLbl.setText("Answer Three ");

        ansFourLbl.setText("Answer Four ");

        answer_one.setText(" ");

        answer_one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!answer_one.getText().trim().isEmpty())
                    correctAnsCB.addItem(answer_one.getText());
            }
        });

        answer_two.setText(" ");

        answer_three.setText(" ");


        answer_four.setText(" ");


        correctAnsLbl.setText("Correct Answer -");

        correctAnsCB.setModel(new DefaultComboBoxModel<>(new String[]{}));


        saveBtn.setText("Save");


        backBtn.setText("Back");

        answer_two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!answer_two.getText().trim().isEmpty())
                    correctAnsCB.addItem(answer_two.getText());
            }
        });


        answer_three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!answer_three.getText().trim().isEmpty())
                    correctAnsCB.addItem(answer_three.getText());
            }
        });


        answer_four.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!answer_four.getText().trim().isEmpty())
                    correctAnsCB.addItem(answer_four.getText());
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(252, 252, 252)
                                                .addComponent(addQuestionTitle)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(backBtn))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(correctAnsLbl)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(correctAnsCB, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(197, 197, 197)
                                                                .addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(ansFourLbl)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(answer_four, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(ansThreeLbl)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                                                        .addComponent(answer_three, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(ansTwoLbl)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(answer_two, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(ansOneLbl)
                                                                        .addGap(35, 35, 35)
                                                                        .addComponent(answer_one)))
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(questionIdLbl)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(questionNoSpinner, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))))
                                                .addGap(0, 8, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(addQuestionTitle)
                                        .addComponent(backBtn))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(questionIdLbl)
                                        .addComponent(questionNoSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(ansOneLbl)
                                        .addComponent(answer_one, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(ansTwoLbl)
                                        .addComponent(answer_two, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(ansThreeLbl)
                                        .addComponent(answer_three, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(ansFourLbl)
                                        .addComponent(answer_four, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(correctAnsLbl)
                                        .addComponent(correctAnsCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(saveBtn))
                                .addGap(24, 24, 24))
        );
    }


    private void addAnswersInCorrectAnsCB(java.awt.event.ActionEvent evt) {
        if ((correctAnsCB.getSelectedItem()) == null) {
            String ans_one = answer_one.getText().trim();
            String ans_two = answer_two.getText().trim();
            String ans_three = answer_three.getText().trim();
            String ans_four = answer_four.getText().trim();
            correctAnsCB.addItem(ans_one);
            correctAnsCB.addItem(ans_two);
            correctAnsCB.addItem(ans_three);
            correctAnsCB.addItem(ans_four);
        }                      // TODO add your handling code here:
    }


    public Question getQuestionFromForm() {
        Question question = new Question();
        question.setQuestion(ques.getText());
        question.setQuestionNo((Integer) questionNoSpinner.getValue());
        question.setAnswerOne(answer_one.getText());
        question.setAnswerTwo(answer_two.getText());
        question.setAnswerThree(answer_three.getText());
        question.setAnswerFour(answer_four.getText());
        question.setCorrectAnswer((String) correctAnsCB.getSelectedItem());
        Optional<QuestionPaper> questionPaper = questionPaperService.getQuestionPaperById(questionPaperId);
        question.setQuestionPaper(questionPaper.get());
        return question;

    }

    public void setQuestionPaperInAddQuestionFrame(QuestionPaper questionPaper) {
        questionPaperId = questionPaper.getId();
        questionPaper = questionPaper;
        log.info(" ******** question paper ->   " + questionPaper.getPaperCode() + " ->  " + questionPaper.getPaperTitle() + " ******** in AddQuestionFrame Form *********  -> " + questionPaperId);
    }

    public void clearForm() {
        ques.setText(Strings.EMPTY);
        answer_four.setText(Strings.EMPTY);
        answer_three.setText(Strings.EMPTY);
        answer_two.setText(Strings.EMPTY);
        answer_one.setText(Strings.EMPTY);
        questionNoSpinner.setValue(0);
        correctAnsCB.setModel(new DefaultComboBoxModel<>(new String[]{}));
    }

}
