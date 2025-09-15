package Mazzo;

public enum Seme {
    DENARI, COPPE, SPADE, BASTONI;

    @Override
    public String toString() {
        switch(this) {
            case DENARI:  return "Denari";
            case COPPE:   return "Coppe";
            case SPADE:   return "Spade";
            case BASTONI: return "Bastoni";
            default:      return super.toString();
        }
    }
}

