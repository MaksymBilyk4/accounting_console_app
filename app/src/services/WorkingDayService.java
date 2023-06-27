package services;

import dao.WorkingDayDao;
import models.Employees;
import models.WorkingDay;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class WorkingDayService {
    public final WorkingDayDao dao;

    public WorkingDayService(WorkingDayDao dao) {
        this.dao = dao;
    }

    public List<WorkingDay> findAll() {
        return dao.findAll();
    }

    public List<WorkingDay> createWorkingDay () {
        WorkingDay day = new WorkingDay();

        System.out.println("1. Дата зненерована автоматично");
        createCurrentDateFormat(day);
        System.out.println("Дата: " + day.getDate());

        System.out.println("\n2. Виберіть працівника (1) " + Employees.DARIA + " | (2) " + Employees.YULIA);
        Scanner sc = new Scanner(System.in);
        String empl = sc.nextLine();
        if (empl.equals("1")) {
            day.setEmployeeName(Employees.DARIA);
        } else {
            day.setEmployeeName(Employees.YULIA);
        }
        System.out.println("2. Працівник: " + day.getEmployeeName());

        System.out.println("\n3. Введіть дохід картко:");
        Long cardProfit = sc.nextLong();
        day.setCardProfit(cardProfit);
        System.out.println("3. Дохід карткою: " + cardProfit);

        System.out.println("\n4. Введіть дохід готівкою:");
        Long cashProfit = sc.nextLong();
        day.setCashProfit(cashProfit);
        System.out.println("4. Дохід готівкою: " + cashProfit);

        System.out.println("\n5. Підрахунок загального доходу... ");
        Long profit = cardProfit + cashProfit;
        day.setProfit(profit);
        System.out.println(profit + " грн");

        System.out.println("\n6. Підрахунок відсотків...");
        long percent = (long) (profit * 0.02);
        day.setEmployeePercent(percent);
        System.out.println("6. Відсоток працівника " + day.getEmployeeName() + " 2% становить: " + percent);

        System.out.println("\n7. Заробітна блата працівника " + day.getEmployeeName());
        int dailySalary = sc.nextInt();
        day.setDailySalary(dailySalary);
        System.out.println("7. Заробітна плата за день: " + dailySalary);

        System.out.println("\n8. Заробітна плата (за 10 днів) або введіть 0: ");
        int generalSalary = sc.nextInt();
        day.setGeneralSalary(generalSalary);


        System.out.println("\n9. Підрахунок чистого доходу за день з урахунком витрат: ");
        Long dailyProfit = (cardProfit + cashProfit - percent - dailySalary - generalSalary);
        day.setGeneralDailyProfit(dailyProfit);
        System.out.println("9. Загальний дохід за день з урахунком усіх витрат");

        System.out.println(day);

        return dao.save(day);
    }

    public static void createCurrentDateFormat(WorkingDay day) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");


        switch (localDate.getDayOfWeek()){
            case MONDAY -> day.setDate(localDate.format(formatter) + " Понеділок");
            case TUESDAY -> day.setDate(localDate.format(formatter) + " Вівторок");
            case WEDNESDAY -> day.setDate(localDate.format(formatter) + " Середа");
            case THURSDAY -> day.setDate(localDate.format(formatter) + " Четверг");
            case FRIDAY -> day.setDate(localDate.format(formatter) + " П'ятнция");
            case SATURDAY -> day.setDate(localDate.format(formatter) + " Субота");
            case SUNDAY -> day.setDate(localDate.format(formatter) + " Неділя");
        }
    }
}
