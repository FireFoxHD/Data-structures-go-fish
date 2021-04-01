package com.company;
import java.util.Random;

//a deck is a stack of cards(linked list)

public class Deck extends Stack{

    Card top;
    int size;
    int MAX_DECK_SIZE = 52;
    String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
    String[] ranks = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};

    public Deck() {
        top = null;
        size = 0;
    }

    public void initialize(){
        for(int i = 0; i < MAX_DECK_SIZE; i++) {
            this.push(new Card(ranks[i % ranks.length], suits[i / ranks.length]));
        }
    }

    public void shuffle(){
        Card[] cardArr = new Card[count()];

        for(int i = 0; i < cardArr.length; i++){ //pops initial un-shuffled deck into an array
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

    public void push(String rank, String suit){
        Card newCard = new Card(rank,suit);
        newCard.setNext(top);
        top = newCard;
        size++;
    }

}
