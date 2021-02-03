package com.chaitanya.schoolmanagement.ui.forms.exam.view;

import com.chaitanya.schoolmanagement.model.course.Course;
import com.chaitanya.schoolmanagement.payload.AddQuestionPaperDto;
import com.chaitanya.schoolmanagement.ui.forms.student.model.CourseComboBoxModel;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
@Getter
@Slf4j
public class AddExamFrame extends JFrame {
    // Variables declaration - do not modify
    private JButton backBtn;
    private JComboBox<Course> courseCB;
    private JLabel createQuestionPaperLbl;
    private JComboBox<String> durationCB;
    private JLabel jLabel1;
    private JScrollPane jScrollPane2;
    private JLabel paperCodeLbl;
    private JTextField paperCodeTF;
    private JLabel paperCourseLbl;
    private JLabel paperDscLbl;
    private JLabel paperDscLbl1;
    private JTextArea paperDscTF;
    private JLabel paperDurationLbl;
    private JLabel paperTitleLbl;
    private JTextField paperTitleTF;
    private JButton saveBtn;
    // End of variables declaration
    private final CourseComboBoxModel courseComboBoxModel;
    private static final int DEFAULT_WIDTH = 750;
    private static final int DEFAULT_HEIGHT = 340;


    public AddExamFrame(CourseComboBoxModel courseComboBoxModel) {
        this.courseComboBoxModel = courseComboBoxModel;
    }

    @PostConstruct
    private void preparePanel() {
        setPanelUp();
        initComponents();
        pack();
    }

    private void setPanelUp() {
        setTitle(ConstMessagesEN.Labels.ADD_EXAM);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }


    private void initComponents() {


        paperDscLbl = new JLabel();
        createQuestionPaperLbl = new JLabel();
        paperCodeLbl = new JLabel();
        paperCodeTF = new JTextField();
        paperTitleLbl = new JLabel();
        paperTitleTF = new JTextField();
        paperDscLbl = new JLabel();
        jScrollPane2 = new JScrollPane();
        paperDscTF = new JTextArea();
        paperCourseLbl = new JLabel();
        courseCB = new JComboBox<>(courseComboBoxModel);
        paperDurationLbl = new JLabel();
        durationCB = new JComboBox<>();
        saveBtn = new JButton();
        backBtn = new JButton();
        jLabel1 = new JLabel();

        paperDscLbl.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        paperDscLbl.setText("Description");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createQuestionPaperLbl.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        createQuestionPaperLbl.setText("Add Question Paper");

        paperCodeLbl.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        paperCodeLbl.setText("Paper Code");


        paperTitleLbl.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        paperTitleLbl.setText("Title");


        paperDscLbl.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        paperDscLbl.setText("Description");

        paperDscTF.setColumns(20);
        paperDscTF.setRows(5);
        jScrollPane2.setViewportView(paperDscTF);

        paperCourseLbl.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        paperCourseLbl.setText("Course");

        paperDurationLbl.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        paperDurationLbl.setText("Duration");

        durationCB.setModel(new DefaultComboBoxModel<>(new String[]{"1", "2", "3"}));
        durationCB.setSelectedItem(1);


        saveBtn.setIcon(new ImageIcon(getClass().getResource("/Images/Webp.net-resizeimage (4).png"))); // NOI18N
        saveBtn.setText("Save");


        backBtn.setText("Back");


        jLabel1.setFont(new Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("HR");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(172, 172, 172)
                                                .addComponent(createQuestionPaperLbl))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(paperCodeLbl)
                                                                        .addComponent(paperTitleLbl, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(29, 29, 29)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(paperCodeTF, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(paperTitleTF, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(paperDscLbl, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(paperCourseLbl, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(paperDurationLbl, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(courseCB, 0, 134, Short.MAX_VALUE)
                                                                        .addComponent(durationCB, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel1))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(112, 112, 112)
                                                .addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                .addGap(67, 67, 67)
                                                .addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(createQuestionPaperLbl)
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(paperCodeLbl)
                                        .addComponent(paperCodeTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(paperTitleLbl, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(paperTitleTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(paperDscLbl, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(paperCourseLbl, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(courseCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(paperDurationLbl)
                                        .addComponent(durationCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(saveBtn)
                                        .addComponent(backBtn))
                                .addGap(33, 33, 33))
        );
    }// </editor-fold>

    public AddQuestionPaperDto getQuestionPaperFromForm() {
        log.info(" ****** getting add question paper fields from from (AddExamFrame) ******");
        AddQuestionPaperDto addQuestionPaperDto = new AddQuestionPaperDto();
        addQuestionPaperDto.setPaperTitle(paperTitleTF.getText());
        addQuestionPaperDto.setPaperDsc(paperDscTF.getText());
        addQuestionPaperDto.setCourse((Course) courseCB.getSelectedItem());
        addQuestionPaperDto.setDuration((String) durationCB.getSelectedItem());
        addQuestionPaperDto.setPaperCode(paperCodeTF.getText());
        log.info(" ***** paper title == " + addQuestionPaperDto.getPaperTitle());
        return addQuestionPaperDto;

    }

    public void clearAddExamForm() {
        paperCodeTF.setText(Strings.EMPTY);
        paperTitleTF.setText(Strings.EMPTY);
        paperDscTF.setText(Strings.EMPTY);
    }


}
