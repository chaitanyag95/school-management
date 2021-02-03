package com.chaitanya.schoolmanagement.ui.forms.exam.view;

import com.chaitanya.schoolmanagement.model.course.Course;
import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import com.chaitanya.schoolmanagement.payload.AddQuestionPaperDto;
import com.chaitanya.schoolmanagement.ui.forms.student.model.CourseComboBoxModel;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;


@Component
@Getter
@Slf4j
public class EditExamFrame extends JFrame {


    // Variables declaration - do not modify
    private JButton backBtn;
    private JLabel bgLbl;
    private JComboBox<Course> courseCB;
    private JButton deleteBtn;
    private JComboBox<String> durationCB;
    private JLabel editQuestionPaperLbl;
    private JScrollPane jScrollPane2;
    private JLabel paperCodeLbl;
    private JTextField paperCodeTF;
    private JLabel paperCourseLbl;
    private JLabel paperDscLbl;
    private JTextArea paperDscTF;
    private JLabel paperDurationLbl;
    private JLabel paperTitleLbl;
    private JTextField paperTitleTF;
    private JButton updateBtn;
    private JLabel hrLbl;
    private final CourseComboBoxModel courseComboBoxModel;
    // End of variables declaration
    private String questionPaperId;

    public EditExamFrame(CourseComboBoxModel courseComboBoxModel) {
        this.courseComboBoxModel = courseComboBoxModel;
    }

    /**
     * Creates new form EditQuestionPaperSchool
     */

    @PostConstruct
    private void preparePanel() {
        setPanelUp();
        initComponents();
        pack();
    }

    private void setPanelUp() {
        setTitle(ConstMessagesEN.Labels.EDIT_QUESTION_PAPER);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        editQuestionPaperLbl = new javax.swing.JLabel();
        paperCodeLbl = new javax.swing.JLabel();
        paperCodeTF = new javax.swing.JTextField();
        paperTitleLbl = new javax.swing.JLabel();
        paperTitleTF = new javax.swing.JTextField();
        paperDscLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        paperDscTF = new javax.swing.JTextArea();
        paperCourseLbl = new javax.swing.JLabel();
        courseCB = new JComboBox<>(courseComboBoxModel);
        paperDurationLbl = new javax.swing.JLabel();
        durationCB = new javax.swing.JComboBox<>();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        hrLbl = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        editQuestionPaperLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        editQuestionPaperLbl.setText("Edit Question Paper");

        paperCodeLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        paperCodeLbl.setText("Paper Code");


        paperTitleLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        paperTitleLbl.setText("Title");

        paperCodeTF.setEditable(false);


        paperDscLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        paperDscLbl.setText("Description");

        paperDscTF.setColumns(20);
        paperDscTF.setRows(5);
        jScrollPane2.setViewportView(paperDscTF);

        paperCourseLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        paperCourseLbl.setText("Course");




        paperDurationLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        paperDurationLbl.setText("Duration");

        durationCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1", "2", "3"}));
        durationCB.setSelectedItem(1);


        updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Webp.net-resizeimage (4).png"))); // NOI18N
        updateBtn.setText("Update");

        hrLbl.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        hrLbl.setText("Hr");


        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Webp.net-resizeimage (2).png"))); // NOI18N
        deleteBtn.setText("Delete");


        backBtn.setText("Back");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(paperDurationLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(durationCB, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(hrLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(paperCourseLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(courseCB, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(paperDscLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(paperTitleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(paperTitleTF))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(paperCodeLbl)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(74, 74, 74)
                                                                                .addComponent(editQuestionPaperLbl))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(67, 67, 67)
                                                                                .addComponent(paperCodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGap(31, 31, 31))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(updateBtn)
                                .addGap(33, 33, 33)
                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(editQuestionPaperLbl)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(paperCodeLbl)
                                        .addComponent(paperCodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(paperTitleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(paperTitleTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(paperDscLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(paperCourseLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(courseCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(paperDurationLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(durationCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(hrLbl)).addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(updateBtn)
                                        .addComponent(deleteBtn)
                                        .addComponent(backBtn))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

    }// </editor-fold>


    public void setQuestionPaperForm(QuestionPaper questionPaper) {
        log.info("******** setting update question paper ->  method called from exam controller - > loadQuestionPaper() **********");
        paperCodeTF.setText(questionPaper.getPaperCode());
        paperDscTF.setText(questionPaper.getPaperDsc());
        paperTitleTF.setText(questionPaper.getPaperTitle());
        courseCB.getModel().setSelectedItem(questionPaper.getCourse());
        durationCB.getModel().setSelectedItem(questionPaper.getDuration());
        questionPaperId = questionPaper.getId();
    }

    public AddQuestionPaperDto getQuestionPaperFromEditForm() {
        log.info(" ****** getting add question paper fields from from (EditExamFrame) ******");
        AddQuestionPaperDto addQuestionPaperDto = new AddQuestionPaperDto();
        addQuestionPaperDto.setPaperTitle(paperTitleTF.getText());
        addQuestionPaperDto.setPaperDsc(paperDscTF.getText());
        addQuestionPaperDto.setCourse((Course) courseCB.getSelectedItem());
        addQuestionPaperDto.setDuration((String) durationCB.getSelectedItem());
        addQuestionPaperDto.setPaperCode(paperCodeTF.getText());
        addQuestionPaperDto.setQuestionPaperId(questionPaperId);
        return addQuestionPaperDto;

    }
}
