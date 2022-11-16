import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck(1);
        deck.shuffle();
        Card card = new Card(11, "♠");
        Card card2 = new Card(2, "♥");
        Player player = new Player("Amalia");
        player.getCardsPlayer(card);
        player.getCardsPlayer(card2);
        System.out.println(player);

        /*boolean gameOver = false;
        while (!gameOver) {
            System.out.println(Player.getPoints());
            gameOver = deck.getContinue();
            if (player.getCardsPlayer(card) >= 21) {
                gameOver = true;
            }
        }*/

    }


}

