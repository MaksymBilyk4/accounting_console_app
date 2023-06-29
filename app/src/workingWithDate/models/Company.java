package workingWithDate.models;

import java.util.List;
import java.util.Objects;

public class Company extends BaseEntity {
    private List<Employer> employers;

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
        if (!super.equals(o)) return false;
        Company company = (Company) o;
        return Objects.equals(employers, company.employers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), employers);
    }
}

