package com.company;

import java.util.Scanner;

public class GameManager{
	
    private enum Result {HEADS, TAILS};
    private Deck deck;

    public GameManager(){
    	deck = new Deck();
    	deck.initialize();
    	deck.shuffle();
    }

    public Result flip(){
        int coin = (int) (Math.random() * 2);

        if (coin == 0){
            return Result.HEADS;
        }

        return Result.TAILS; //if coin is not equal pick will return false
    }

    public boolean isPlayerFirst(int pick, Result coin) {

        if (pick != 1 && pick != 0) {
            throw new RuntimeException("You have entered an invalid option");
        }

        if (pick == coin.ordinal()){
            System.out.println(coin);
            System.out.println("You win with "+ coin+" would you like to go first [y/n]");
            Scanner s = new Scanner(System.in);
            char choice = s.next().charAt(0);
            if(choice == 'y'){
                return true;
            }else if(choice != 'y' && choice != 'n'){
                throw new RuntimeException("You have entered an invalid choice");
            }
        }
        return false;
    }
    
    public void deal(Player player){
    	for(int i = 0; i < 4; i++ ) 
    	{
    		player.addToHand(deck.pop());
    	}
    }
    
    public boolean isGameDone(Player computer, Player player){
    	boolean gameDone = false;
    	
    	if(computer.isHandEmpty() == true && player.isHandEmpty() == true && deck.getDeckSize() == 0){
    		gameDone = true;
    	}
    	return gameDone;
    }
    
    public void determineWinner(Player computer, Player player) {

        String endState = "";

        System.out.println("Player Score: " + player.getNumOfBooks());
        System.out.println("Computer Score: " + computer.getNumOfBooks());

        if (player.getNumOfBooks() > computer.getNumOfBooks()) {
            endState = "Player Wins";
        } else if (player.getNumOfBooks() < computer.getNumOfBooks()) {
            endState = "Computer Wins";
        } else {
            endState = "The Game Has Ended In a Draw";
        }
        System.out.println(endState);
    }
}