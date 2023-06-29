package view;

import controller.CompanyController;
import controller.EmployerController;
import dao.AbstractDao;
import service.CompanyService;
import service.EmployerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private final CompanyController companyController;
    private final EmployerController employerController;

    private List<String> options = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public View() {
        this.companyController = new CompanyController(new CompanyService(new AbstractDao<>()));
        this.employerController = new EmployerController(new EmployerService(new AbstractDao<>()));
        fillOptions();
    }

    public void run() {
        while (true) {
            printOptions();

            String userOption = scanner.nextLine();
            switch (userOption) {
                case "1" -> employerController.printEmployers();
                case "2" -> companyController.printCompanies();
                case "exit" -> exit();
            }
        }
    }

    public void fillOptions() {
        options.add("1. Отримати всіх працівників");
        options.add("2. Отримати всі компанії");
        options.add("Type 'exit' to leave the app.");
    }

    public void printOptions() {
        options.forEach(System.out::println);
    }

    public void exit() {
        scanner.close();
        System.out.println("App ending finished. Good bye");
        System.exit(1);
    }
}
