package lms.models;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private Long id;
    private String groupName;
    private String description;
    private List<Lesson> lessons;
    private List<Student> students;

    private static Long generateId = 1L;

    public Group() {
        this.id =generateId++;
    }

    public Group(String groupName, String description, ArrayList<Lesson> lessons, ArrayList<Student> students) {
        this.id =generateId++;
        this.groupName = groupName;
        this.description = description;
        this.lessons = lessons;
        this.students = students;
    }

    public Group( String groupName, String description) {
        this.id =generateId++;
        this.groupName = groupName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setGenerateId(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group" +
                "\nId:            " + id +
                "\nGroup name:    " + groupName +
                "\nDescription:   " + description +
                "\nLessons:       " + lessons +
                "\nStudents:      " + students+
                "============================"
                ;
    }
}
