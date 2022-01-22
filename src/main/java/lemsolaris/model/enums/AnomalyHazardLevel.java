package lemsolaris.model.enums;

public enum AnomalyHazardLevel {

    DANGEROUS("Dangerous"), NON_DANGEROUS("Non-dangerous");

    private final String text;

    AnomalyHazardLevel(final String text) {
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
