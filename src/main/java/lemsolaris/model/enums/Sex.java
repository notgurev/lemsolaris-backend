package lemsolaris.model.enums;

public enum Sex {
        MALE("Man"),WOMAN("Woman");

        private final String text;

        Sex(final String text) {
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
