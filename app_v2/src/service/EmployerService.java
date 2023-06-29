package service;

import dao.AbstractDao;
import models.Employer;
import models.Positions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployerService implements Service<Employer>{
    private final AbstractDao<Employer> employerDao;
    private static long EMPLOYER_ID = 1;

    public EmployerService(AbstractDao<Employer> employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public List<Employer> getAll() {
        return employerDao.findAll();
    }

    @Override
    public boolean create(Employer entity) {
        entity.setId(EMPLOYER_ID);
        EMPLOYER_ID++;

        return employerDao.save(entity);
    }

    @Override
    public boolean delete(Employer entity) {
        return employerDao.delete(entity);
    }

    @Override
    public Optional<Employer> getById(long entityId) {
        return getAll().stream()
                .filter(e -> e.getId() == entityId)
                .findFirst();
    }

    @Override
    public Optional<Employer> getByDate(Date date) {
        return getAll().stream()
                .filter(e -> e.getBirth() == date)
                .findFirst();
    }

    @Override
    public Optional<Employer> getByName(String name) {
        return getAll().stream()
                .filter(e -> e.getFullName().equals(name))
                .findFirst();
    }

    public List<Employer> getAllByPosition(Positions position) {
        return getAll().stream()
                .filter(e -> e.getPosition().equals(position))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employer> generateEntities() {
        return new ArrayList<>();
    }
}
