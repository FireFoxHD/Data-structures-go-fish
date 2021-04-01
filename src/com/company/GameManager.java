package com.company;

import java.util.Random;
import java.util.Scanner;

public class GameManager{

    private enum Result {HEADS, TAILS};
    private enum Turn {HUMAN, COMPUTER};
    private Deck deck;
    private boolean isPlayerTurn;

    public GameManager(){
    	deck = new Deck();
    	deck.initialize();
    	deck.shuffle();
    }

    public void start(){
        isPlayerTurn = false;
        if(chooseFirstPlayer() == Turn.HUMAN){
            isPlayerTurn = true;
        }
        System.out.println("");
    }

    private Result flip(){
        Random random = new Random();
        int coin = random.nextInt(2); // the bound is not inclusive thus it generates only 0 and 1

        if (coin == 0){
            return Result.HEADS;
        }

        return Result.TAILS; //if coin is not equal pick will return false
    }

    public Turn chooseFirstPlayer() {

        System.out.println("You will now pick between heads or tails as a coin is flipped");
        System.out.print("Enter 0 for tails or 1 for heads: ");
        Scanner scan = new Scanner(System.in);
        int pick = scan.nextInt();

        if (pick != 1 && pick != 0) {
            throw new RuntimeException("You have entered an invalid option");
        }
        Result coinChoice = Result.values()[pick];

        if (coinChoice == flip()){
            System.out.println(coinChoice);
            System.out.println("You win with "+ coinChoice +" would you like to go first [y/n]");
            Scanner s = new Scanner(System.in);
            char choice = s.next().toLowerCase().charAt(0);
            if(choice != 'y' && choice != 'n'){
                throw new RuntimeException("You have entered an invalid choice");
            }

            if(choice == 'y'){
                return Turn.HUMAN;
            }
        }
        return Turn.COMPUTER;
    }
    
    public void deal(Player player){
    	for(int i = 0; i < 4; i++ ) 
    	{
    		player.addToHand(deck.pop());
    	}
    }
    
    public boolean isGameDone(Player computer, Player player){
    	boolean gameDone = false;
    	
    	if(computer.isHandEmpty() == true && player.isHandEmpty() == true && deck.count() == 0){
    		gameDone = true;
    	}
    	return gameDone;
    }

    public Card drawCard(){
        return deck.pop();
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

    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        isPlayerTurn = playerTurn;
    }
}