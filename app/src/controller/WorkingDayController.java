package controller;

import models.WorkingDay;
import models.enums.Employees;
import services.WorkingDayService;

import java.util.List;
import java.util.Scanner;

public class WorkingDayController {
    private final WorkingDayService dayService;

    public WorkingDayController(WorkingDayService dayService) {
        this.dayService = dayService;
    }

    public void createDay() {
        Scanner scanner = new Scanner(System.in);
        String date = "";
        System.out.println("\n1. Згенерувати дату автоматично? (Так / Ні) ");

        String dateResponse = scanner.nextLine().toLowerCase();

        if (dateResponse.equals("так")) {
            System.out.println("Дата згенерована автоматично: ");
            date = dayService.createCurrentDateFormat();
        } else {
            System.out.println("Введіть дату в форматі (dd.mm.yyyy Day). Приклад - 20.04.2023 Пн");
            date = scanner.nextLine();
        }

        System.out.println(date);

        System.out.println("\n2. Виберіть працівника (1) " + Employees.DARIA + " | (2) " + Employees.YULIA);
        String employee = scanner.nextLine();
        Employees employeeName;
        if (employee.equals("1")) {
            employeeName = Employees.DARIA;
        } else {
            employeeName = Employees.YULIA;
        }

        System.out.println("Працівник: " + employeeName);

        System.out.println("\n3. Введіть дохід карткою: ");
        Long cardProfit = scanner.nextLong();
        System.out.println("Дохід карткою: " + cardProfit + " грн");

        System.out.println("\n4. Введіть дохід готівкою: ");
        Long cashProfit = scanner.nextLong();
        System.out.println("Дохід готівкою: " + cashProfit + " грн");

        System.out.println("\n5. Підрахунок доходу... ");
        Long profit = cardProfit + cashProfit;
        System.out.println("Загалльний дохід " + profit + " грн");

        System.out.println("\n6. Підрахунок відсотків... ");
        long percent = (long) (profit * 0.02);
        System.out.println("Відсоток працівника " + employeeName + ": " + percent + " грн");

        System.out.println("\n7. Заробітна плата працівника " + employeeName + " за день: ");
        int dailySalary = scanner.nextInt();

        System.out.println("\n8. Заробітна плата (за 10 днів) або введіть 0: ");
        int generalSalary = scanner.nextInt();

        System.out.println("\n9. Підрахунок чистого доходу: ");
        Long dailyProfit = profit - percent - dailySalary - generalSalary;
        System.out.println("Чисті: " + dailyProfit + " грн");

        dayService.createWorkingDay(date, employeeName, cardProfit, cashProfit, profit, percent, dailySalary, generalSalary, dailyProfit);
    }

    public void getAllAndPrint() {
        List<WorkingDay> days = dayService.getAllDays();
        days.forEach(System.out::println);
    }

    public void generateData () {
        dayService.generateDaysData();
    }
}
