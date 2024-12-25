package lms.service.impl;

import lms.dao.impl.GroupDaoImpl;
import lms.db.DataBase;
import lms.enums.Gender;
import lms.models.Group;
import lms.models.Student;
import lms.service.StudentService;

import java.util.Scanner;

public class StudentServiceImpl implements StudentService {
    private final GroupDaoImpl groupDao;


    static Scanner scannerForStr = new Scanner(System.in);
    static Scanner scannerForInt = new Scanner(System.in);

    public StudentServiceImpl(GroupDaoImpl groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public Student addStudent() {
        Student student = new Student();
        System.out.print("Group name: ");
        String name = scannerForStr.nextLine();
        String studentName = "";
        boolean isBlock = false;
        do {
            System.out.print("Name: ");
            studentName = new Scanner(System.in).nextLine();
            if (studentName.isEmpty()) {
                isBlock = true;
                System.out.print("Поле не должен быть пустым!");
            }
        }while (isBlock);
        System.out.print("Last name: ");
        String lastName = scannerForStr.nextLine();
        String email = "";
        boolean isBlock2  = false;
        do {
            System.out.print("Email: ");
            email = new Scanner(System.in).nextLine();
            if (!email.contains("@gmail.com")) {
                isBlock2= true;
                System.out.println("Invalid email!\nWrite with @gmail.com!!!");
            }
        }while (isBlock2);
        String password = "";
        boolean isBlock3 = false;
        do {
            System.out.print("Password: ");
            password = new Scanner(System.in).nextLine();
            if (password.length() < 6) {
                isBlock3 = true;
                System.out.println("Invalid password length!\nPassword length<6!!!");
            }
        }while (isBlock3);
        int number = 0;
        for (Gender value : Gender.values()) {
            number++;
            System.out.println(number + "." + value);
        }
        System.out.print("Gender: ");
        int choice = scannerForInt.nextInt();
        Gender[] genders = Gender.values();
        if (choice == 1) {
            for (int i = 0; i < genders.length; i++) {
                student.setGender(genders[choice - 1]);
            }
        }
        if (choice == 2) {
            for (int i = 0; i < genders.length; i++) {
                student.setGender(genders[choice - 1]);
            }
        }
        System.out.println(groupDao.addStudent(name, new Student(studentName, lastName, email, password, student.getGender())));
        return student;
    }

    @Override
    public void updateByName() {
        System.out.print("Student name for update: ");
        String name = scannerForStr.nextLine();
        groupDao.updateByName(name, addStudent());
    }

    @Override
    public void getStudentByName() {
        System.out.print("Name: ");
        String name = scannerForStr.nextLine();
        System.out.println(groupDao.getStudentByName(name));
    }

    @Override
    public void getStudentLesson() {
        System.out.print("email: ");
        String email = scannerForStr.nextLine();
        System.out.println(groupDao.getStudentLesson(email));
    }

    @Override
    public void deleteStudent() {
        System.out.print("email: ");
        String email = scannerForStr.nextLine();
        System.out.println(groupDao.deleteStudentByEmail(email));
    }
}
