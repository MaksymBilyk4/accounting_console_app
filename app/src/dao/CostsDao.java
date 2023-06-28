package dao;

import models.Costs;

import java.util.ArrayList;
import java.util.List;

public class CostsDao implements Dao<Costs>{
    List<Costs> costs = new ArrayList<>();

    @Override
    public List<Costs> findAll() {
        return costs;
    }

    @Override
    public Costs save(Costs cost) {
        costs.add(cost);
        return cost;
    }
}
