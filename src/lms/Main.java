package lms;

import lms.dao.impl.GroupDaoImpl;
import lms.service.GroupService;
import lms.service.impl.GroupServiceImpl;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GroupDaoImpl groupDao = new GroupDaoImpl();
        GroupService groupService = new GroupServiceImpl(groupDao);

        final String email = "admin@gmail.com";
        final String password = "Admin12";

        ZonedDateTime bishkekTime = ZonedDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = bishkekTime.format(timeFormatter);
        LocalTime noon = LocalTime.of(16, 0);
        LocalTime noon2 = LocalTime.of(6, 0);
        LocalTime noon3 = LocalTime.of(10, 0);

        if (noon.isBefore(LocalTime.parse(formattedTime))) {
            System.out.println("-----Кутман кеч! Саат -> " + formattedTime);
        } else if (noon3.isBefore(LocalTime.parse(formattedTime)) && noon.isAfter(LocalTime.parse(formattedTime))) {
            System.out.println("------Кутмандуу кун! Саат -> " + formattedTime);
        } else if (noon2.isBefore(LocalTime.parse(formattedTime)) && noon3.isAfter(LocalTime.parse(formattedTime))) {
            System.out.println("------Кутман тан! Саат -> " + formattedTime);
        }
        while (true) {
            System.out.print("""
                    1.Log in
                    0.Exit
                    """);
            System.out.print("Command: ");
            int choice = 0;
            switch (number(choice)) {
                case 1 -> {
                    groupService.logIn(email, password);
                }

                case 0 -> {
                    System.out.println("Bye-bye!");
                    return;
                }
                default -> System.out.println("Invalid number!");
            }
        }
    }

    public static int number(int choice) {
        boolean isBlock = false;
        do {
            try {
                isBlock = false;
                choice = new Scanner(System.in).nextInt();
            } catch (RuntimeException r) {
                System.out.print("Invalid command!\n: ");
                isBlock = true;
            }
        } while (isBlock);
        return choice;
    }
}