package com.company;

public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.push("TEN","HEARTS");
        deck.push("ACE","SPADES");
        System.out.println(deck.toString());
    }
}
