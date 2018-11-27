/*----------------------------
Name: Matthew Temple
Class: CSC-240
Project: Blackjack
Description: Modified game of Blackjack to test objects and String arrays working with 
each other.
*/
import java.util.*;

public class BlackjackHand extends Hand 
{
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10",
        "Jack", "Queen", "King"};
    String[] deck = new String[52];
    String[] hand = new String[10];
    public Random random = new Random();
    
    void Deck()
    {
        for (int a = 0; a < suits.length; a++)
        {
            for (int b = 0; b < ranks.length; b++)
            {
                switch (a) {
                    case 0:
                        deck[b] = ranks[b] + " of " + suits[a];
                        break;
                    case 1:
                        deck[b + 13] = ranks[b] + " of " + suits[a];
                        break;
                    case 2:
                        deck[b + 26] = ranks[b] + " of " + suits[a];
                        break;
                    case 3:
                        deck[b + 39] = ranks[b] + " of " + suits[a];
                        break;
                    default:
                        break;
                }
            } 
        } 
    }

    void Shuffle()
    {
        for (int i = 0; i < 52; i++)
        {
            int n = (int) (Math.random() * 52);
            String temp;
            temp = deck[i];
            deck[i] = deck[n];
            deck[n] = temp;
        }
    }
    
    int randNumber()
    {
        int num = random.nextInt(22-16) + 16;
        return num;
    }
    
    String addCard(int num)
    {
        return deck[num];
    }
    
    void setHand(String card, int num)
    {
        hand[num] = card;
    }
    
    String getHand(int num)
    {
        return hand[num];  
    } 
    
    public int getCard(char card, int total)
    {

        switch (card) 
        {
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case '1':
                return 10;
            case 'J':
                return 10;
            case 'Q':
                return 10;
            case 'K':
                return 10;
            case 'A':
                if (total >= 10)
                    return 1;
                else
                    return 11;  
            default:
                return 0;
        }
    } 
}
