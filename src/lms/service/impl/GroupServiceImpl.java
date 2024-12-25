package lms.service.impl;

import lms.dao.impl.GroupDaoImpl;
import lms.db.DataBase;
import lms.exeption.MyException;
import lms.models.Group;
import lms.models.Student;
import lms.service.GroupService;
import lms.service.LessonService;
import lms.service.StudentService;

import java.util.Scanner;

public class GroupServiceImpl implements GroupService {
    private final GroupDaoImpl groupDao;

    static Scanner scannerForStr = new Scanner(System.in);
    static Scanner scannerForInt = new Scanner(System.in);

    GroupDaoImpl groupDao2 = new GroupDaoImpl();
    StudentService service = new StudentServiceImpl(groupDao2);

    LessonService lessonService = new LessonServiceImpl(groupDao2);

    public GroupServiceImpl(GroupDaoImpl groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public void addGroup() {
        boolean isBlock = false;
        String name = "";
        do {
            isBlock = false;
            System.out.print("Group name: ");
            name = new Scanner(System.in).nextLine();
            if (name.isEmpty()) {
                isBlock = true;
                System.out.println("Поле не должен быть пустым!");
            }
            for (Group group : DataBase.groups) {
                if (group.getGroupName().equals(name)) {
                    isBlock = true;
                    System.out.println("Такое имя уже существует!");
                }
            }
        } while (isBlock);
        System.out.print("Description: ");
        String description = scannerForStr.nextLine();

        DataBase.groups.add(new Group((name), description));
    }

    @Override
    public void logIn(String email, String password) {
        System.out.print("Email: ");
        String emails = scannerForStr.nextLine();
        System.out.print("Password: ");
        String passwords = scannerForStr.nextLine();
        for (Group group : DataBase.groups) {
            for (Student student : group.getStudents()) {
                if (emails.equals(email) && passwords.equals(password)) {
                    System.out.println("====ADMIN====");
                    while (true) {
                        System.out.println("""
                                
                                1  -> Add new group
                                2  -> Get group by name
                                3  -> Update group name by group name
                                4  -> Get all group
                                5  -> Add new student to group
                                6  -> Update student by name
                                7  -> Find student by first name
                                8  -> Get all student by group name
                                9  -> Get all students lesson's
                                10 -> Delete student by email
                                11 -> Add new lesson to group
                                12 -> Get lesson by name
                                13 -> Get all lesson by group name
                                14 -> Delete lesson by id
                                15 -> Delete group by name
                                0  -> Exit
                                """);
                        boolean isBlock = false;
                        int choice = 0;
                        do {
                            try {
                                isBlock = false;
                                System.out.print("Command: ");
                                choice = new Scanner(System.in).nextInt();
                            } catch (RuntimeException e) {
                                isBlock = true;
                                System.out.println("Invalid command!");
                            }
                        } while (isBlock);
                        switch (choice) {
                            case 1 -> {
                                addGroup();
                            }
                            case 2 -> {
                                getGroupByName();
                            }
                            case 3 -> {
                                updateGroupName();
                            }
                            case 4 -> {
                                getAllGroup();
                            }
                            case 5 -> {
                                service.addStudent();
                            }
                            case 6 -> {
                                service.updateByName();
                            }
                            case 7 -> {
                                service.getStudentByName();
                            }
                            case 8 -> {
                                getAllStudentByGroupName();
                            }
                            case 9 -> {
                                service.getStudentLesson();
                            }
                            case 10 -> {
                                service.deleteStudent();
                            }
                            case 11 -> {
                                lessonService.addLesson();
                            }
                            case 12 -> {
                                lessonService.getLessonByName();
                            }
                            case 13 -> {
                                lessonService.getLessonByGroupName();
                            }
                            case 14 -> {
                                lessonService.deleteLessonById();
                            }
                            case 15 -> {
                                deleteGroupByName();
                            }
                            case 0 -> {
                                System.out.println("Bey-bey!");
                                return;
                            }
                            default -> System.out.println("Invalid number!");
                        }

                    }
                } else if (student.getEmail().equals(emails) && student.getPassword().equals(passwords)) {
                    System.out.println("====Student=====");
                    System.out.println("""
                             1.Get all lesson by group name.
                             2.Get lesson by lesson name.
                             0.Exit.
                            """);
                    System.out.print("Command: ");
                    int number = 0;
                    boolean isBlock ;
                    do {
                        try {
                             number = new Scanner(System.in).nextInt();
                             isBlock = false;
                        } catch (Exception e) {
                            isBlock = true;
                            throw new MyException("Invalid command!");
                        }
                    }while (isBlock);
                    switch (number){
                        case 1->{
                            lessonService.getLessonByGroupName();
                        }
                        case 2->{
                            lessonService.getLessonByName();
                        }
                        case 0->{
                            System.out.println("Bye-bye!");
                            return;
                        }
                        default -> System.out.println("Invalid number!");
                    }

                } else System.out.println("incorrect email or password!");
            }
        }
    }

    @Override
    public void getAllGroup() {
        groupDao.getAllGroup();
    }

    @Override
    public void getGroupByName() {
        System.out.print("Group name: ");
        String name = scannerForStr.nextLine();
        System.out.println(groupDao.getGroupByName(name));
    }

    @Override
    public void updateGroupName() {
        System.out.print("Group name for update: ");
        String name = scannerForStr.nextLine();
        String newName = "";
        boolean isBlock = false;
        do {
            isBlock = false;
            System.out.print("New group name: ");
            newName = new Scanner(System.in).nextLine();
            if (newName.isEmpty()) {
                isBlock = true;
                System.out.println("Поле не должен быть пустым!");
            }
            for (Group group : DataBase.groups) {
                if (group.getGroupName().equals(newName)) {
                    isBlock = true;
                    System.out.println("Такое имя уже существует!");
                }
            }

        } while (isBlock);
        System.out.println(groupDao.updateGroupName(name, newName));
    }

    @Override
    public void getAllStudentByGroupName() {
        System.out.print("Group name: ");
        String name = scannerForStr.nextLine();
        groupDao.getAllStudentByGroupName(name);
    }

    @Override
    public void deleteGroupByName() {
        System.out.print("Group name: ");
        String name = scannerForStr.nextLine();
        System.out.println(groupDao.deleteGroupByName(name));
    }

}
