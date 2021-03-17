package com.company;

public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();

        deck.initialize();
        deck.showDeck();
        System.out.println("---------------------");
        deck.shuffle();
        deck.showDeck();


    }
}
