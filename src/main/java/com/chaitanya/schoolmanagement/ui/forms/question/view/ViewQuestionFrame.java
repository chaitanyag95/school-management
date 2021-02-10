package com.chaitanya.schoolmanagement.ui.forms.question.view;

import com.chaitanya.schoolmanagement.model.exam.ExamResult;
import com.chaitanya.schoolmanagement.model.exam.Question;
import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import com.chaitanya.schoolmanagement.payload.NextQuestionPayload;
import com.chaitanya.schoolmanagement.service.exam.ExamResultService;
import com.chaitanya.schoolmanagement.service.exam.QuestionPaperService;
import com.chaitanya.schoolmanagement.service.exam.QuestionService;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.concurrent.TimeUnit;


@Component
@Getter
@Slf4j
public class ViewQuestionFrame extends JFrame {


    // Variables declaration - do not modify
    private JLabel bgLbl;
    private ButtonGroup buttonGroup1;
    private JLabel courseLbl;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JButton nextBtn;
    private JRadioButton optionFourRB;
    private JRadioButton optionOneRB;
    private JRadioButton optionThreeRB;
    private JRadioButton optionTwoRB;
    private JLabel paperCodeAndTitleLbl;
    private JButton prevBtn;
    private JLabel quesNoLbl;
    private JTextField quesNoTF;
    private JTextArea quesTF;
    private JButton submitBtn;
    private JLabel quesLbl;
    private JLabel timerLbl;
    // End of variables declaration
    private static final int DEFAULT_WIDTH = 750;
    private static final int DEFAULT_HEIGHT = 340;
    private String questionPaperId;
    private String questionId;
    private int parsedSeconds;
    @Autowired
    private QuestionPaperService questionPaperService;
    @Autowired
    private ExamResultService examResultService;
    @Autowired
    private QuestionService questionService;


    @PostConstruct
    private void preparePanel() {
        setPanelUp();
        initComponents();
        pack();
    }

