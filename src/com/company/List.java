package com.company;

public class List {

    protected Card head;
    protected int size;

    List(){
        size = 0;
        head = null;
    }

    public Card getHead() {
        return this.head;
    }

    public void setHead(Card head) {
        this.head = head;
    }

    public boolean isEmpty() {
        return this.getHead() == null;
    }

    public boolean isFull() {
        Card card = new Card();
        return card == null;
    }

    public void insert(Card card) {
        //insert at back
        if (this.isFull()) {
            throw new RuntimeException("cannot insert to a full list");
        }

        Card temp = this.getHead();
        card.setNext(null); //clears the next node for each class that was set by the deck initialization
        this.size++;
        if (temp == null) {
            head = card;
            return;
        }

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(card);
    }

    public Card searchRank(String rank) {
        Card temp = getHead();

        if(isEmpty()){
            throw new RuntimeException("Cannot search an empty list");
        }

        while(temp != null){
            if(temp.getRank().equals(rank)){
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    public void remove(Card key){

        if (this.isEmpty()) {
            throw new RuntimeException("Cannot remove from an empty list");
        }

        Card temp = this.getHead();
        this.size--;

        if (temp == key) {
            head = head.getNext();
            key.setNext(null);//removes the next value from it making it an singular node and not a list segment
            return;
        }

        while(temp != null){
            if(temp.getNext() == key) {
                temp.setNext(temp.getNext().getNext());
                key.setNext(null);
                return;
            }
            temp = temp.getNext();
        }
    }

    public int count() { return this.size; }

    public void show() {
        if (isEmpty()) {
            System.out.println("[Empty!]");
            return;
        }

        Card temp = this.getHead();
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
