import java.util.Scanner;

public class Deck {
    public static final int NUM_CARDS = 52;
    private Card[] deck;
    private int numDeck;
    private int numCards;

    public Deck(int numDeck) {
        numCards = 52;
        this.numDeck = numDeck;
        deck = new Card[numCards * numDeck];
        int i = 0;
        for (int d = 1; d <= numDeck; d++) {
            for (int suit = 0; suit < Card.SUITS.length; suit++) {
                for (int number = 1; number <= 13; number++) {
                    deck[i] = new Card(number, Card.SUITS[suit]);
                    i++;
                }
            }
        }

    }

    public void shuffle() {
        for (int k = 0; k < 1000; k++) {
            int i = (int) (Math.random() * numCards); //
            int j = (int) (Math.random() * numCards);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    public Card getCard() {
        numCards--;
        return deck[numCards];
    }

    @Override
    public String toString() {
        String s = "";
        for (int suit = 0; suit < Card.SUITS.length; suit++) {
            Boolean first = true;
            for (int i = 0; i < numCards * numDeck; i++) {
                if (deck[i].getSuit().equals(Card.SUITS[suit])) {
                    if (first) {
                        first = false;
                    } else {
                        s += ", ";
                    }
                    s += deck[i];
                }
            }
            s += "\n";
        }
        return s;
    }

    public boolean getContinue() {
        System.out.println("Want new card?\nYES (Y)\nNO (N)");
        boolean respuestaValida = false;
        boolean answer = false;
        char response;
        while (!respuestaValida) {
            Scanner input = new Scanner(System.in);
            response = input.next().toUpperCase().charAt(0);
            if (response != 'Y' && response != 'N') {
                System.out.println("No corresponde a ninguna de las anteriores, vuelve a intentarlo");
                continue;
            }
            respuestaValida = true;
            if (response == 'Y') {
                getCard();
            } else { // si no
                answer = true;
            }
        }
        return answer;
    }
}
