package com.company;

public class Main {

    public static void main(String[] args){
        System.out.println("**** Welcome to go fish ****");

        Player player = new Player("Hoooman");
        Player computer = new Player("Bob - Built On Bluffing");
        GameManager game = new GameManager();

        //Deals players cards
        game.deal(player);
        game.deal(computer);

        //Decides which player is first
        game.start();

        //check if player has a book while player has books add them to book deck
        while(player.makeBook());
        if(player.isHandEmpty()){ //takes care of situation where player may start with two books
            player.addToHand(game.drawCard());
        }

        while(computer.makeBook());
        if(computer.isHandEmpty()){
            computer.addToHand(game.drawCard());
        }

        while(!game.isGameDone(player, computer)){

            boolean toggle = game.isPlayerTurn();
            Player currentPlayer = toggle ? player : computer;
            Player opponent = toggle ? computer : player;
            String rank;


            System.out.println("Current Player: " + currentPlayer.getName() +"\n");
            System.out.println("Hand");
            currentPlayer.showHand();
            System.out.println("\nBookDeck");
            currentPlayer.showBookDeck();
            System.out.println();

//            System.out.println("Opponent: "+ opponent.getName() +"\n");
//            System.out.println("Hand");
//            opponent.showHand();
//            System.out.println("\nBookDeck");
//            opponent.showBookDeck();
//            System.out.println();
            
            game.pressToContinue();

            //asking for card
            if(currentPlayer == computer){
                rank = currentPlayer.askRandom();
            }else{
                rank = currentPlayer.ask();
            }

            //checks if opponent has card
            Card card = opponent.getHand().searchRank(rank);
            if(card != null) {
                System.out.println("I do have your "+ rank + "\n");

                //remove before insert explain why in documentation
                opponent.getHand().remove(card);
                currentPlayer.getHand().insert(card);

                currentPlayer.makeBook();

            }else{
                //TODO : if card not in opponents hand
                System.out.println("I do not have any " + rank + "s\n");
                Card drawnCard  = game.drawCard();
                System.out.println(currentPlayer.getName()+ " draws");
                currentPlayer.addToHand(drawnCard);

                //TODO : check game rules if drawn card makes a book if player then continues turn
                currentPlayer.makeBook();

                game.setPlayerTurn(!toggle);

            }

            //check if game is over else



        }
    }
}
