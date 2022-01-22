package lemsolaris.model.enums;

public enum EmployeeStatus {

    NOT_HIRED("Not hired"), HIRED("Hired"), FIRED("Fired"), DEAD("Dead");

    private final String text;

    EmployeeStatus(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
