package lemsolaris.model.enums;

public enum AnomalyType {

    STRUCTURAL("Structural"), NONSTRUCTURAL("Non-structural");

    private final String text;

    AnomalyType(final String text) {
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
