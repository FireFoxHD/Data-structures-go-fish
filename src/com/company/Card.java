package com.company;
//a card is a node

public class Card {

    private String rank;
    private String suit;
    int numOfRanks = 13;
    int numOfSuits = 4;
    private Card next;

    public Card(){
        rank = null;
        suit  = null;
        next = null;
    }

    public Card(String rank, String suit){
        this.rank = rank;
        this.suit = suit;
        next = null;
    }

    public Card getNext() {
        return next;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setNext(Card next) {
        this.next = next;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" + rank + " OF " + suit + "}";
    }
}
