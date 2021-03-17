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
            result = result + temp.getRank() + " OF " + temp.getSuit() +"\n";
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
