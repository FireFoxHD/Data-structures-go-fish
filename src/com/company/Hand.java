package com.company;

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

    public boolean isCardInHand(String rank) {
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

        if (temp == key) {
            head = temp.getNext();
            return;
        }

        while(temp.getNext() != null ){
            if(temp.getNext() == key){
               temp.setNext(temp.getNext().getNext());
               return;
            }
            temp = temp.getNext();
        }
        return;
    }

    public Card getCardByRank(String rank) {
        Card temp = this.getHead();
        if (this.isEmpty()) {
            throw new RuntimeException("cannot remove from an empty list");
        }

        if (temp.getRank() == rank) {
            return temp;
        }

        while(temp.getNext() != null ){
            if(temp.getNext().getRank() == rank){
                return temp.getNext();
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