    private void setPanelUp() {
        setTitle(ConstMessagesEN.Labels.VIEW_QUESTION);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /*public ViewQuestionFrame(String cor, String uname) {
        initComponents();
        courseLbl.setText(cor);
        paperCodeAndTitleLbl.setText(uname);

        addData();
        count();
    }*/

    int total_q;
    int attempted_q = 0;
    int remain_q = total_q - attempted_q;
    int correct;
    int incorrect = -1;
    int notattempt = 0;


    /*public final void addData() {
        String course = courseLbl.getText();

        try {

            String databasename = "bug2db";
            String url = "jdbc:mysql://localhost:3306/";
            String user = "root";
            String pass = "root";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url + databasename, user, pass);

            String query = "select * from " + course + "";
            psmnt = con.prepareStatement(query);
            rs = psmnt.executeQuery();

            if (rs.next()) {
                quesTF.setText(rs.getString("questions"));
                quesNoTF.setText(rs.getString("ques_id"));

                optionOneRB.setText(rs.getString("answer_one"));
                optionTwoRB.setText(rs.getString("answer_two"));
                optionThreeRB.setText(rs.getString("answer_three"));
                optionFourRB.setText(rs.getString("answer_four"));

                String corre = rs.getString("correct_ans");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }*/

    /*public void count() {
        String course = courseLbl.getText().trim();
        String count = "select count(*) from " + course + "";
        try {
            psmnt = con.prepareStatement(count);
            rs = psmnt.executeQuery();
            while (rs.next()) {
                total_q = rs.getShort("count(*)");
                System.out.println("Total Questions -" + total_q);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttonGroup1 = new ButtonGroup();
        courseLbl = new JLabel();
        paperCodeAndTitleLbl = new JLabel();
        jScrollPane1 = new JScrollPane();
        quesTF = new JTextArea();
        quesNoLbl = new JLabel();
        quesNoTF = new JTextField();
        quesLbl = new JLabel();
        optionOneRB = new JRadioButton();
        optionTwoRB = new JRadioButton();
        optionThreeRB = new JRadioButton();
        optionFourRB = new JRadioButton();
        submitBtn = new JButton();
        prevBtn = new JButton();
        nextBtn = new JButton();
        timerLbl = new JLabel();

        quesNoTF.setEditable(false);

        courseLbl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        courseLbl.setForeground(new java.awt.Color(0, 0, 0));
        courseLbl.setHorizontalAlignment(SwingConstants.CENTER);
        courseLbl.setText("Get Course Name");

        submitBtn.setText("Submit");

        paperCodeAndTitleLbl.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        paperCodeAndTitleLbl.setForeground(new java.awt.Color(0, 0, 0));
        paperCodeAndTitleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        paperCodeAndTitleLbl.setText("MCA -201 Core Java");

        quesTF.setColumns(20);
        quesTF.setRows(5);
        quesTF.setEditable(false);
        jScrollPane1.setViewportView(quesTF);

        prevBtn.setText("Previous");


        nextBtn.setText("Next");


        quesNoLbl.setForeground(new Color(0, 0, 0));
        quesNoLbl.setFont(new Font("Ubuntu", 1, 18));
        quesNoLbl.setText("Ques_No -");

        buttonGroup1.add(optionOneRB);
        optionOneRB.setFont(new Font("Ubuntu", 1, 18)); // NOI18N
        optionOneRB.setForeground(new Color(0, 0, 0));
        optionOneRB.setText("Option One");


        buttonGroup1.add(optionTwoRB);
        optionTwoRB.setFont(new Font("Ubuntu", 1, 18)); // NOI18N
        optionTwoRB.setForeground(new Color(0, 0, 0));
        optionTwoRB.setText("Option Two");

        buttonGroup1.add(optionThreeRB);
        optionThreeRB.setFont(new Font("Ubuntu", 1, 18)); // NOI18N
        optionThreeRB.setForeground(new Color(0, 0, 0));
        optionThreeRB.setText("Option Three");

        buttonGroup1.add(optionFourRB);
        optionFourRB.setFont(new Font("Ubuntu", 1, 18)); // NOI18N
        optionFourRB.setForeground(new Color(0, 0, 0));
        optionFourRB.setText("Option Four");

        quesLbl.setText("Question");
        quesLbl.setFont(new Font("Ubuntu", 1, 18));


        timerLbl.setFont(new Font("Ubuntu", 1, 18)); // NOI18N
        timerLbl.setForeground(new Color(0, 0, 0));
        timerLbl.setText("HH:MM:SS");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(timerLbl)
                                .addGap(160, 160, 160)
                                .addComponent(courseLbl)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(quesLbl)
                                                        .addComponent(quesNoLbl))
                                                .addGap(67, 67, 67)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(optionTwoRB)
                                                        .addComponent(optionOneRB)
                                                        .addComponent(optionFourRB)
                                                        .addComponent(optionThreeRB)
                                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 492, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(quesNoTF, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(154, 154, 154)
                                                .addComponent(paperCodeAndTitleLbl, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(144, 144, 144)
                                                .addComponent(submitBtn)
                                                .addGap(58, 58, 58)
                                                .addComponent(prevBtn)
                                                .addGap(40, 40, 40)
                                                .addComponent(nextBtn, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(timerLbl)
                                        .addComponent(courseLbl))
                                .addGap(18, 18, 18)
                                .addComponent(paperCodeAndTitleLbl, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(quesNoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(quesNoLbl))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(quesLbl))
                                .addGap(18, 18, 18)
                                .addComponent(optionOneRB)
                                .addGap(18, 18, 18)
                                .addComponent(optionTwoRB)
                                .addGap(18, 18, 18)
                                .addComponent(optionThreeRB)
                                .addGap(18, 18, 18)
                                .addComponent(optionFourRB)
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(submitBtn)
                                        .addComponent(prevBtn)
                                        .addComponent(nextBtn))
                                .addGap(23, 23, 23))
        );
    }// </editor-fold>                        

    // ResultSet rs1;

    /*private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {
        String course = courseLbl.getText();
        String cor = null;
        buttonGroup2.clearSelection();

        try {
            if (rs1 == null) {
                String query = "select * from " + course + "";
                PreparedStatement ps = con.prepareStatement(query);
                rs1 = ps.executeQuery();
            }
            System.out.println(rs1);

            if (rs1.next()) {
                quesTF.setText(rs1.getString("questions"));
                quesNoTF.setText(rs1.getString("ques_id"));

                optionOneRB.setText(rs1.getString("answer_one"));
                optionTwoRB.setText(rs1.getString("answer_two"));
                optionThreeRB.setText(rs1.getString("answer_three"));
                optionFourRB.setText(rs1.getString("answer_four"));
                cor = rs1.getString("correct_ans");


            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }


    }*/

    /*private void prevBtnActionPerformed(java.awt.event.ActionEvent evt) {
        String cor = null;
        String course = courseLbl.getText();
        try {
            if (rs1 == null) {
                String query = "select * from " + course + "";
                psmnt = con.prepareStatement(query);
                rs1 = psmnt.executeQuery();
            }
            if (rs1.previous()) {
                quesTF.setText(rs1.getString("questions"));
                quesNoTF.setText(rs1.getString("ques_id"));
                optionOneRB.setText(rs1.getString("answer_one"));
                optionTwoRB.setText(rs1.getString("answer_two"));
                optionThreeRB.setText(rs1.getString("answer_three"));
                optionFourRB.setText(rs1.getString("answer_four"));

                cor = rs1.getString("correct_ans");
            } else {
                JOptionPane.showMessageDialog(this, "This is first record of student");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {
        String name = paperCodeAndTitleLbl.getText().trim();
        new Submit("" + total_q, "" + attempted_q, "" + correct, "" + incorrect, "" + remain_q, name).setVisible(true);
        dispose();
    }

    */

    /*
      public static void main(String args[]) {
          *//* Set the Nimbus look and feel *//*
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        *//* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     *//*
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        *//* Create and display the form *//*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quiz("", "").setVisible(true);
            }
        });
    }*/

    Timer timer = new Timer(500, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            parsedSeconds--;
            if (parsedSeconds == 0) {
                ((Timer) e.getSource()).stop();
                submitBtn.doClick();
            }
            long hours = TimeUnit.SECONDS.toHours(parsedSeconds);
            long minutes = TimeUnit.SECONDS.toMinutes(parsedSeconds) - (TimeUnit.SECONDS.toHours(parsedSeconds) * 60);
            long seconds = TimeUnit.SECONDS.toSeconds(parsedSeconds) - (TimeUnit.SECONDS.toMinutes(parsedSeconds) * 60);
            timerLbl.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
        }
    });

    public void startTimer() {
        Optional<QuestionPaper> questionPaper = questionPaperService.getQuestionPaperById(questionPaperId);
        int hours = Integer.parseInt(questionPaper.get().getDuration());
        parsedSeconds = hours * 3600;
        timer.start();
    }

    public void setViewQuestionForm(Question question) {
        log.info("******** setting view questionForm question  - > loadQuestion() **********");
        quesTF.setText(question.getQuestion());
        quesNoTF.setText(String.valueOf(question.getQuestionNo()));
        //questionNoSpinner.setValue(question.getQuestionNo());
        optionFourRB.setText(question.getAnswerFour());
        optionThreeRB.setText(question.getAnswerThree());
        optionTwoRB.setText(question.getAnswerTwo());
        optionOneRB.setText(question.getAnswerOne());
        // correctAnsCB.getModel().setSelectedItem(question.getCorrectAnswer());
        questionPaperId = question.getQuestionPaper().getId();
        questionId = question.getId();
        Optional<QuestionPaper> questionPaper = questionPaperService.getQuestionPaperById(questionPaperId);
        courseLbl.setText(questionPaper.get().getCourse().getName());
        paperCodeAndTitleLbl.setText(questionPaper.get().getPaperCode() + " " + questionPaper.get().getPaperTitle());
    }

    public ExamResult getExamResultFromForm() {
        String examResultId = questionPaperService.getExamResultIdFromStore();
        String studentId = questionPaperService.getUserIDRecordFromStore();
        String questionPaperId = questionPaperService.getQuestionPaperIdFromStore();
        Question question = questionService.getQuestionById(questionId);
        ExamResult examResult = examResultService.getExamResultByIdAndStudentAndQuestionPaper(examResultId, studentId, questionPaperId);
        Map<Question, String> questionAnswerMap = new HashMap<>();
        String getAnswerSelected = getAnswerSelected();
        questionAnswerMap.put(question, getAnswerSelected);
        examResult.setQuestionAnswerMap(questionAnswerMap);
        examResult.setAttemptedQuestion(examResult.getAttemptedQuestion() + 1);
        examResult.setRemainingQuestion(examResult.getRemainingQuestion() - 1);
        if (checkQuestionResult(question, getAnswerSelected)) {
            examResult.setCorrectQuestion(examResult.getCorrectQuestion() + 1);
        } else {
            examResult.setCorrectQuestion(examResult.getInCorrectQuestion() + 1);
        }
        return examResult;
    }

    public String getAnswerSelected() {
        String getAnswerSelected = "";
        for (Enumeration<AbstractButton> allOptions = buttonGroup1.getElements(); allOptions.hasMoreElements(); ) {
            AbstractButton button = allOptions.nextElement();
            if (button.isSelected()) {
                getAnswerSelected = button.getText();
            }
        }
        return getAnswerSelected;
    }

    public Boolean checkQuestionResult(Question question, String getAnswerSelected) {
        if (question.getCorrectAnswer().equals(getAnswerSelected)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public NextQuestionPayload getQuestionNumberFromForm() {
        String userId = questionPaperService.getUserIDRecordFromStore();
        int questionNo = 1;
        try {
            questionNo = Integer.parseInt(quesNoTF.getText());
        } catch (Exception e) {
            log.info(" ********** exception *******  " + e.getMessage());
        }
        NextQuestionPayload nextQuestionPayload = new NextQuestionPayload(questionNo, questionPaperId, userId, questionId);
        return nextQuestionPayload;
    }

    public void clearSelection() {
        buttonGroup1.clearSelection();
    }

}


