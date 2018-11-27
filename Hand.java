
import java.util.*;

public class Hand {

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        BlackjackHand BJ = new BlackjackHand();
        int total = 0;
        int numCards = 0;
        int limit = BJ.randNumber();
        String card;
        String input;

        BJ.Deck();
        BJ.Shuffle();
        
        System.out.println("| - - - - - - - - |");
        System.out.println("|                 |");
        System.out.println("|    BLACKJACK    |");
        System.out.println("|                 |");
        System.out.println("| - - - - - - - - |");

        for (int i = 2; i > 0; i--) {
            card = BJ.addCard(numCards);
            BJ.setHand(card, numCards);
            total += BJ.getCard(BJ.getHand(numCards).charAt(0), total);
            numCards++;
        }
        System.out.println("Your total so far after the first two cards are: " + total);
        for (int i = 0; i <= numCards; i++) {
            if (BJ.getHand(i) != null) {
                System.out.print(BJ.getHand(i) + ", ");
            }
        }
        System.out.println();
        if (total == 21)
        {
            System.out.println("Congrats you got a Blackjack!");
        }
        System.out.println();
        System.out.println("- - - The limit of the game is: " + limit + " - - -");
        do {
            if (total < limit) {
                System.out.print("Draw a card? Type 1 to draw, 2 to not draw: ");
                input = user.nextLine();

                if (input.equals("1")) {
                    card = BJ.addCard(numCards);
                    BJ.setHand(card, numCards);
                    total += BJ.getCard(BJ.getHand(numCards).charAt(0), total);
                    numCards++;
                } else {
                    break;
                }
            } else {
                break;
            }
           
            System.out.println();
            System.out.println("The total value of your hand is: " + total);

        } while (total <= limit);

        for (int i = 0; i <= numCards; i++) {
            if (BJ.getHand(i) != null) {
                System.out.print(BJ.getHand(i) + ", ");
            }
        }
        if (total < limit) 
        {
            System.out.println("You stayed under the limit, congratulations you win!");
        }
        if (total > limit) 
        {
            System.out.println("You went over the limit, you lose.");
        }
        if (total == limit) 
        {
            System.out.println("You hit he limit, congratulations you win!");
        }
        System.out.println("Your total is: " + total);
    }
}
