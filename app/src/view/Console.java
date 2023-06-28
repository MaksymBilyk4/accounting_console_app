package view;

import controller.WorkingDayController;
import dao.WorkingDayDao;
import models.WorkingDay;
import services.WorkingDayService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {
    private final WorkingDayController dayController;
    private final List<String> options;
    Scanner scanner = new Scanner(System.in);

    public Console() {
        dayController = new WorkingDayController(new WorkingDayService(new WorkingDayDao()));
        options = new ArrayList<>();
        fillOptions();
    }

    public void run() {
        dayController.generateData();
        while (true) {
            showMenu();

            String userChoice = scanner.nextLine();
            switch (userChoice) {
                case "1" -> dayController.createDay();
                case "2" -> dayController.getAllAndPrint();
                case "3" -> dayController.getByDate();
                case "4" -> dayController.getStatisticFromDateAndCount();
                case "exit" -> exit();
            }
        }
    }

    public void fillOptions() {
        options.add("1. Додати робочий день");
        options.add("2. Отримати таблицю");
        options.add("3. Отримати день за датою");
        options.add("4. Отримати статистику за N днів");
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
