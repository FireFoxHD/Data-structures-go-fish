package com.company;

import java.util.Scanner;
import java.util.Random;


public class Main {
	
	public static boolean isPlayerFirst() 
	{
		boolean isFirst = false;
		
		Scanner s = new Scanner(System.in);
		int pick;
		
		System.out.println("You will now pick between heads or tails as a coin is flipped");
		System.out.println("Enter 0 for tails or 1 for heads");
		pick = s.nextInt();
		
		if(pick != 1 && pick != 0 ) 
		{
			throw new RuntimeException("You have entered an invalid option");
		}
		
		int coin = (int) (Math.random() * 2);
		
		
		if(coin == 0 ) 
		{
			System.out.println("The coin lands on tails");
		}
		else if(coin == 1) 
		{
			System.out.println("The coin lands on heads");
		}
		
		
		if(coin == pick) 
		{
			System.out.println("Player goes first");
			isFirst = true;
		
		}
		else if(coin != pick ) 
		{
			System.out.println("The computer goes first");
			isFirst = false;
		}
		
		
		return isFirst;
		
	}

    public static void main(String[] args) 
    {
    	
        Deck deck = new Deck();

        deck.initialize();
        
        /*
        deck.showDeck();
        System.out.println("---------------------");
        deck.shuffle();
        deck.showDeck();
        */
        
        System.out.println("****Welcome to go fish****");
        
        if(isPlayerFirst() == true) 
        {
        	
        }
        
        
        
    }
}
