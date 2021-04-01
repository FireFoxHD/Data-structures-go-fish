package com.company;

public class Stack {

    private Card top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public void push(Card card){
        if(isFull()){
            throw new RuntimeException("Cannot push to full stack");
        }
        card.setNext(top);
        top = card;
        size++;
    }

    public Card pop(){
        if(isEmpty()){
            throw new RuntimeException("Cannot pop from empty stack");
        }
        Card temp;
        temp = top;
        top = temp.getNext();
        size--;
        return temp;
    }

    public Card top(){ //shows top card without removing
        Card temp;
        temp = top;
        return temp;
    }

    public boolean isEmpty(){
        if(top == null){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        Card card = new Card();
        return (card == null);
    }

    public void destroy(){
        while(!isEmpty()){
            pop();
        }
    }

    public int count() {
        return size;
    }

}
