package controller;

import service.CompanyService;

public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    public void printCompanies() {
        companyService.getAll().forEach(System.out::println);
    }
}
