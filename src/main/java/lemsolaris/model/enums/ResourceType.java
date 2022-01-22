package lemsolaris.model.enums;

public enum ResourceType {

    MONEY("Money"), FUEL("Fuel"), MEDKIT("Medkit"), FOOD("Food");

    private final String text;

    ResourceType(final String text) {
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
