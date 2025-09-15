package Mazzo;

/**
 * Seme della carta
 */
public enum Seme {
    DENARI, COPPE, SPADE, BASTONI;

    @Override
    public String toString() {
        return switch (this) {
            case DENARI -> "denari";
            case COPPE -> "coppe";
            case SPADE -> "spade";
            case BASTONI -> "bastoni";
        };
    }
}

