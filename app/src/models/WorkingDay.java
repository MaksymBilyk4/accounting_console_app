package models;

import java.util.Objects;

public class WorkingDay {
    private String date;
    private Employees employeeName;
    private Long cardProfit;
    private Long cashProfit;
    private Long employeePercent;
    private int dailySalary;

    private int generalSalary;
    private Long profit;
    private Long generalDailyProfit;

    public WorkingDay() {
    }

    public WorkingDay(
            String date,
            Employees employeeName,
            Long cardProfit,
            Long cashProfit,
            Long employeePercent,
            int dailySalary,
            int generalSalary,
            Long profit,
            Long generalDailyProfit
    ) {
        this.date = date;
        this.employeeName = employeeName;
        this.cardProfit = cardProfit;
        this.cashProfit = cashProfit;
        this.employeePercent = employeePercent;
        this.dailySalary = dailySalary;
        this.generalSalary = generalSalary;
        this.profit = profit;
        this.generalDailyProfit = generalDailyProfit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Employees getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(Employees employee) {
        this.employeeName = employee;
    }

    public Long getCardProfit() {
        return cardProfit;
    }

    public void setCardProfit(Long cardProfit) {
        this.cardProfit = cardProfit;
    }

    public Long getCashProfit() {
        return cashProfit;
    }

    public void setCashProfit(Long cashProfit) {
        this.cashProfit = cashProfit;
    }

    public Long getEmployeePercent() {
        return employeePercent;
    }

    public void setEmployeePercent(Long employeePercent) {
        this.employeePercent = employeePercent;
    }

    public int getDailySalary() {
        return dailySalary;
    }

    public void setDailySalary(int dailySalary) {
        this.dailySalary = dailySalary;
    }

    public int getGeneralSalary() {
        return generalSalary;
    }

    public void setGeneralSalary(int generalSalary) {
        this.generalSalary = generalSalary;
    }

    public Long getGeneralDailyProfit() {
        return generalDailyProfit;
    }

    public void setGeneralDailyProfit(Long generalDailyProfit) {
        this.generalDailyProfit = generalDailyProfit;
    }

    public Long getProfit() {
        return profit;
    }

    public void setProfit(Long profit) {
        this.profit = profit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkingDay that = (WorkingDay) o;
        return dailySalary == that.dailySalary && generalSalary == that.generalSalary && Objects.equals(date, that.date) && employeeName == that.employeeName && Objects.equals(cardProfit, that.cardProfit) && Objects.equals(cashProfit, that.cashProfit) && Objects.equals(employeePercent, that.employeePercent) && Objects.equals(generalDailyProfit, that.generalDailyProfit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, employeeName, cardProfit, cashProfit, employeePercent, dailySalary, generalSalary, generalDailyProfit);
    }

    @Override
    public String toString() {
        return "День: " + date + '\n' +
                "Працівник: " + employeeName + '\n' +
                "Дохід картка: " + cardProfit + '\n' +
                "Дохід готівка: " + cashProfit + '\n' +
                "2% доходу" + employeePercent + '\n' +
                "З/П за день" + dailySalary + '\n' +
                "З/П за 10 днів" + generalSalary + '\n' +
                "Загальний дохід" + profit + '\n' +
                "Чистий дохід" + generalDailyProfit;
    }
}
