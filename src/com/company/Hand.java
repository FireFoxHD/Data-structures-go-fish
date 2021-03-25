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

    public boolean find(Card card) { //accept a value instead of card and return card array
        Card temp = this.getHead();
        while (temp.getNext() != null) {
            if (card == temp) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public void insert(Card card) {
        Card temp = this.getHead();

        if (temp == null) {
            head = card;
        }else{
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(card);
        }
    }

    public Card remove(Card card) {
        Card temp = this.getHead();
        if (this.isEmpty()) {
            throw new RuntimeException("cannot retrieve from an empty list");
        }

        /*
            remove card from anywhere in list
         */
        return temp;
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
       //prints out hand
    }

}
