package com.swapnilshah5889.tictactoe.controllers;

import com.swapnilshah5889.tictactoe.Exceptions.InvalidGameBuildingException;
import com.swapnilshah5889.tictactoe.models.Game;
import com.swapnilshah5889.tictactoe.models.GameStatus;
import com.swapnilshah5889.tictactoe.models.Player;

import java.util.List;

public class GameController {
    // All functions required to create the game

    public void undo() {

    }

    public Game createGame(int dimensions, List<Player> playerList) throws InvalidGameBuildingException {
        return Game.getBuilder()
                .setPlayers(playerList)
                .setDimension(dimensions)
                .build();
    }

    public void displayBoard(Game game) {
        game.displayBoard();
    }

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }

    public void makeNextMove(Game game) {
        game.makeNextMove();
    }

    public String getWinner(Game game) {
        return game.getWinner().getName() + " ("+game.getWinner().getSymbol()+")";
    }

    public String getCurrentPlayer(Game game) {
        return game.getPlayers().get(game.getNextPlayerIndex()).getName();
    }
}
