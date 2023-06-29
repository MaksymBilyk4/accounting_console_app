package models;

import java.util.Date;
import java.util.Objects;

public class Employer {
    private long id;

    private Date birth;

    private String fullName;

    private Company company;

    private Positions position;

    private long salary;

    public Employer(Date birth, String fullName, Company company, Positions position, long salary) {
        this.birth = birth;
        this.fullName = fullName;
        this.company = company;
        this.position = position;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employer employer = (Employer) o;
        return id == employer.id && Objects.equals(fullName, employer.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName);
    }

    @Override
    public String toString() {
        return "Employer:\n" +
                "| " + id + " |" +
                "| " + birth + " |" +
                "| " + fullName + " |" +
                "| " + company.getCompanyName() + " |" +
                "| " + position + " |" +
                "| " + salary + " |";
    }
}
