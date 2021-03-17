package com.company;
import java.util.Random;

//a deck is a stack of cards(linked list)

public class Deck {

    Card top;
    int deckSize;
    int MAX_DECK_SIZE = 52;
    String[] suits = {"Hearts (♥)", "Spades (♠)", "Diamonds (♦)", "Clubs (♣)"};
    String[] ranks = {"Ace","2","3","4","5","6","7","8","9","10", "Jack","Queen","King"};

    public Deck() {
        top = null;
        deckSize = 0;
    }

    public void initialize(){
        for(int i = 0; i < MAX_DECK_SIZE; i++) {
            this.push(new Card(ranks[i % ranks.length], suits[i / ranks.length]));
        }
    }

    public void shuffle(){
        Card[] cardArr = new Card[deckSize];

        for(int i = 0; i < cardArr.length; i++){ //pops initial unshuffled deck into an array
             cardArr[i] = this.pop();
        }

        for(int i = 0; i < cardArr.length; i++){ //shuffles deck via swapping current index with random index
            Card temp;
            Random random = new Random();
            int randNum = random.nextInt(cardArr.length);

            temp = cardArr[i];
            cardArr[i] = cardArr[randNum];
            cardArr[randNum] = temp;
        }

        for(int i = 0; i < cardArr.length; i++){ //pushes shuffled cards back into array
            this.push(cardArr[i]);
        }
    }

    public void push(Card card){
        card.setNext(top);
        top = card;
        deckSize++;
    }

    public void push(String rank, String suit){
        Card newCard = new Card(rank,suit);
        newCard.setNext(top);
        top = newCard;
        deckSize++;
    }

    public Card peek(){ //shows top card without removing
        Card temp;
        temp = top;
        return temp;
    }

    public Card pop(){
        Card temp;
        temp = top;
        top = temp.getNext();
        deckSize--;
        return temp;
    }

    @Override
    public String toString() {
        Card temp = top;
        String result = "";
        while(temp != null){
            result = result + temp.toString() +"\n";
            temp = temp.getNext();
        }
        return result;
    }

    public void showDeck(){
        if(top == null){
            System.out.println("Deck is empty");
        }
        System.out.println(this.toString());
    }

    public int getDeckSize() {
        return deckSize;
    }
}
