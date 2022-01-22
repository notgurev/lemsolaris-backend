package lemsolaris.model.employee;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "employee_phantom")
public class EmployeePhantom {
    private int employeeId;
    private Integer humanHost;
    private Timestamp lifetime;
    private Employee employeeByHumanHost;

    @Id
    @Column(name = "employee_id", nullable = false)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "human_host", nullable = true)
    public Integer getHumanHost() {
        return humanHost;
    }

    public void setHumanHost(Integer humanHost) {
        this.humanHost = humanHost;
    }

    @Basic
    @Column(name = "lifetime", nullable = false)
    public Timestamp getLifetime() {
        return lifetime;
    }

    public void setLifetime(Timestamp lifetime) {
        this.lifetime = lifetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeePhantom that = (EmployeePhantom) o;

        if (employeeId != that.employeeId) return false;
        if (humanHost != null ? !humanHost.equals(that.humanHost) : that.humanHost != null) return false;
        if (lifetime != null ? !lifetime.equals(that.lifetime) : that.lifetime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + (humanHost != null ? humanHost.hashCode() : 0);
        result = 31 * result + (lifetime != null ? lifetime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "human_host", referencedColumnName = "employee_id", insertable = false, updatable = false)
    public Employee getEmployeeByHumanHost() {
        return employeeByHumanHost;
    }

    public void setEmployeeByHumanHost(Employee employeeByHumanHost) {
        this.employeeByHumanHost = employeeByHumanHost;
    }
}
