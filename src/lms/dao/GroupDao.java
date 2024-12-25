package lms.dao;

import lms.models.Group;
import lms.models.Lesson;
import lms.models.Student;

import java.util.ArrayList;
import java.util.List;

public interface GroupDao {
    void getAllGroup();
    Group getGroupByName(String name);
    String updateGroupName(String name,String newName);
    String addStudent(String groupName , Student student);
    void updateByName(String name , Student student);
    List<Student> getStudentByName(String name);
    void getAllStudentByGroupName(String name);
    String getStudentLesson(String email);
    String deleteStudentByEmail(String email);
    void addLesson(String groupName,Lesson lesson);
    List<Lesson> getLessonByName(String name);
    String getAllLessonByGroupName ( String name);
    String deleteLessonById(Long id);
    String deleteGroupByName(String name);

}
