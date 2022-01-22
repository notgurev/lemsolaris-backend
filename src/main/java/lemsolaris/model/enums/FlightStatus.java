package lemsolaris.model.enums;

public enum FlightStatus {
    PLANNED("Planned"), REQUIRES("Requires changes"), FINISHED("Finished"), ONGOING("Ongoing");

    private final String text;

    FlightStatus(final String text) {
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
