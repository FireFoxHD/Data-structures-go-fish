package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        System.out.println("**** Welcome to go fish ****");

        Player player = new Player();
        Player computer = new Player();
        Player currentPlayer;

        GameManager game = new GameManager();
        game.deal(player);
        game.deal(computer);

        game.start();

        System.out.println("Player:");
        player.showHand();
        System.out.println("\nComputer:");
        computer.showHand();

        //TODO : After cards are dealt check for books

        while(!game.isGameDone(player, computer)){
            boolean toggle = game.isPlayerTurn()? true : false;;
            currentPlayer = toggle? player : computer;
            if (currentPlayer == player){
                //human player section - code for when its the players turn

                System.out.print("What card rank do you want to ask for: ");
                Scanner scan = new Scanner(System.in);
                String rank = scan.next();

                if(computer.isCardInHand(rank)){
                    System.out.println("here it is");
                    Card card = computer.getCardByRank(rank);
                    if(card != null){ //redundant since i already checked if card in hand
                        player.addToHand(card);
                        computer.removeCard(card);
                    }
                    System.out.println("Player:");
                    player.showHand();
                    System.out.println("\nComputer:");
                    computer.showHand();
                    continue;
                }else{
                    System.out.println("PLAYER DRAWS");
                    player.addToHand(game.drawCard());
                    System.out.println("Player:");
                    player.showHand();
                    System.out.println("\nComputer:");
                    computer.showHand();
                }
            }else{
                //computer section - code for when its the computers turn

                currentPlayer.ask();
            }


            game.setPlayerTurn(!toggle);
        }

            //first person asks for card
            //if opponent has card
                //remove card from opponent
                //add to askers hand
                //check for book and if book add to book deck
                //person asks again (Continue statement)
            //else
                //asker draws from deck
                //check for book and if book add to book deck
            //toggle player
    }
}
