package lemsolaris.model.employee;

import javax.persistence.*;

@Entity
@Table(name = "employee_human")
public class EmployeeHuman {
    private int employeeId;
    private int currentMhi;
    private int baseMhi;
    private int mentalResistance;

    @Id
    @Column(name = "employee_id", nullable = false)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "current_mhi", nullable = false)
    public int getCurrentMhi() {
        return currentMhi;
    }

    public void setCurrentMhi(int currentMhi) {
        this.currentMhi = currentMhi;
    }

    @Basic
    @Column(name = "base_mhi", nullable = false)
    public int getBaseMhi() {
        return baseMhi;
    }

    public void setBaseMhi(int baseMhi) {
        this.baseMhi = baseMhi;
    }

    @Basic
    @Column(name = "mental_resistance", nullable = false)
    public int getMentalResistance() {
        return mentalResistance;
    }

    public void setMentalResistance(int mentalResistance) {
        this.mentalResistance = mentalResistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeHuman that = (EmployeeHuman) o;

        if (employeeId != that.employeeId) return false;
        if (currentMhi != that.currentMhi) return false;
        if (baseMhi != that.baseMhi) return false;
        if (mentalResistance != that.mentalResistance) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + currentMhi;
        result = 31 * result + baseMhi;
        result = 31 * result + mentalResistance;
        return result;
    }
}
