package dao;

import models.WorkingDay;

import java.util.ArrayList;
import java.util.List;

public class WorkingDayDao {
    List<WorkingDay> days = new ArrayList<>();


    public WorkingDayDao() {}

    public List<WorkingDay> findAll() {
        return days;
    }

    public List<WorkingDay> save(WorkingDay day) {
        days.add(day);
        return days;
    }
}
