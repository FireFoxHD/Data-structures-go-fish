package com.company;

public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.push("TEN","HEARTS");
        deck.push("ACE","SPADES");


        deck.showDeck();
        System.out.println(deck.pop());
        deck.showDeck();
        System.out.println(deck.pop());
        deck.showDeck();

    }
}
