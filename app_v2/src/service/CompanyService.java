package service;

import dao.AbstractDao;
import models.Company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CompanyService implements Service<Company>{

    private final AbstractDao<Company> companyDao;

    private static long COMPANY_ID = 1;

    public CompanyService(AbstractDao<Company> companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public List<Company> getAll() {
        return companyDao.findAll();
    }

    @Override
    public boolean create(Company entity) {
        entity.setId(COMPANY_ID);
        COMPANY_ID++;

        return companyDao.save(entity);
    }

    @Override
    public boolean delete(Company entity) {
        return companyDao.delete(entity);
    }

    @Override
    public Optional<Company> getById(long companyId) {
        return getAll().stream()
                .filter(c -> c.getId() == companyId)
                .findFirst();
    }

    @Override
    public Optional<Company> getByDate(Date date) {
        return getAll().stream()
                .filter(c -> c.getFoundationDate().equals(date))
                .findFirst();
    }

    @Override
    public Optional<Company> getByName(String name) {
        return getAll().stream()
                .filter(c -> c.getCompanyName().equals(name))
                .findFirst();
    }

    @Override
    public List<Company> generateEntities() {
        return new ArrayList<>();
    }
}
