package lemsolaris.model.assotiationTables.employeeContacts;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EmployeeContactsEntityPK implements Serializable {
    private int employeeId;
    private int contactId;

    @Column(name = "employee_id", nullable = false)
    @Id
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Column(name = "contact_id", nullable = false)
    @Id
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeContactsEntityPK that = (EmployeeContactsEntityPK) o;

        if (employeeId != that.employeeId) return false;
        if (contactId != that.contactId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + contactId;
        return result;
    }
}
