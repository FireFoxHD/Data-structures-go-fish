package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("**** Welcome to go fish ****");

//        Card card1 = new Card("4", "Hearts");
//        Card card2 = new Card("5", "Hearts");
//        Card card3 = new Card("6", "Hearts");
//        Card card4 = new Card("7", "Hearts");
//
//        List hand = new List();
//        List deck = new List();
//
//        hand.insert(card1);
//        hand.insert(card2);
//        hand.insert(card3);
//        hand.insert(card4);
//
//        deck.insert(card2);
//
//        hand.show();
//        System.out.println("===");
//        deck.show();
//        System.out.println();



        Player player = new Player("Hoooman");
        Player computer = new Player("Bob - Built On Bluffing");
        Player currentPlayer, opponent;

        GameManager game = new GameManager();
        game.deal(player);
        game.deal(computer);

        if(player.hasBook()){
            player.makeBook();
        }

        if(computer.hasBook()){
            computer.makeBook();
        }

//        player.showHand();
//
//        if(player.hasBook()){
//            System.out.println("==========");
//            player.makeBook();
//            player.getHand().show("main");
//        }else{
//            System.out.println("No book");
//        }

        game.start();

        //TODO : After cards are dealt check for books

        while(!game.isGameDone(player, computer)){
            boolean toggle = game.isPlayerTurn()? true : false;
            currentPlayer = toggle ? player : computer;
            opponent = toggle ? computer : player;
            String rank;

            System.out.println("currentPlayer: " + currentPlayer.getName());
            currentPlayer.showHand();
            System.out.println("");

            System.out.println("Opponent: "+ opponent.getName());
            opponent.showHand();
            System.out.println("");

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


                if(currentPlayer.hasBook()){
                    currentPlayer.makeBook();
                }

            }else{
                //TODO : if card not in opponents hand
                System.out.println("I do not have any "+ rank + "s\n");
                Card drawnCard  = game.drawCard();
                System.out.println(currentPlayer.getName()+ " draws " + drawnCard.toString());
                currentPlayer.addToHand(drawnCard);

                //TODO : check game rules if drawn card makes a book if player then continues turn
                if(currentPlayer.hasBook()){
                    currentPlayer.makeBook();
                }
                game.setPlayerTurn(!toggle);

            }

            //check if game is over else
            continue;


        }
    }
}
