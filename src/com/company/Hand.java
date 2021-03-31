package com.company;

import javax.sound.midi.Soundbank;

public class Hand { //linked list of card nodes
    private Card head;

    Hand(){
        head = null;
    }

    public boolean isEmpty() {
        if (this.getHead() == null) {
            return true;
        }
        return false;
    }

    public Card getHead() {
        return this.head;
    }

    public void setHead(Card head) {
        this.head = head;
    }

    /*
    public Hand getCardsByRank(String rank) { //accept a value instead of card and return card array
        Hand cards = new Hand();
        Card temp = this.getHead();

        System.out.println();
        if (isEmpty()) {
            throw new RuntimeException("Cannot getCardsByRank of an empty list");
        }

        while (temp != null) {

            System.out.println("Current Address: " + temp.hashCode());
            System.out.println("Next Address: " + temp.getNext().hashCode());
            if (temp.getRank() == rank) {
                System.out.println("------------inside if");
                cards.insert(temp);
                cards.showHand();
                System.out.println("------------end if");
            }

            temp = temp.getNext();
            if(temp==null){
                System.out.println("Address: null");
            }

        }

        System.out.println("return");
        return cards;
    }

     */

    public boolean isRankInHand(String rank) {
        Card temp = this.getHead();
        if (isEmpty()) {
            throw new RuntimeException("There are no cards in hand....at all");
        }

        while (temp != null) {
            String listRank = temp.getRank();
            if (listRank.equals(rank)) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public boolean isCardInHand(Card card) {
        Card temp = this.getHead();
        if (isEmpty()) {
            throw new RuntimeException("There are no cards in hand....at all");
        }

        while (temp != null) {
            if (temp == card) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public void insert(Card card) {
        Card temp = this.getHead();
        card.setNext(null); //clears the next node for each class that was set by the deck initialization

        if (temp == null) {
            head = card;
            return;
        }

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(card);
        return;
    }

    public void remove(Card key) {
        Card temp = this.getHead();

        if (this.isEmpty()) {
            throw new RuntimeException("cannot remove from an empty list");
        }

        if (!this.isCardInHand(key)) {
            throw new RuntimeException("Card not in hand");
        }


//        if (temp == key) {
//            head = temp.getNext();
//            return;
//        }

        while(temp != null ){
            Card next = temp.getNext();
            Card nextNext = temp.getNext().getNext();

            System.out.println("Current: "+temp.toString());
            System.out.println("Next: "+next.toString());
            System.out.println("Next next:"+nextNext.toString());

            if(temp == key){
                System.out.println("NEXT SET!!!!");
                temp.setNext(nextNext);
                return;
            }
            temp = next;
        }
        return;
    }

    public Card getCardByRank(String rank) {
        Card temp = this.getHead();
        if (this.isEmpty() || temp == null) {
            throw new RuntimeException("cannot remove from an empty list");
        }

//        if (temp.getRank() == rank) {
//            return temp;
//        }

        while(temp != null){
            if(temp.getRank().equals(rank)){
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    public int count(){
        int size = 0;
        Card temp = this.getHead();
        while (temp != null) {
            size++;
            temp = temp.getNext();
        }
        return size;
    }

    public void showHand(){
        Card temp = this.getHead();
        if (isEmpty()) {
            throw new RuntimeException("Cannot traverse empty list");
        }

        while (temp!= null) {
            System.out.println(temp.toString());
            temp = temp.getNext();
        }
    }

    @Override
    public String toString() {
        Card temp = this.getHead();
        String result = "";
        while (temp!= null) {
            result = temp.toString() + "\n";
            temp = temp.getNext();
        }
        return result;
    }
}


