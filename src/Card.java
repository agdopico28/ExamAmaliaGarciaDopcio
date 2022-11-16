public class Card {
    public static final String[] SUITS = {"♠", "♥", "♦", "♣"};
    private int number;
    private String suit;

    public Card(int number, String suit) {
        this.number = number;
        this.suit = suit;
    }

    @Override
    public String toString() {
        String s = " ";
        if (number <= 10) {
            s += number + " de " + suit;
        } else {
            switch (number) {
                case 11:
                    s += "J" + " de " + suit;
                    break;
                case 12:
                    s += "Q" + " de " + suit;
                    break;
                case 13:
                    s += "K" + " de " + suit;
            }

        }
        return s;
    }

    public String getSuit() {
        return suit;
    }

    public int getNumber() {
        return number;
    }
}
