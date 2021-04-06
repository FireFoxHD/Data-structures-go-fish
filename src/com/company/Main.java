package com.company;

public class Main {

    public static void main(String[] args){
        System.out.println("**** Welcome to go fish ****");

        Player player = new Player("Human");
        Player computer = new Player("Computer"); // name of Ai Bob - Built On Bluffing
        GameManager game = new GameManager(26, false, true);

        //Deals players cards
        game.deal(player);
        game.deal(computer);

        //Decides which player is first
        game.start();

        //check if player has a book while player has books add them to book deck
        while(player.makeBook());

        while(computer.makeBook());

        while(!game.isGameDone(player, computer)){
            System.out.println("======================= START OF TURN =======================\n");

            boolean toggle = game.isPlayerTurn();
            Player currentPlayer = toggle ? player : computer;
            Player opponent = toggle ? computer : player;
            String rank;

            //takes care of situation where player may make books and have no cards
            if(currentPlayer.isHandEmpty()){
                System.out.println(currentPlayer.getName()+" ran out of cards.");
                currentPlayer.addToHand(game.drawCard());
            }

            if(opponent.isHandEmpty()){ //takes care of situation where player may make books and have no cards
                System.out.println(opponent.getName()+" ran out of cards.");
                opponent.addToHand(game.drawCard());
            }

            //asking for card
            if(currentPlayer == computer){
                rank = currentPlayer.askRandom();
            }else{
                System.out.println("Current Player: " + currentPlayer.getName() +"\n");
                System.out.println("Hand");
                currentPlayer.showHand();
                System.out.println("\nBookDeck");
                currentPlayer.showBookDeck();
                System.out.println();
                rank = currentPlayer.ask();
            }

            //checks if opponent has card
            Card card = opponent.getHand().searchRank(rank);
            if(card != null) {
                System.out.println(opponent.getName()+": I do have your "+ rank + "\n");

                //remove before insert explain why in documentation
                opponent.getHand().remove(card);
                currentPlayer.getHand().insert(card);

                currentPlayer.makeBook();

            }else{
                System.out.println("========================== GO FISH =========================");
                System.out.println(opponent.getName()+": I do not have any " + rank + "s\n");
                Card drawnCard  = game.drawCard();
                System.out.println(currentPlayer.getName()+ " draws");
                currentPlayer.addToHand(drawnCard);

                //TODO : check game rules if drawn card makes a book if player then continues turn
                currentPlayer.makeBook();
                System.out.println("======================= END OF TURN =======================\n");
                game.setPlayerTurn(!toggle);

            }

            //check if game is over else
        }
        System.out.println("\n\n\n");
        System.out.println("+---------------------------------------------------------+");
        System.out.println("|                        Game Over                        |");
        System.out.println("+---------------------------------------------------------+\n");

        if(player.getNumOfBooks() < computer.getNumOfBooks()) {
            System.out.println("Computer wins with " + computer.getNumOfBooks()/2 + " books!");
        }else{
            System.out.println("Player wins with " + player.getNumOfBooks()/2 + " books!");
        }

    }
}
