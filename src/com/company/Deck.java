package com.company;
//a deck is a stack of cards(linked list)

public class Deck {

    Card top;
    int deckSize = 52;

    public Deck() {
        top = null;
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

    @Override
    public String toString() {
        Card tmp = top;
        String result = "[ \n";
        while(tmp != null){
            result = result + tmp.getRank() + " OF " + tmp.getSuit() +"\n";
            tmp = tmp.getNext();
        }
        result = result + "]";
        return result;
    }
}
