package lemsolaris.model.assotiationTables.employeeContacts;

import javax.persistence.*;

@Entity
@Table(name = "employee_contacts")
@IdClass(EmployeeContactsEntityPK.class)
public class EmployeeContactsEntity {
    private int employeeId;
    private int contactId;

    @Id
    @Column(name = "employee_id", nullable = false)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Id
    @Column(name = "contact_id", nullable = false)
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

        EmployeeContactsEntity that = (EmployeeContactsEntity) o;

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
