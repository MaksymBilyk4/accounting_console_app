package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatGenerator {
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