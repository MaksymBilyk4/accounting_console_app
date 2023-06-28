package view;

import controller.CostController;
import controller.WorkingDayController;
import dao.CostsDao;
import dao.WorkingDayDao;
import services.CostsService;
import services.WorkingDayService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {
    private final WorkingDayController dayController;
    private final CostController costController;
    private final List<String> options;
    Scanner scanner = new Scanner(System.in);

    public Console() {
        costController = new CostController(new CostsService(new CostsDao()));
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
                case "2" -> dayController.printDaysTable();
                case "3" -> dayController.getByDate();
                case "4" -> dayController.getStatisticFromDateAndCount();
                case "5" -> dayController.getAllProfit();
                case "6" -> costController.createCost();
                case "7" -> costController.printCostTable();
                case "8" -> costController.calcAllCosts();
                case "exit" -> exit();
            }
        }
    }

    public void fillOptions() {
        options.add("\nРобочі дні:\n");
        options.add("1. Додати робочий день");
        options.add("2. Отримати таблицю");
        options.add("3. Отримати день за датою");
        options.add("4. Отримати статистику за N днів");
        options.add("5. Отримати статистику за N днів");
        options.add("\nВитрати:\n");
        options.add("6. Додати витрату");
        options.add("7. Отримати таблицю витрат");
        options.add("8. Отримати витрати за весь час");
        options.add("\nЩоб завершити роботу - напишіть exit");
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
