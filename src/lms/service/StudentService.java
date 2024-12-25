package lms.service;

import lms.models.Group;
import lms.models.Student;

public interface StudentService {
    Student addStudent();

    void updateByName();

    void getStudentByName();

    void getStudentLesson();

    void deleteStudent();
}
