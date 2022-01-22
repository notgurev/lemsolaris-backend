package lemsolaris.model.enums;

public enum AnomalyStatus {

    EXPLORED("Explored"), UNEXPLORED("Unexplored"), DISAPPEARED("Disappeared");

    private final String text;

    AnomalyStatus(final String text) {
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
