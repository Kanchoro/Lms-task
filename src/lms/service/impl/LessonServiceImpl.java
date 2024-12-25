package lms.service.impl;

import lms.dao.GroupDao;
import lms.models.Lesson;
import lms.service.LessonService;

import java.util.Scanner;

public class LessonServiceImpl implements LessonService {
    private final GroupDao groupDao;

    static Scanner scannerForStr = new Scanner(System.in);
    static Scanner scannerForInt = new Scanner(System.in);

    public LessonServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public void addLesson() {
        System.out.print("Group name: ");
        String name = scannerForStr.nextLine();
        String lessonName ="";
        boolean isBlock2  = false;
        do {
            System.out.print("Lesson name: ");
            lessonName = new Scanner(System.in).nextLine();
            if (lessonName.isEmpty()) {
                isBlock2= true;
                System.out.println("Поле не должен быть пустым!");
            }
        }while (isBlock2);
        boolean isBlock3  = false;
        String description = "";
        do {
            System.out.print("Description: ");
            description = new Scanner(System.in).nextLine();
            if (description.isEmpty()) {
                isBlock3= true;
                System.out.println("Поле не должен быть пустым!");
            }
        }while (isBlock3);
        groupDao.addLesson(name, new Lesson(lessonName, description));
    }

    @Override
    public void getLessonByName() {
        System.out.print("Lesson name: ");
        String name = scannerForStr.nextLine();
        System.out.println(groupDao.getLessonByName(name));
    }

    @Override
    public void getLessonByGroupName() {
        System.out.print("Group name: ");
        String name = scannerForStr.nextLine();
        System.out.println(groupDao.getAllLessonByGroupName(name));
    }

    @Override
    public void deleteLessonById() {
        System.out.print("Lesson id: ");
        Long id = scannerForInt.nextLong();
        System.out.println(groupDao.deleteLessonById(id));
    }
}
