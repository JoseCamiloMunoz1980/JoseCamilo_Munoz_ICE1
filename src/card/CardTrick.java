/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author JoseCamilo Munoz
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        Random rand = new Random();

        for (int i = 0; i < magicHand.length; i++) {

            int randomValue = rand.nextInt(13) + 1;
            String suit = Card.SUITS[rand.nextInt(Card.SUITS.length)];

            magicHand[i] = new Card(randomValue, suit);
        }

        Card luckyCard = new Card(2, "Clubs");

        System.out.println("=== Cards ===");

        for (Card card : magicHand) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }

        System.out.println("\n=== Lucky Card ===");
        System.out.println(luckyCard.getValue() + " of " + luckyCard.getSuit());

        boolean found = false;
        int i = 0;

        while (i < magicHand.length && !found) {

            if (magicHand[i].matches(luckyCard)) {
                found = true;
            }

            i++;
        }

        if (found) {
            System.out.println("\nYOU WIN! Lucky card is in the hand.");
        } else {
            System.out.println("\nYOU LOSE! Lucky card is not in the hand.");
        }
    }
    
}
