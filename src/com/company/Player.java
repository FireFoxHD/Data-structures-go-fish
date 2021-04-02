package com.company;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private String name;
    private int numOfBooks;
    private List hand;
    private List bookDeck; //consider making book deck a hand(list)
    private boolean isTurn;

    public Player() {
        name = "DEFAULT";
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
    public String askRandom() {
        Random random = new Random();

        if (hand.isEmpty()) {
            throw new RuntimeException("There are no cards in hand....at all");
        }

        int randNum = random.nextInt(hand.count())+1;

        Card temp = hand.getHead();
        int i = 1;
        while (i != randNum) {
            temp = temp.getNext();
            i++;
        }
        System.out.println("Computer: Do you have any "+ temp.getRank());
        return temp.getRank();
    }

    public String ask() {
        System.out.print("Player: Do you have any ");
        Scanner scan = new Scanner(System.in);
        String rank = scan.next();
        return rank;
    }

    public void showHand() {
        hand.show();
    }

    public void showBookDeck() {
        bookDeck.show();
    }

    public boolean hasBook(){
        Card temp = hand.getHead();

        if(hand.isEmpty()) {
            return false;
        }

        while(temp != null){
            Card loop = temp.getNext();
            while(loop != null){
                if(loop.getRank().equals(temp.getRank())){
                    return true;
                }
                temp = temp.getNext();
            }
        }

        return false;
    }

    //TODO: complete this method to make book
    public void makeBook(){

        if (hand.isEmpty()) {
            return;
        }

        Card temp = hand.getHead();

        while(temp != null){
            Card nextCard = temp.getNext();
            while(nextCard != null){
                if(nextCard.getRank().equals(temp.getRank())){
                    hand.remove(nextCard);
                    hand.remove(temp);
                    bookDeck.insert(nextCard);
                    bookDeck.insert(temp);
                    return;
                }
                nextCard = nextCard.getNext();
            }
            temp = temp.getNext();
        }
        return;
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


