package com.chaitanya.schoolmanagement.ui.forms.question.view;

import com.chaitanya.schoolmanagement.model.exam.Question;
import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import com.chaitanya.schoolmanagement.payload.NextQuestionPayload;
import com.chaitanya.schoolmanagement.service.exam.QuestionPaperService;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.Optional;


@Component
@Getter
@Slf4j
public class ViewQuestionFrame extends JFrame {


    // Variables declaration - do not modify
    private JLabel bgLbl;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
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
    // End of variables declaration
    private static final int DEFAULT_WIDTH = 750;
    private static final int DEFAULT_HEIGHT = 340;
    private String questionPaperId;
    private String questionId;
    @Autowired
    private QuestionPaperService questionPaperService;


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
        buttonGroup2 = new ButtonGroup();
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

        quesNoTF.setEditable(false);

        courseLbl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        courseLbl.setForeground(new java.awt.Color(0, 0, 0));
        courseLbl.setHorizontalAlignment(SwingConstants.CENTER);
        courseLbl.setText("Get Course Name");

        paperCodeAndTitleLbl.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        paperCodeAndTitleLbl.setForeground(new java.awt.Color(0, 0, 0));
        paperCodeAndTitleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        paperCodeAndTitleLbl.setText("MCA -201 Core Java");

        quesTF.setColumns(20);
        quesTF.setRows(5);
        quesTF.setEditable(false);
        jScrollPane1.setViewportView(quesTF);

        quesNoLbl.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        quesNoLbl.setForeground(new java.awt.Color(0, 0, 0));
        quesNoLbl.setText("Ques_No -");

        /*quesNoTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quesNoTFActionPerformed(evt);
            }
        });*/

        quesLbl.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        quesLbl.setForeground(new java.awt.Color(0, 0, 0));
        quesLbl.setText("Question");

        optionOneRB.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        optionOneRB.setText("Option 1");

        optionTwoRB.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        optionTwoRB.setText("Option 2");

        optionThreeRB.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        optionThreeRB.setText("Option 3");
        /*optionThreeRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionThreeRBActionPerformed(evt);
            }
        });*/

        optionFourRB.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        optionFourRB.setText("Option 4");

        submitBtn.setText("Submit");
        /*submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
*/
        prevBtn.setText("Previous");
        /*prevBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevBtnActionPerformed(evt);
            }
        });
*/
        nextBtn.setText("Next");
        /*nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });*/

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(courseLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(268, 268, 268))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(quesNoLbl)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(quesLbl)
                                                                .addGap(76, 76, 76)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(quesNoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(optionOneRB)
                                                                        .addComponent(optionTwoRB)
                                                                        .addComponent(optionThreeRB)
                                                                        .addComponent(optionFourRB)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(213, 213, 213)
                                                .addComponent(submitBtn)
                                                .addGap(47, 47, 47)
                                                .addComponent(prevBtn)
                                                .addGap(49, 49, 49)
                                                .addComponent(nextBtn))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(142, 142, 142)
                                                .addComponent(paperCodeAndTitleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(courseLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(paperCodeAndTitleLbl)
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(quesNoLbl)
                                        .addComponent(quesNoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(quesLbl))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27)
                                .addComponent(optionOneRB)
                                .addGap(18, 18, 18)
                                .addComponent(optionTwoRB)
                                .addGap(18, 18, 18)
                                .addComponent(optionThreeRB)
                                .addGap(18, 18, 18)
                                .addComponent(optionFourRB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(submitBtn)
                                        .addComponent(prevBtn)
                                        .addComponent(nextBtn))
                                .addGap(19, 19, 19))
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
    public void setViewQuestionForm(Question question) {
        log.info("******** setting view questionForm question  ->  method called from question controller - > loadQuestion() **********");
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

    public NextQuestionPayload getQuestionNumberFromForm() {
        int questionNo = 1;
        try {
            questionNo = Integer.parseInt(quesNoTF.getText());
        } catch (Exception e) {
            log.info(" ********** exception *******  " + e.getMessage());
        }
        NextQuestionPayload nextQuestionPayload = new NextQuestionPayload(questionNo, questionPaperId);
        return nextQuestionPayload;
    }

}


