package lemsolaris.model.employee;

import lemsolaris.model.reports.AnomalyReport;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "employee")
public class Employee {
    private int employeeId;
    private String fullName;
    private String type;
    private String status;
    private int salary;
    private int age;
    private int profession;
    private Collection<AnomalyReport> anomalyReportsByEmployeeId;
    private Profession professionByProfession;
    private Collection<EmployeePhantom> employeePhantomsByEmployeeId;

    @Id
    @Column(name = "employee_id", nullable = false)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "full_name", nullable = false, length = -1)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "salary", nullable = false)
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "age", nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "profession", nullable = false)
    public int getProfession() {
        return profession;
    }

    public void setProfession(int profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee that = (Employee) o;

        if (employeeId != that.employeeId) return false;
        if (salary != that.salary) return false;
        if (age != that.age) return false;
        if (profession != that.profession) return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + salary;
        result = 31 * result + age;
        result = 31 * result + profession;
        return result;
    }

    @OneToMany(mappedBy = "employeeByAuthorId")
    public Collection<AnomalyReport> getAnomalyReportsByEmployeeId() {
        return anomalyReportsByEmployeeId;
    }

    public void setAnomalyReportsByEmployeeId(Collection<AnomalyReport> anomalyReportsByEmployeeId) {
        this.anomalyReportsByEmployeeId = anomalyReportsByEmployeeId;
    }

    @ManyToOne
    @JoinColumn(name = "profession", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Profession getProfessionByProfession() {
        return professionByProfession;
    }

    public void setProfessionByProfession(Profession professionByProfession) {
        this.professionByProfession = professionByProfession;
    }

    @OneToMany(mappedBy = "employeeByHumanHost")
    public Collection<EmployeePhantom> getEmployeePhantomsByEmployeeId() {
        return employeePhantomsByEmployeeId;
    }

    public void setEmployeePhantomsByEmployeeId(Collection<EmployeePhantom> employeePhantomsByEmployeeId) {
        this.employeePhantomsByEmployeeId = employeePhantomsByEmployeeId;
    }
}
