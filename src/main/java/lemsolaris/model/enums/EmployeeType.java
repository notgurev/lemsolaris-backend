package lemsolaris.model.enums;

public enum EmployeeType {

    HUMAN("Human"), PHANTOM("Phantom");

    private final String text;

    EmployeeType(final String text) {
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
