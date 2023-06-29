package workingWithDate.models;

import java.util.Objects;

public class Employer extends BaseEntity{
    private Company company;
    private Positions position;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employer employer = (Employer) o;
        return Objects.equals(company, employer.company) && position == employer.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), company, position);
    }
}
