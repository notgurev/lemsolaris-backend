package lemsolaris.model.enums;

public enum PaymentType {

    SEVERANCE("Severance"), SALARY("Salary");

    private final String text;

    PaymentType(final String text) {
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
