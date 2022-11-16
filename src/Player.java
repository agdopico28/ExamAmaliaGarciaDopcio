public class Player {
    private String name;
    private Card[] cardsHand;
    private int numRegisteredCards;
    private int point;

    public Player(String name) {
        this.name = name;
        cardsHand = new Card[20];
        numRegisteredCards = 0;
        for (int i = 0; i < cardsHand.length; i++) {
            cardsHand[i] = null;
        }
    }

    public void getCardsPlayer(Card card) {
        cardsHand[numRegisteredCards] = card;
        numRegisteredCards++;

    }

    @Override
    public String toString() {
        String s = " ";
        for (int card = 0; card < cardsHand.length; card++) {
            Boolean first = true;
            if (first) {
                first = false;
            } else {
                s += ", ";
            }
            if (cardsHand[card] != null) {
                s += cardsHand[card];
            }
        }
        return name + ": " + s;
    }

    public int getPoints() {
        int totalpoints = 0;
        point = 0;
        for (int card = 0; card < cardsHand.length; card++) {
            if (cardsHand[card] != null) {
                if (cardsHand[card].getNumber() >= 2 || cardsHand[card].getNumber() <= 10) {
                    point = cardsHand[card].getNumber();
                    totalpoints = point;
                } else {
                    switch (cardsHand[card].getNumber()) {
                        case 11:
                        case 12:
                        case 13:
                            point += 10;
                            break;
                        case 1:
                            if (totalpoints <= 21) {
                                point += 11;
                            } else {
                                point += 1;
                            }
                    }
                }


            }
        }
        return totalpoints;
    }
}
