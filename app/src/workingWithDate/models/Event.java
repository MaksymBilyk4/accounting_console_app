package workingWithDate.models;

import java.util.List;
import java.util.Objects;

public class Event extends BaseEntity {
    private List<Employer> members;
    private Company company;

    public List<Employer> getMembers() {
        return members;
    }

    public void setMembers(List<Employer> members) {
        this.members = members;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Event event = (Event) o;
        return Objects.equals(members, event.members) && Objects.equals(company, event.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), members, company);
    }
}
