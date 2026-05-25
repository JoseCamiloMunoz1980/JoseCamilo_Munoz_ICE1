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
        Card[] magicHand = new Card[7];
        Random rand = new Random();

        for (int i = 0; i < magicHand.length; i++) {

            Card c = new Card();

            int randomValue = rand.nextInt(13) + 1;
            String suit = Card.SUITS[rand.nextInt(Card.SUITS.length)];

            c.setValue(randomValue);
            c.setSuit(suit);

            magicHand[i] = c;
        }

        System.out.println("=== Cards ===");

        for (Card card : magicHand) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }

        Scanner k = new Scanner(System.in);

        int userValue = -1;
        boolean validValue = false;

        while (!validValue) {

            System.out.print("Enter card value (1-13): ");

            if (k.hasNextInt()) {
                userValue = k.nextInt();

                if (userValue >= 1 && userValue <= 13) {
                    validValue = true;
                } else {
                    System.out.println("Invalid value.");
                }

            } else {
                k.next();
                System.out.println("Invalid input.");
            }
        }

        k.nextLine();

        String userSuit = "";
        boolean validSuit = false;

        while (!validSuit) {

            System.out.print("Enter suit (1-Hearts, 2-Diamonds, 3-Clubs, 4-Spades OR name): ");
            String input = k.nextLine().trim();

            switch (input.toLowerCase()) {

                case "1":
                case "hearts":
                    userSuit = "Hearts";
                    validSuit = true;
                    break;

                case "2":
                case "diamonds":
                    userSuit = "Diamonds";
                    validSuit = true;
                    break;

                case "3":
                case "clubs":
                    userSuit = "Clubs";
                    validSuit = true;
                    break;

                case "4":
                case "spades":
                    userSuit = "Spades";
                    validSuit = true;
                    break;

                default:
                    System.out.println("Invalid suit.");
            }
        }

        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

        boolean found = false;
        int i = 0;

        while (i < magicHand.length && !found) {

            if (magicHand[i].matches(userCard)) {
                found = true;
            }

            i++;
        }
        
        if (found) {
            System.out.println("Your card IS in the hand.");
        } else {
            System.out.println("Your card is NOT in the hand.");
        }

        int luckyIndex = rand.nextInt(7);
        magicHand[luckyIndex] = new Card(2, "Clubs");

        k.close();
    }
    
}
