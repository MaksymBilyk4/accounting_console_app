package view;

import dao.WorkingDayDao;
import services.WorkingDayService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {
    private final WorkingDayService dayService;

    private final List<String> options;
    Scanner scanner = new Scanner(System.in);

    public Console() {
        dayService = new WorkingDayService(new WorkingDayDao());
        options = new ArrayList<>();
        fillOptions();
    }

    public void run() {
        while (true) {
            showMenu();

            String userChoice = scanner.nextLine();
            switch (userChoice){
                case "1" -> dayService.createWorkingDay();
                case "2" -> System.out.println("Ви обрали отримати таблицю:");
                case "exit" -> exit();
            }
        }
    }

    public void fillOptions() {
        options.add("1. Додати робочий день");
        options.add("2. Отримати таблицю");
        options.add("Щоб завершити роботу - напишіть exit");
    }

    public void showMenu() {
        System.out.println("\nВиберіть пункт меню:");
        options.forEach(System.out::println);
    }

    public void exit() {
        scanner.close();
        System.out.println("\nДопобачення");
        System.exit(1);
    }
}
