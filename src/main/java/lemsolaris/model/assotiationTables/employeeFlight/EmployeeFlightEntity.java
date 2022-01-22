package lemsolaris.model.assotiationTables.employeeFlight;

import javax.persistence.*;

@Entity
@Table(name = "employee_flight")
@IdClass(EmployeeFlightEntityPK.class)
public class EmployeeFlightEntity {
    private int employeeId;
    private int flightId;

    @Id
    @Column(name = "employee_id", nullable = false)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Id
    @Column(name = "flight_id", nullable = false)
    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeFlightEntity that = (EmployeeFlightEntity) o;

        if (employeeId != that.employeeId) return false;
        if (flightId != that.flightId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + flightId;
        return result;
    }
}
