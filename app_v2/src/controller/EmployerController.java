package controller;

import service.EmployerService;

public class EmployerController {

    private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    public void printEmployers() {
        employerService.getAll().forEach(System.out::println);
    }
}
