package com.company;

import java.util.Random;

public class Player {
    private String name;
    private int numOfBooks;
    private Hand hand;
    private Hand bookDeck; //consider making book deck a hand(list)
    private boolean isTurn;

    public Player() {
        name = "";
        numOfBooks = 0;
        hand = new Hand();
        bookDeck = new Hand();
    }

    public Player(String name) {
        this.name = name;
        numOfBooks = 0;
        hand = new Hand();
        bookDeck = new Hand();
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

    public Card getCardByRank(String rank){
        return hand.getCardByRank(rank);
    }


    //allows the computer to randomly ask for a card of a similar rank in its hand
    public String ask() {
        Random random = new Random();
        int randNum = random.nextInt(hand.count())+1;
        System.out.println("num: "+ randNum);
        if (hand.isEmpty()) {
            throw new RuntimeException("There are no cards in hand....at all");
        }
        Card temp = hand.getHead();
        int i = 1;
        while (i != randNum) {
            temp = temp.getNext();
            i++;
        }
        System.out.println("Do you have any "+ temp.getRank());
        return temp.getRank();
    }

    public void showHand() {
        hand.showHand();
    }

    public void showBookDeck() {
        bookDeck.showHand();
    }

    //TODO: complete this method to make book
    public boolean makeBook(){

        Card temp = hand.getHead();
        Card loop;
        boolean isBook = false;

        if (hand.isEmpty()) {
            throw new RuntimeException("Cannot traverse empty list");
        }
        while(temp != null){
            System.out.println("-----Searching for: "+ temp.getRank());
            loop = temp.getNext();
            while(loop != null){
                System.out.println("Current card: "+ loop.getRank());
                if(loop.getRank().equals(temp.getRank())){
//                    bookDeck.insert(loop);
//                    bookDeck.insert(temp);
                    hand.remove(loop);
                    hand.remove(temp);
                    isBook=true;
                }
                loop = loop.getNext();
            }

            temp = temp.getNext();
            System.out.println("====");
            showHand();
        }
        return isBook;
    }

    //getters and setters

    public Hand getHand() {
        return this.hand;
    }

    public Hand getBookDeck() {
        return bookDeck;
    }

    public int getNumOfBooks() {
        return bookDeck.count();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public boolean isTurn(){
        return isTurn;
    }
}


