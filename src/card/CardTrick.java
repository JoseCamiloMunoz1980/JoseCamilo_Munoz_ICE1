/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author JoseCamilo Munoz
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7]; //array of objects
        Random rand = new Random();
        
        
        for (int i=0; i<magicHand.length; i++)
        {
            //Card c = new Card();
            //c.setValue(insert call to random number generator here)
            int randomValue = rand.nextInt(13)+1;
            //c.setSuit(Card.SUITS[insert call to random number between 0-3 here])
            String suit = Card.SUITS[rand.nextInt(Card.SUITS.length)];

            magicHand[i] = new Card(randomValue, suit);                        
        }
        System.out.println("=== Magic Hand ===");
        for (Card card : magicHand) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }
        //insert code to ask the user for Card value and suit, create their card
        Scanner k = new Scanner(System.in);
        int userValue;

        while (true) {
            System.out.print("Enter card value (1-13): ");

            if (k.hasNextInt()) {
                userValue = k.nextInt();

                if (userValue >= 1 && userValue <= 13) {
                    break;
                }
            } else {
                k.next(); 
            }

            System.out.println("Invalid value.");
        }

        k.nextLine();

        String userSuit;

        while (true) {
            System.out.print("Enter suit (Hearts, Diamonds, Clubs, Spades): ");
            userSuit = k.nextLine();

            boolean validSuit =
                userSuit.equalsIgnoreCase("Hearts") ||
                userSuit.equalsIgnoreCase("Diamonds") ||
                userSuit.equalsIgnoreCase("Clubs") ||
                userSuit.equalsIgnoreCase("Spades");

            if (validSuit) {
                break;
            }

            System.out.println("Invalid suit.");
        }

        Card userCard = new Card(userValue, userSuit);
        
        // and search magicHand here
        boolean found = false;
        int i = 0;
        while (i < magicHand.length && !found) {

            if (magicHand[i].matches(userCard)) {
                found = true;
            }

            i++;
        }
        k.close();
        //Then report the result here
        // add one luckcard hard code 2,clubs
    }
    
}