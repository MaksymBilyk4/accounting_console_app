package models;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Company {

    private long id;

    private Date foundationDate;

    private String companyName;

    private List<Employer> employers;

    public Company(Date foundationDate, String companyName, List<Employer> employers) {
        this.foundationDate = foundationDate;
        this.companyName = companyName;
        this.employers = employers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(Date foundationDate) {
        this.foundationDate = foundationDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(List<Employer> employers) {
        this.employers = employers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id == company.id && Objects.equals(companyName, company.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName);
    }

    @Override
    public String toString() {
        return "Company:\n" +
                "| " + id + " |" +
                "| " + foundationDate + " |" +
                "| " + companyName + " |" +
                "| " + employers + " |";
    }


}

