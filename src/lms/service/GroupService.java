package lms.service;

import lms.models.Group;
import lms.models.Student;

import java.util.ArrayList;

public interface GroupService {
    void addGroup();

    void logIn(String email, String password);

    void getAllGroup();

    void getGroupByName();

    void updateGroupName();

    void getAllStudentByGroupName();

    void deleteGroupByName();
}
