package services;

import dao.WorkingDayDao;
import models.enums.Employees;
import models.WorkingDay;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WorkingDayService {
    public final WorkingDayDao dao;

    public WorkingDayService(WorkingDayDao dao) {
        this.dao = dao;
    }


    public WorkingDay createWorkingDay(String date, Employees employee, Long cardProfit, Long cashProfit, Long profit, long percent, int dailySalary, int generalSalary, Long dailyProfit) {
        WorkingDay day = new WorkingDay(date, employee, cardProfit, cashProfit, percent, dailySalary, generalSalary, profit, dailyProfit);
        return dao.save(day);
    }

    public List<WorkingDay> getAllDays() {
        return dao.findAll();
    }

    public Long getTotalProfit () {
        return dao.findAll().stream()
                .mapToLong(WorkingDay::getGeneralDailyProfit)
                .sum();
    }

    public void generateDaysData() {
        int min = 500;
        int max = 1000;

        for (int i = 1; i <= 30; i++) {
            String dateStr = (i < 10) ? String.format("0%d.06.2023", i) : String.format("%d.06.2023", i);

            long card = ThreadLocalRandom.current().nextLong(min, max + 1);
            long cash = ThreadLocalRandom.current().nextLong(min, max + 1);
            long profit = cash + card;
            long percent = (long) (profit * 0.02);
            Long generalProfit = profit - percent - 350;

            WorkingDay day = new WorkingDay(dateStr, Employees.YULIA, card, cash, percent, 350, 0, profit, generalProfit);

            dao.save(day);
        }
    }

    public List<WorkingDay> getDayByDate (String dateStr) {
        List<WorkingDay> days = getAllDays();

        return days.stream()
                .filter(day -> day.getDate().substring(0, 10).equals(dateStr))
                .toList();
    }

    public List<WorkingDay> getCountDayStatistic(String date, int count) {
        WorkingDay day = getDayByDate(date).get(0);
        List<WorkingDay> dayList = getAllDays();

        return dayList.subList(dayList.indexOf(day), dayList.indexOf(day) + count);
    }

    public WorkingDay calcStatisticForPeriod(List<WorkingDay> dayList) {
        Long cardProfit = 0L;
        Long cashProfit = 0L;
        Long employeePercent = 0L;
        int dailySalary = 0;
        int generalSalary = 0;
        Long profit = 0L;
        Long generalProfit = 0L;

        for (WorkingDay d: dayList) {
            cardProfit += d.getCardProfit();
            cashProfit += d.getCashProfit();
            employeePercent += d.getEmployeePercent();
            dailySalary += d.getDailySalary();
            generalSalary += d.getGeneralSalary();
            profit += d.getProfit();
            generalProfit += d.getGeneralDailyProfit();
        }

        return new WorkingDay(cardProfit, cashProfit, employeePercent, dailySalary, generalSalary, profit, generalProfit);
    }
}
