package com.company;

import java.util.Random;
import java.util.Scanner;

public class GameManager{

    private enum Result {HEADS, TAILS}
    private enum Turn {HUMAN, COMPUTER}
    private Deck deck;
    private boolean isPlayerTurn;

    public GameManager(int deckSize, boolean showCards, boolean shuffle){
    	deck = new Deck();
    	deck.initialize(deckSize, showCards);
    	if(shuffle){
            deck.shuffle();
        }
    }
    
    //method for the player to press a button to continue so that they are not overwhelmed with text
    public void pressToContinue()
    {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Press any key to continue");
    	scan.next();
    }

    public void start(){
        isPlayerTurn = (chooseFirstPlayer() == Turn.HUMAN);
    }
    
    //method to simulate the flipping of a coin
    private Result flip(){
        Random random = new Random();
        int coin = random.nextInt(2); // the bound is not inclusive thus it generates only 0 and 1

        if (coin == 0)
        {
        	System.out.println("\nThe coin lands on heads");
            return Result.HEADS;
        }
        
        System.out.println("The coin lands on tails");

        return Result.TAILS; //if coin is not equal pick will return false
    }

    public Turn chooseFirstPlayer() {

        System.out.println("You will now pick between heads or tails as a coin is flipped");
        System.out.print("Enter 0 for heads or 1 for tails: ");
        Scanner scan = new Scanner(System.in);
        int pick = scan.nextInt();

        if (pick != 1 && pick != 0) {
            throw new RuntimeException("You have entered an invalid option");
            //prompt them to re-enter
        }
        Result coinChoice = Result.values()[pick];

        if (coinChoice == flip()){
            System.out.println("Player wins, would you like to go first [y/n]");
            Scanner s = new Scanner(System.in);
            char choice = s.next().toLowerCase().charAt(0);
            if(choice != 'y' && choice != 'n'){
                throw new RuntimeException("You have entered an invalid choice");
            }

            if(choice == 'y'){
                System.out.println("Player Goes First\n");
                return Turn.HUMAN;
            }
        }
        System.out.println("Computer Goes First\n");
        return Turn.COMPUTER;
    }
    
    //method that populates a hand with 4 cards
    public void deal(Player player){
    	for(int i = 0; i < 4; i++ ) 
    	{
    		player.addToHand(deck.pop());
    	}
    }
    
    public boolean isGameDone(Player computer, Player player){
    	boolean gameDone = false;
    	
    	if(deck.count() == 0 && (computer.isHandEmpty() || player.isHandEmpty())){
    		gameDone = true;
    	}
    	return gameDone;
    }

    public Card drawCard(){
        if(deck.isEmpty()){
            System.out.println("Deck is empty!");
            return null;
        }
        return deck.pop();
    }
    
    public void determineWinner(Player computer, Player player) {

        String endState;

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

    public int getDeckSize() {
        return deck.count();
    }
}