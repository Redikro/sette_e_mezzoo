package Mazzo;

/**
 * Valore della carta
 */
public enum Valore {
    ASSO(1, "1"),
    DUE(2, "2"),
    TRE(3, "3"),
    QUATTRO(4, "4"),
    CINQUE(5, "5"),
    SEI(6, "6"),
    SETTE(7, "7"),
    FANTE(8, "8"),
    CAVALLO(9, "9"),
    RE(10, "10");

    private final int value;
    private final String label;

    Valore(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return label;
    }
}

