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
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
    private JTextArea paperDscTF;
    private JTextField paperCodeTF;
    private JLabel paperDurationLbl;
    private JLabel paperTitleLbl1;
    private JLabel paperCodeLbl;
    private JTextField paperTitleTF;
    private JButton saveBtn;
    private JScrollPane jScrollPane1;
    private JFormattedTextField jFormattedTextField;
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
        paperCodeLbl = new JLabel();
        paperDscLbl = new JLabel();
        paperTitleTF = new JTextField();
        paperCodeTF = new JTextField();
        paperTitleLbl1 = new JLabel();
        paperDscTF = new JTextArea();
        paperCourseLbl = new JLabel();
        durationCB = new JComboBox<>();
        paperDurationLbl = new JLabel();
        courseCB = new JComboBox<>(courseComboBoxModel);
        saveBtn = new JButton();
        backBtn = new JButton();
        jScrollPane1 = new JScrollPane();
        jFormattedTextField = new JFormattedTextField();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        paperCodeLbl.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        paperCodeLbl.setText("Paper Code");

        createQuestionPaperLbl.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        createQuestionPaperLbl.setText("Create Question Paper");

        paperDscLbl.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        paperDscLbl.setText("Description");

        paperTitleTF.setText("Title of Exam");


        paperTitleLbl1.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        paperTitleLbl1.setText("Title");

        paperDscTF.setColumns(20);
        paperDscTF.setRows(5);
        jScrollPane1.setViewportView(paperDscTF);


        paperCourseLbl.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        paperCourseLbl.setText("Course");

        durationCB.setModel(new DefaultComboBoxModel<>(new String[]{"1", "2", "3"}));
        durationCB.setSelectedItem(1);


        paperDurationLbl.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        paperDurationLbl.setText("Duration");


        saveBtn.setText("Save");

        backBtn.setText("Back");

        jFormattedTextField.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat(
                "H'h' mm'm'"))));
        jFormattedTextField.setValue(Calendar.getInstance().getTime());

        jFormattedTextField.addPropertyChangeListener("value", new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println(jFormattedTextField.getValue());
            }
        });


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
                                                .addGap(327, 327, 327)
                                                .addComponent(createQuestionPaperLbl)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(82, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(paperTitleLbl1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(paperCodeLbl))
                                                .addGap(140, 140, 140)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(paperTitleTF, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(paperCodeTF, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(86, 86, 86)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(paperDurationLbl, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(paperDscLbl, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(paperCourseLbl, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jFormattedTextField, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(courseCB, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))))
                                .addGap(195, 195, 195))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                .addGap(288, 288, 288))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(createQuestionPaperLbl)
                                .addGap(62, 62, 62)
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(paperCodeTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(paperCodeLbl))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(117, 117, 117)
                                                .addComponent(paperDscLbl, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(paperTitleTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(paperTitleLbl1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                                .addGap(33, 33, 33)
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(courseCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(paperCourseLbl, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(paperDurationLbl, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jFormattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(saveBtn)
                                        .addComponent(backBtn))
                                .addGap(29, 29, 29))
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
        addQuestionPaperDto.setPaperCode(paperCodeTF.getText());
        log.info(" ***** paper title == " + addQuestionPaperDto.getPaperTitle());
        return addQuestionPaperDto;

    }


}
