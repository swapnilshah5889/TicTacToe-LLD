package com.swapnilshah5889.tictactoe;

import com.swapnilshah5889.tictactoe.Exceptions.InvalidGameBuildingException;
import com.swapnilshah5889.tictactoe.controllers.GameController;
import com.swapnilshah5889.tictactoe.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the dimensions of the board?");
        int dimension = sc.nextInt();

        System.out.println("Do you want a bot in the game? y/n");
        String wantBots = sc.next().trim().toLowerCase();

        List<Player> players = new ArrayList<>();

        int numberOfPlayers = dimension-1;
        if(wantBots.charAt(0) == 'y') {
            numberOfPlayers -= 1;
        }

        // Insert the players
        for(int i=0; i<numberOfPlayers; i++) {
            System.out.println("What is the name of the player?");
            String name = sc.next();
            System.out.println("What is the symbol of the player?");
            String symbol = sc.next();

            players.add(new Player(name, symbol.charAt(0)));

        }

        // Insert the bot
        if(wantBots.charAt(0) == 'y') {
            System.out.println("What is the name of the bot?");
            String name = sc.next();
            System.out.println("What is the symbol of the bot?");
            String symbol = sc.next();

            players.add(new Bot(name, symbol.charAt(0), BotDifficultyLevel.EASY));
        }

        System.out.println(players.size());

        // Start the game
        GameController gameController = new GameController();
        try {
            Game game = gameController.createGame(dimension, players);

            System.out.println(game.getPlayers().size());

            // Keep getting user input until game ends
            while(game.getGameStatus().equals(GameStatus.IN_PROGRESS)) {
                System.out.println("Current Board: ");
                gameController.displayBoard(game);
                System.out.println("Current Turn: "+gameController.getCurrentPlayer(game));
                System.out.println("Do you want to undo? (y/n): ");
                String undo = sc.next().toLowerCase();

                if(undo.charAt(0) == 'y') {
                    gameController.undo();
                }
                else {
                    gameController.makeNextMove(game);
                }
            }

            System.out.println("Game has ended.");
            if(game.getGameStatus().equals(GameStatus.ENDED)) {
                System.out.println("Winner is: "+gameController.getWinner(game));
            }
            else {
                System.out.println("It ended in draw!");
            }

        } catch (InvalidGameBuildingException e) {
            throw new RuntimeException(e);
        }

    }
}