package com.company;

import java.util.Scanner;

public class GameManager {
    enum Result {HEADS, TAILS};
    enum Turn {PLAYER, COMPUTER};

    public GameManager() {

    }

    public void start() {



    }

    public Result flip() {
        int coin = (int) (Math.random() * 2);

        if (coin == 0) {
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
}