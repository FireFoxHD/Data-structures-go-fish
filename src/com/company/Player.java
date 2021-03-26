package com.company;
/*
       methods
-showhand
-isHandEmpty
-Draw*



*/


public class Player {
    private String name;
    private int numOfBooks;
    private Hand hand;
    private Card[] bookDeck; //consider making book deck a hand(list)

    public Player() {
        name = "";
        numOfBooks = 0;
        hand = new Hand();
        bookDeck = null;
    }

    public Player(String name) {
        this.name = name;
        numOfBooks = 0;
        hand = new Hand();
        bookDeck = null;
    }

    public boolean isHandEmpty() {
        if (hand.isEmpty()) {
            return false;
        }else
            return true;
    }

    public boolean isCardInHand(String rank){
        return hand.isCardInHand(rank);
    }

    public void addToHand(Card card) {
       hand.insert(card);
    }

    public void removeCard(Card key){
        hand.remove(key);
    }

    public void addToBook(Card[] bd) {
        Card[] bookDeck=bd;
        numOfBooks++;
    } //check

    public void ask() {
        System.out.println("Do you have any ");
    }

    public void showHand() {
        hand.showHand();
    }

    //getters and setters

    public Hand getHand() {
        return this.hand;
    }

    public Card[] getBookDeck() {
        return bookDeck;
    }

    public int getNumOfBooks() {
        return bookDeck.length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}


