package com.chaitanya.schoolmanagement.util.constant;

public interface ConstMessagesEN {

    interface DialogTitles {
        String STUDENT_MODAL = "Adding Student";
        String ADDRESS_MODAL = "Adding address";
        String PAYMENT_METHOD_MODAL = "Adding payment methods";
        String PAYMENT_MODAL = "Adding payments";
        String RESERVATION_MODAL = "Adding reservations";
        String ROOM_STATUS_MODAL = "Adding room statuses";
        String ROOM_TYPE_MODAL = "Adding room types";
        String ROOM_MODAL = "Adding rooms";
        String RATE_MODAL = "Adding rates";
        String COURSE_MODAL = "Adding Courses";
        String TEACHER_MODAL = "Add Teacher";
        String ADMIN_LOGIN_MODAL = "Admin Login";
        String STUDENT_LOGIN_MODAL = "Student Login";
        String TEACHER_LOGIN_MODAL = "Teacher Login";
        String WELCOME_STUDENT_MODAL = "Welcome Student";
        String TEACHER_DASHBOARD = "Welcome Teacher";
    }

    ;

    interface Messages {
        String WINDOWS_STYLE_LOADING_ERROR_MESSAGE = "There was an error while loading windows look an feel: ";
        String ALERT_TILE = "Alert";
        String NON_ROW_SELECTED = "Non row has been selected";
        String INFORMATION_TITLE = "Information";
        String DELETE_ROW_ERROR = "Could not delete a row. Check if there are any connections between tables.";
        String DELETED_QUESTION_PAPER = " Question Paper Successfully Deleted";
    }

    interface Labels {
        String MAIN_MENU = "Hotel reservations";
        String LOGIN = "Login";
        String STUDENTS = "Students";
        String MANAGE_EXAMS = "Manage Exams";
        String WELCOME_STUDENT = "Welcome";
        String SAVE = "Save";
        String UPDATE_STUDENT = "Update Details";
        String COURSES = "Courses";
        String TEACHERS = "Teachers";
        String ADMIN = "Admin";
        String ADD_BTN = "Add";
        String SaveAsCSV = "Save As Csv";
        String SaveAsExcel = "Save As Exel";
        String UPDATE_BTN = "Update";
        String CANCEL_BTN = "Cancel";
        String REMOVE_BTN = "Remove";
        String NAME = "Name";
        String PASSWORD = "Password";
        String COURSE = "Course";
        String EDIT = "Edit Student";
        String EDIT_QUESTION_PAPER = "Edit Question Paper";
        String PHONE_NUMBER = "Phone number";
        String EMAIL = "E-mail";
        String EDIT_TEACHER = "Edit Teacher";
        String COURSE_NAME = "Course Name";
        String STUDENT = "Student";
        String ADD_QUESTION = "Add Question";
        String ADD_EXAM = "Create Exam";
        String PAPER_CODE = "Paper Code";
        String PAPER_TITLE = "Paper Title";
        String EXAMS = "Exams";
        String EXAM_DASHBOARD = "Exam Dashboard";
        String QUESTION_DASHBOARD = "Question Dashboard";
        String QUESTION_NO = "Question No";
        String QUESTION = "Question";

    }

    interface ValidationMessages {
        String REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA = "All Fields are required";
        String USER_ALREADY_EXIST = "User with this email already exist";
        String INVALID_CREDENTIALS = "Wrong Credential! Please try again !!!! ";
        String QUESTION_PAPER_ALREADY_EXIST = "Question paper with entered paper code already exist";
    }
}
