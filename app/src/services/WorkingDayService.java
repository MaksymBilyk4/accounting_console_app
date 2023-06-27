package services;

import dao.WorkingDayDao;
import models.enums.Employees;
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


    public void createWorkingDay(String date, Employees employee, Long cardProfit, Long cashProfit, Long profit, long percent, int dailySalary, int generalSalary, Long dailyProfit) {
        WorkingDay day = new WorkingDay(date, employee, cardProfit, cashProfit, percent, dailySalary, generalSalary, profit, dailyProfit);
        System.out.println(day);
        dao.save(day);
    }

    public List<WorkingDay> getAllDays() {
        return dao.findAll();
    }

    public void generateDaysData() {

        for (int i = 1; i <= 5; i++) {
            WorkingDay day = new WorkingDay();
            day.setDate(createCurrentDateFormat());
            day.setEmployeeName(Employees.DARIA);
            day.setCardProfit(2500L);
            day.setCashProfit(2500L);
            day.setProfit(day.getCardProfit() + day.getCashProfit());
            day.setEmployeePercent((long) (day.getProfit() * 0.02));
            day.setDailySalary(350);
            day.setGeneralSalary(0);
            day.setGeneralDailyProfit(day.getProfit() - day.getDailySalary() - day.getEmployeePercent() - day.getGeneralSalary());
            dao.save(day);
        }
    }

    public String createCurrentDateFormat() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");


        switch (localDate.getDayOfWeek()) {
            case MONDAY -> {
                return localDate.format(formatter) + " Пн";
            }
            case TUESDAY -> {
                return localDate.format(formatter) + " Вт";
            }
            case WEDNESDAY -> {
                return localDate.format(formatter) + " Ср";
            }
            case THURSDAY -> {
                return localDate.format(formatter) + " Чт";
            }
            case FRIDAY -> {
                return localDate.format(formatter) + " Пт";
            }
            case SATURDAY -> {
                return localDate.format(formatter) + " Сб";
            }
            case SUNDAY -> {
                return localDate.format(formatter) + " Нд";
            }
            default -> {
                return "";
            }
        }
    }
}
