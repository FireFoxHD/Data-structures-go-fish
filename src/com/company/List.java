package com.company;

public class List {

    private Card head;
    private int size;

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
        if (this.getHead() == null) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        Card card = new Card();
        return (card == null);
    }

    public void insert(Card card) {
        //insert at back
        if (this.isFull()) {
            throw new RuntimeException("cannot remove from an empty list");
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
        return;
    }

    public Card searchRank(String rank){
        Card temp = getHead();

        if(isEmpty()){
            return null;
        }

        while(temp != null){
            if(temp.getRank().equals(rank)){
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    //TODO check remove --> next = null error
    public void remove(Card key){

        if (this.isEmpty()) {
            throw new RuntimeException("cannot remove from an empty list");
        }

        Card temp = this.getHead();
        this.size--;

        if (temp == key) {
            Card next = temp.getNext();
            setHead(next);
            return;
        }
        while(temp != null){
            if(temp.getNext() == key){
                temp.setNext(temp.getNext().getNext());
                return;
            }
            temp = temp.getNext();
        }
        return;
    }

    public int count() { return this.size; }

    public void showHand(){
        if (isEmpty()) {
            throw new RuntimeException("Cannot traverse empty list");
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
