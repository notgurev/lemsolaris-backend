package lemsolaris.model.assotiationTables.employeeFlight;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EmployeeFlightEntityPK implements Serializable {
    private int employeeId;
    private int flightId;

    @Column(name = "employee_id", nullable = false)
    @Id
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Column(name = "flight_id", nullable = false)
    @Id
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

        EmployeeFlightEntityPK that = (EmployeeFlightEntityPK) o;

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
