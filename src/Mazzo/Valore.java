package Mazzo;

/**
 * Valore della carta
 */
public enum Valore {
    COPERTA(0,"0",0F),
    ASSO(1, "1",1),
    DUE(2, "2",2),
    TRE(3, "3",3),
    QUATTRO(4, "4",4),
    CINQUE(5, "5",5),
    SEI(6, "6",6),
    SETTE(7, "7",7),
    FANTE(8, "8",0.5F),
    CAVALLO(9, "9",0.5F),
    RE(10, "0.5",0.5F);

    private final int value;
    private final String label;
    private final float realVal;

    Valore(int value, String label, float realVal) {
        this.value = value;
        this.label = label;
        this.realVal = realVal;
    }

    public float getRealVal(){
        return this.realVal;
    }

    @Override
    public String toString() {
        return label;
    }
}

