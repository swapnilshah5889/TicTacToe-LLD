package com.swapnilshah5889.tictactoe;

import com.swapnilshah5889.tictactoe.models.Bot;
import com.swapnilshah5889.tictactoe.models.BotDifficultyLevel;
import com.swapnilshah5889.tictactoe.models.Player;
import com.swapnilshah5889.tictactoe.models.PlayerType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the dimensions of the board?");
        int dimension = sc.nextInt();

        System.out.println("Do you want a bot in the game? y/n");
        String wantBots = sc.nextLine().trim().toLowerCase();

        List<Player> players = new ArrayList<>();

        int numberOfPlayers = dimension-1;
        if(wantBots.charAt(0) == 'y') {
            numberOfPlayers -= 1;
        }

        // Insert the players
        for(int i=0; i<numberOfPlayers; i++) {
            System.out.println("What is the name of the player?");
            String name = sc.nextLine();
            System.out.println("What is the symbol of the player?");
            String symbol = sc.nextLine();

            players.add(new Player(name, symbol.charAt(0)));

        }

        // Insert the bot
        if(wantBots.charAt(0) == 'y') {
            System.out.println("What is the name of the bot?");
            String name = sc.nextLine();
            System.out.println("What is the symbol of the bot?");
            String symbol = sc.nextLine();

            players.add(new Bot(name, symbol.charAt(0), BotDifficultyLevel.EASY));
        }
    }
}