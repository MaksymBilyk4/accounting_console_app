package services;

import dao.CostsDao;
import models.Costs;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CostsService {
    private final CostsDao dao;

    public CostsService(CostsDao dao) {
        this.dao = dao;
    }

    public List<Costs> findAll() {
        return dao.findAll();
    }

    public Costs save(String date, String name, int cost) {
        Costs c = new Costs(date, name, cost);
        return dao.save(c);
    }

    public int getTotalCosts () {
        List<Costs> costsList = findAll();

        return costsList.stream()
                .mapToInt(Costs::getPrice)
                .sum();
    }

    public void generateCosts() {
        int i = 0;
        while (i < 20) {
            i +=4;
            String dateStr = (i < 10) ? String.format("0%d.06.2023", i) : String.format("%d.06.2023", i);
            String name = "Сміття | Комуналка | Покупки";
            int cost = ThreadLocalRandom.current().nextInt(100, 5000);
            save(dateStr, name, cost);
        }
    }
}
