package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        System.out.println("**** Welcome to go fish ****");

        Player player = new Player();
        Player computer = new Player("Bob - Built On Bluffing");
        Player currentPlayer;

        GameManager game = new GameManager();
        game.deal(player);
        game.deal(computer);

        game.start();


        System.out.println("\nPlayer:");
        player.showHand();

        System.out.println("\nComputer:");
        computer.showHand();

        System.out.println("\n\n");

        if(player.makeBook()){
            System.out.println("player made a book");
            player.showHand();
        }

        if(computer.makeBook()){
            System.out.println("computer made a book");
            computer.showHand();
        }

        //TODO : After cards are dealt check for books

        while(!game.isGameDone(player, computer)){
            boolean toggle = game.isPlayerTurn()? true : false;
            currentPlayer = toggle? player : computer;
            if (currentPlayer == player){
                //human player section - code for when its the players turn

                System.out.print("Player: Do you have any ");
                Scanner scan = new Scanner(System.in);
                String rank = scan.next();

                Card card = computer.getHand().searchRank(rank);

                if(card != null){
                    if(rank.equals("Ace")){
                        System.out.println("Computer: I do have an "+ rank + "\n");
                    }else{
                        System.out.println("Computer: I do have a "+ rank + "\n");
                    }

                    player.addToHand(card);
                    player.makeBook();
                    computer.removeCard(card);

                    System.out.println("Player:");
                    player.showHand();
                    System.out.println("\nComputer:");
                    computer.showHand();
                    System.out.println("");

                    continue;
                }else{
                    System.out.println("PLAYER DRAWS");
                    player.addToHand(game.drawCard());
                    player.makeBook();
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
    }
}
