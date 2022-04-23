package pl.zsl.tictactoe;

public class Player {
    public String name;
    public char symbol;
    public int drawable;

    public Player(String name, char symbol, int drawable) {
        this.name = name;
        this.symbol = symbol;
        this.drawable = drawable;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
}
