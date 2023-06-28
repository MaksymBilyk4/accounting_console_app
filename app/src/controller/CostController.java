package controller;

import models.Costs;
import services.CostsService;
import utils.DateFormatGenerator;

import java.util.List;
import java.util.Scanner;

public class CostController {
    private final CostsService service;

    public CostController(CostsService service) {
        this.service = service;
    }

    public void calcAllCosts() {
        System.out.println("Витрати за весь час: ");
        System.out.println(service.getTotalCosts() + " грн");
    }

    public void printCostTable () {
        service.generateCosts();
        List<Costs> costs = service.findAll();
        costs.forEach(System.out::println);
    }

    public void createCost () {
        Scanner scanner = new Scanner(System.in);

        String date = "";

        System.out.println("\n1. Згенерувати сьогоднінішню дату автоматично? (Так / Ні) ");
        String dateResponse = scanner.nextLine().toLowerCase();

        if (dateResponse.equals("так")) {
            date = new DateFormatGenerator().createCurrentDateFormat();
        } else {
            System.out.println("Введіть дату в форматі dd.mm.yyyy Day. Приклад: 28.06.2023 - Ср");
            date = scanner.nextLine();
        }
        System.out.println(date);

        System.out.println("Введіть назву/опис витрати:");
        String name = scanner.nextLine();

        System.out.println("Введіть витрати (грн):");
        int cost = scanner.nextInt();

        Costs c = service.save(date, name, cost);
        System.out.println(c);
    }
}
