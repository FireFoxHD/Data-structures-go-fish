package com.company;
/*
       methods
-showhand
-isHandEmpty
-Draw*



*/


public class Player {
    private int numOfBooks;
    private int handSize;
    private Hand hand;
    private Card[] bookDeck;

    Player() {
        numOfBooks = 0;
        hand = null;
        bookDeck = null;
    }

    public boolean isHandEmpty() {
        if (hand.isEmpty()) {
            return false;
        }else
            return true;
    }


    public Hand getHand() {
        return this.hand;
    }

    public void addToHand(Card card) {
       this.hand.insert(card);
    }

    public void addToBook(Card[] bd) {
        Card[] bookDeck=bd;
        numOfBooks++;
    }

    public Card[] getBookDeck() {
        return bookDeck;
    }

    public int getNumOfBooks() {
        return bookDeck.length;
    }

    public void ask() {
        System.out.println("Do you have any ");
    }

    public void showHand() {
        hand.showHand();
    }

    public void showBookDeck(){
        System.out.println(bookDeck);
    }

}


