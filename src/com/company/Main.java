package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("**** Welcome to go fish ****");
        boolean playAgain = true;
        while (playAgain) {
            Player player = new Player("Human");
            Player computer = new Player("Computer"); // name of AI Bob - Built On Bluffing
            GameManager game = new GameManager(26, false, true);

            //Deals players cards
            game.deal(player);
            game.deal(computer);

            //Decides which player is first
            game.start();

            //check if player has a book while player has books add them to book deck
            while (player.makeBook()) ;

            while (computer.makeBook()) ;


            while (!game.isGameDone(player, computer)) {
                System.out.println("======================= START OF TURN =======================\n");

                boolean toggle = game.isPlayerTurn();
                Player currentPlayer = toggle ? player : computer;
                Player opponent = toggle ? computer : player;
                String rank;

                //takes care of situation where player may make books and have no cards
                if (currentPlayer.isHandEmpty()) {
                    System.out.println(currentPlayer.getName() + " ran out of cards.");
                    currentPlayer.addToHand(game.drawCard());
                }

                if (opponent.isHandEmpty()) { //takes care of situation where player may make books and have no cards
                    System.out.println(opponent.getName() + " ran out of cards.");
                    opponent.addToHand(game.drawCard());
                }

                //asking for card
                if (currentPlayer == computer) {
                    rank = currentPlayer.askRandom();
                } else {
                    System.out.println("Current Player: " + currentPlayer.getName() + "\n");
                    System.out.println("Hand");
                    currentPlayer.showHand();
                    System.out.println("\nBookDeck");
                    currentPlayer.showBookDeck();
                    System.out.println();
                    rank = currentPlayer.ask();
                }

                //checks if opponent has card
                Card card = opponent.getHand().searchRank(rank);
                if (card != null) {
                    System.out.println(opponent.getName() + ": I do have your " + rank + "\n");

                    //remove before insert explain why in documentation
                    opponent.getHand().remove(card);
                    currentPlayer.getHand().insert(card);
                    currentPlayer.makeBook();

                } else {
                    System.out.println("\n========================== GO FISH =========================");
                    Card drawnCard = game.drawCard();
                    System.out.println(currentPlayer.getName() + " draws");
                    currentPlayer.addToHand(drawnCard);

                    if(currentPlayer.makeBook()){
                        continue;
                    }
                    game.setPlayerTurn(!toggle);
                }

            }
            System.out.println("\n\n\n");
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|                        Game Over                        |");
            System.out.println("+---------------------------------------------------------+\n");
            game.determineWinner(computer, player);

            System.out.println("\n\n\nWould you like to play again? [y/n]");
            Scanner scan = new Scanner(System.in);
            if(scan.next().toLowerCase().equals("y")){
                playAgain = true;
            }else{
                playAgain = false;
            }
        }
    }
}
