package com.chaitanya.schoolmanagement.ui.forms.exam.view;

import com.chaitanya.schoolmanagement.model.course.Course;
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
public class AddExamFrame extends JFrame {
    // Variables declaration - do not modify
    private JButton backBtn;
    private JComboBox<Course> courseCB;
    private JLabel createQuestionPaperLbl;
    private JComboBox<String> durationCB;
    private JLabel jLabel1;
    private JLabel paperCourseLbl;
    private JLabel paperDscLbl;
    private JTextField paperDscTF;
    private JLabel paperDurationLbl;
    private JLabel paperTitleLbl1;
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

        createQuestionPaperLbl = new JLabel();
        jLabel1 = new JLabel();
        paperDscLbl = new JLabel();
        paperTitleTF = new JTextField();
        paperTitleLbl1 = new JLabel();
        paperDscTF = new JTextField();
        paperCourseLbl = new JLabel();
        durationCB = new JComboBox<>();
        paperDurationLbl = new JLabel();
        courseCB = new JComboBox<>(courseComboBoxModel);
        saveBtn = new JButton();
        backBtn = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createQuestionPaperLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        createQuestionPaperLbl.setText("Create Question Paper");

        paperDscLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        paperDscLbl.setText("Description");

        paperTitleTF.setText("Title of Exam");


        paperTitleLbl1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        paperTitleLbl1.setText("Title");

        paperDscTF.setText("Description");


        paperCourseLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        paperCourseLbl.setText("Course");

        durationCB.setModel(new DefaultComboBoxModel<>(new String[]{"1", "2", "3"}));
        durationCB.setSelectedItem(1);


        paperDurationLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        paperDurationLbl.setText("Duration");


        saveBtn.setText("Save");

        backBtn.setText("Back");


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(49, 49, 49)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(197, 197, 197)
                                                .addComponent(createQuestionPaperLbl))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(paperDscLbl, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(paperTitleTF, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(paperDscTF, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(paperCourseLbl, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(courseCB, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(paperDurationLbl, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(durationCB, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addContainerGap(85, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                .addGap(152, 152, 152)
                                .addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                .addGap(119, 119, 119))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(paperTitleLbl1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(416, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(createQuestionPaperLbl)
                                .addGap(61, 61, 61)
                                .addComponent(jLabel1)
                                .addGap(7, 7, 7)
                                .addComponent(paperTitleTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(paperDscLbl, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(paperDscTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(paperCourseLbl, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(courseCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(paperDurationLbl, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(durationCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(saveBtn)
                                        .addComponent(backBtn))
                                .addGap(32, 32, 32))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(107, 107, 107)
                                        .addComponent(paperTitleLbl1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(253, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>

    public AddQuestionPaperDto getQuestionPaperFromForm() {
        log.info(" ****** getting add question paper fields from from (AddExamFrame) ******");
        AddQuestionPaperDto addQuestionPaperDto = new AddQuestionPaperDto();
        addQuestionPaperDto.setPaperTitle(paperTitleTF.getText());
        addQuestionPaperDto.setPaperDsc(paperDscTF.getText());
        addQuestionPaperDto.setCourse((Course) courseCB.getSelectedItem());
        addQuestionPaperDto.setDuration((String) durationCB.getSelectedItem());
        log.info(" ***** paper title == " + addQuestionPaperDto.getPaperTitle());
        return addQuestionPaperDto;

    }


}
