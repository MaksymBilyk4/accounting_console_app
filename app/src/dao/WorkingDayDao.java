package dao;

import models.WorkingDay;

import java.util.ArrayList;
import java.util.List;

public class WorkingDayDao implements Dao<WorkingDay> {
    List<WorkingDay> days = new ArrayList<>();


    public WorkingDayDao() {
    }

    @Override
    public List<WorkingDay> findAll() {
        return days;
    }

    @Override
    public WorkingDay save(WorkingDay day) {
        days.add(day);
        return day;
    }
}
