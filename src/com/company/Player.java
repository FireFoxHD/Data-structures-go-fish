package com.company;

import java.util.Random;

public class Player {
    private String name;
    private int numOfBooks;
    private List hand;
    private List bookDeck; //consider making book deck a hand(list)
    private boolean isTurn;

    public Player() {
        name = "";
        numOfBooks = 0;
        hand = new List();
        bookDeck = new List();
    }

    public Player(String name) {
        this.name = name;
        numOfBooks = 0;
        hand = new List();
        bookDeck = new List();
    }

    public boolean isHandEmpty() {
        if (hand.isEmpty()) {
            return false;
        }else
            return true;
    }

    public void addToHand(Card card) {
       hand.insert(card);
    }

    public void removeCard(Card key){
        hand.remove(key);
    }

    //allows the computer to randomly ask for a card of a similar rank in its hand
    public String ask() {
        Random random = new Random();
        int randNum = random.nextInt(hand.count())+1;

        if (hand.isEmpty()) {
            throw new RuntimeException("There are no cards in hand....at all");
        }
        Card temp = hand.getHead();
        int i = 1;
        while (i != randNum) {
            temp = temp.getNext();
            i++;
        }
        System.out.println("Computer: Do you have any "+ temp.getRank());
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

        if (hand.isEmpty()) {
            throw new RuntimeException("Cannot traverse empty list");
        }

        Card temp = hand.getHead();
        Card loop;
        boolean isBook = false;

        if(hand.count() < 2){ // if one card or less in hand
            return false;
        }

        while(temp != null){
            loop = temp.getNext();
            while(loop != null){
                if(loop.getRank().equals(temp.getRank())){
                    bookDeck.insert(loop);
                    bookDeck.insert(temp);
                    System.out.println("Book deck :");
                    bookDeck.showHand();
                    hand.remove(loop); // issue is im removing the iterator for both while loops
                    hand.remove(temp);
                    System.out.println("hand:");
                    hand.showHand();

                    isBook=true;
                }
                loop = loop.getNext();
            }
            temp = temp.getNext();
        }
        return isBook;
    }

    //getters and setters

    public List getHand() {
        return this.hand;
    }

    public List getBookDeck() {
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

    public void setHand(List hand) {
        this.hand = hand;
    }

    public boolean isTurn(){
        return isTurn;
    }
}


