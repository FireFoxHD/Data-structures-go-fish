package com.company;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private String name;
    private List hand;
    private List bookDeck;
    private boolean isTurn;

    public Player() {
        name = "DEFAULT";
        hand = new List();
        bookDeck = new List();
    }

    public Player(String name) {
        this.name = name;
        hand = new List();
        bookDeck = new List();
    }

    public boolean isHandEmpty() {
        return hand.isEmpty();
    }

    public void addToHand(Card card) {
       hand.insert(card);
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
        String[] ranks = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
        boolean isRealCard = false;

    	System.out.println("Please enter a card rank that is in your hand");
        System.out.print("Player: Do you have any ");
        Scanner scan = new Scanner(System.in);
        String rank = scan.next().strip(); //removes trailing and leading whitespace

        //removes "s" at the end of words like King, Queen, Jack and Ace if user added "s"
        if (rank.endsWith("s")){
            rank = rank.substring(0, rank.length() - 1);
        }
        //Capitalizes first letter of word - can be avoided by creating card rank with common letters and capitalize only when displaying
        String normalizedRank = rank.substring(0, 1).toUpperCase() + rank.substring(1);

        for(String cardRank : ranks){
            if(normalizedRank.equals(cardRank) ){
                if(this.getHand().searchRank(normalizedRank) != null){
                    isRealCard = true;
                    break;
                }
            }
        }
        if(isRealCard == false){
            ask();
        }

        return normalizedRank;
    }

    public void showHand() {
        hand.show();
    }

    public void showBookDeck() {
        bookDeck.show();
    }

    public boolean makeBook(){

        if (hand.isEmpty()) return false;

        Card temp = hand.getHead();

        while(temp != null)
        {
            Card nextCard = temp.getNext();
            while(nextCard != null)
            {
                if(nextCard.getRank().equals(temp.getRank()))
                {
                    hand.remove(nextCard);
                    hand.remove(temp);
                    bookDeck.insert(nextCard);
                    bookDeck.insert(temp);
                    System.out.println(getName() + " made a book with: " + nextCard.toString() + " and " + temp.toString());
                    System.out.println();
                    return true;
                }
                nextCard = nextCard.getNext();
            }
            temp = temp.getNext();
        }

        System.out.println();
        return false;
    }

    //getters and setters

    public List getHand() {
        return this.hand;
    }

    public List getBookDeck() {
        return bookDeck;
    }

    public int getNumOfBooks() {
        return bookDeck.count()/2;
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


