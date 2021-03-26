package com.company;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Random;


public class Main {


    public static void main(String[] args) {
//        System.out.println("****Welcome to go fish****");
//
//        GameManager game = new GameManager();
//
//        System.out.println("You will now pick between heads or tails as a coin is flipped");
//        System.out.println("Enter 0 for tails or 1 for heads");
//        Scanner s = new Scanner(System.in);
//
//        if(game.isPlayerFirst(s.nextInt(), game.flip())){
//            System.out.println("Player First");
//        }else{
//            System.out.println("Computer First");
//        }

        Player player = new Player();
        Hand hand = new Hand();

        Card cardK1 = new Card("King", "Clubs");
        Card cardK2 = new Card("King", "Hearts");
        Card cardK3 = new Card("King", "Spades");
        Card cardK4 = new Card("King", "Diamonds");

        Card cardQ1 = new Card("Queen", "Clubs");
        Card cardQ2 = new Card("Queen", "Hearts");
        Card cardQ3 = new Card("Queen", "Spades");
        Card cardQ4 = new Card("Queen", "Diamonds");



        hand.insert(cardQ1);
        hand.insert(cardQ2);
        hand.insert(cardQ3);
        hand.insert(cardQ4);
        hand.insert(cardK1);
        hand.insert(cardK2);
        hand.insert(cardK3);
        hand.insert(cardK4);

    }
}
