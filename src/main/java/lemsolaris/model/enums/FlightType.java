package lemsolaris.model.enums;

public enum FlightType {

    SIGHTSEEING("Sightseeing"), EXPLORATION("Exploration");

    private final String text;

    FlightType(final String text) {
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
