package Mazzo;

/**
 * Seme della carta
 */
public enum Seme {
    DENARI, COPPE, SPADE, BASTONI;

    @Override
    public String toString() {
        return switch (this) {
            case DENARI -> "Denari";
            case COPPE -> "Coppe";
            case SPADE -> "Spade";
            case BASTONI -> "Bastoni";
        };
    }
}

