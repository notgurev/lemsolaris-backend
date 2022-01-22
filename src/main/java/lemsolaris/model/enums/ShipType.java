package lemsolaris.model.enums;

public enum ShipType {
    TOURIST("Tourist"), EXPLORATION("Exploration");

    private final String text;

    ShipType(final String text) {
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
