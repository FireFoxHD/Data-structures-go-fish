package com.company;
import java.util.Random;
//a deck is a stack of cards(linked list)

public class Deck {

    Card top;
    int deckSize = 52;
    String[] suits = {"Hearts (♥)", "Spades (♠)", "Diamonds (♦)", "Clubs (♣)"};
    String[] ranks = {"Ace","2","3","4","5","6","7","8","9","10", "Jack","Queen","King"};

    public Deck() {
        top = null;
    }

    public void initialize(){
        Card[] temp = new Card[deckSize];
        int tempSize=0;
        for(int i = 0; i < ranks.length; i++){
            for(int j = 0; j < suits.length; j++){
                temp[tempSize] = new Card(ranks[i], suits[j]);
                tempSize++;
            }
        }
        shuffle(temp);
    }

    private void shuffle(Card[] cardArr){
        Random random = new Random();
        Card temp;
        int randNum;

        for(int i = 0; i < cardArr.length; i++){
            randNum = random.nextInt(deckSize);
            temp = cardArr[i];
            cardArr[i] = cardArr[randNum];
            cardArr[randNum] = temp;
        }

        for(int i = 0; i < cardArr.length; i++){
            push(cardArr[i]);
        }
    }

    public void push(Card card){
        card.setNext(top);
        top = card;
    }

    public void push(String rank, String suit){
        Card newCard = new Card(rank,suit);
        newCard.setNext(top);
        top = newCard;
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
}
