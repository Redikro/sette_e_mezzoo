package Strategy;

public enum Action {
    PESCA,PASSA;

    @Override
    public String toString() {
        return switch (this){
            case PESCA -> "Pesca";
            case PASSA -> "Passa";
        };
    }
}