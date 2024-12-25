package lms.dao.impl;
import lms.dao.GroupDao;
import lms.db.DataBase;
import lms.models.Group;
import lms.models.Lesson;
import lms.models.Student;
import java.util.ArrayList;
import java.util.List;

public class  GroupDaoImpl implements GroupDao {

    @Override
    public void getAllGroup() {
        System.out.println(DataBase.groups);
    }

    @Override
    public Group getGroupByName(String name) {
        for (Group group : DataBase.groups) {
            if (group.getGroupName().equals(name)) {
                return group;
            }
        }
        return null;
    }

    @Override
    public String updateGroupName(String name, String newName) {
        for (Group group : DataBase.groups) {
            if (group.getGroupName().equals(name)) {
                group.setGroupName(newName);
                return "Successfully updated.";
            }
        }
        return "Group with " + name + " not found!";
    }

    @Override
    public String addStudent(String groupName, Student student) {
        for (Group group : DataBase.groups) {
            if (group.getGroupName().equals(groupName)) {
                if (group.getStudents() == null) {
                    group.setStudents(new ArrayList<>());
                    group.getStudents().add(student);
                    return "Successfully saved!";
                } else {
                    group.getStudents().add(student);
                    return "Successfully saved!";
                }

            }
        }
        return "Group with " + groupName + " name not found";
    }

    @Override
    public void updateByName(String name, Student newStudent) {
        boolean isBlock = false;
        for (Group group : DataBase.groups) {
            for (Student student1 : group.getStudents()) {
                if (student1.getName().equals(name)) {
                    isBlock = true;
                    student1.setName(newStudent.getName());
                    student1.setGender(newStudent.getGender());
                    student1.setEmail(newStudent.getEmail());
                    student1.setLastName(newStudent.getLastName());
                    student1.setPassword(newStudent.getPassword());
                    System.out.println("Successfully updated!");
                    break;
                }
            }
        }
        if (isBlock){
            System.out.println("Student "+name+" with name not found!");
        }
    }

    @Override
    public List<Student> getStudentByName(String name) {
        for (Group group : DataBase.groups) {
            for (Student student : group.getStudents()) {
                if (name.equalsIgnoreCase(student.getName())){
                   return group.getStudents();
                }
            }
        }
        return null;
    }

    @Override
    public void getAllStudentByGroupName(String name) {
        boolean isBlock = false;
        for (Group group : DataBase.groups) {
            if (name.equalsIgnoreCase(group.getGroupName())){
                isBlock = true;
                System.out.println(group.getStudents());
            }
        }
        if (isBlock){
            System.out.println("Group "+name+" with name not found!");
        }
    }

    @Override
    public String getStudentLesson(String email) {
        for (Group group : DataBase.groups) {
            for (Student student : group.getStudents()) {
                if (email.equals(student.getEmail())){
                    return group.getLessons().toString();
                }
            }
        }
        return email+" not found!";
    }

    @Override
    public String deleteStudentByEmail(String email) {
        for (Group group : DataBase.groups) {
            for (Student student : group.getStudents()) {
                if (student.getEmail().equals(email)){
                    group.getStudents().remove(student);
                    return "Successfully deleted!";
                }
            }
        }
        return "Student with "+ email+ " not found!";
    }

    @Override
    public void addLesson(String groupName, Lesson lesson) {
        boolean isBlock = false;
        for (Group group : DataBase.groups) {
            if (group.getGroupName().equalsIgnoreCase(groupName)){
                isBlock = true;
                group.getLessons().add(lesson);
                System.out.println("Successfully saved!");
                break;
            }
        }
        if (isBlock){
            System.out.println(groupName+" not found!");
        }
    }

    @Override
    public List<Lesson> getLessonByName(String name) {
        boolean isBlock = false;
        for (Group group : DataBase.groups) {
            for (Lesson lesson : group.getLessons()) {
                if (lesson.getName().equalsIgnoreCase(name)){
                    isBlock = true;
                    return group.getLessons();
                }
            }
        }
        if (isBlock){
            System.out.println("Lesson with "+ " name not found!");
        }
        return null;
    }

    @Override
    public String getAllLessonByGroupName(String name) {
        for (Group group : DataBase.groups) {
            if (group.getGroupName().equalsIgnoreCase(name)){
                System.out.println(group.getLessons());
                break;
            }
        }
        return "Group by "+" name not found!";
    }

    @Override
    public String deleteLessonById(Long id) {
        for (Group group : DataBase.groups) {
            for (Lesson lesson : group.getLessons()) {
                if (lesson.getId().equals(id)){
                    group.getLessons().remove(lesson);
                    return "Successfully deleted!";
                }
            }
        }
        return "Lesson with "+id+" not found!";
    }

    @Override
    public String deleteGroupByName(String name) {
        for (Group group : DataBase.groups) {
            if (group.getGroupName().equalsIgnoreCase(name)){
                DataBase.groups.remove(group);
                return "Successfully deleted!";
            }
        }
        return "Group with "+name+" not found!";
    }

}
