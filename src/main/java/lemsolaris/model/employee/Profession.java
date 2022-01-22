package lemsolaris.model.employee;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "profession")
public class Profession {
    private int id;
    private String name;
    private int minMhi;
    private Collection<Employee> employeesById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "min_mhi", nullable = false)
    public int getMinMhi() {
        return minMhi;
    }

    public void setMinMhi(int minMhi) {
        this.minMhi = minMhi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profession that = (Profession) o;

        if (id != that.id) return false;
        if (minMhi != that.minMhi) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + minMhi;
        return result;
    }

    @OneToMany(mappedBy = "professionByProfession")
    public Collection<Employee> getEmployeesById() {
        return employeesById;
    }

    public void setEmployeesById(Collection<Employee> employeesById) {
        this.employeesById = employeesById;
    }
}
