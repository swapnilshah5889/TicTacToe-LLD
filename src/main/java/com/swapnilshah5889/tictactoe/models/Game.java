package com.swapnilshah5889.tictactoe.models;

import com.swapnilshah5889.tictactoe.Exceptions.InvalidGameBuildingException;
import com.swapnilshah5889.tictactoe.strategies.gamewinningstrategy.GameWinningStrategy;
import com.swapnilshah5889.tictactoe.strategies.gamewinningstrategy.OrderOneWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private int nextPlayerIndex;
    private GameWinningStrategy gameWinningStrategy;
    private Player winner;

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameWinningStrategy getGameWinningStrategy() {
        return gameWinningStrategy;
    }

    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }

    // Private constructor for builder design pattern
    private Game() {}

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public void displayBoard() {
        for(List<Cell> cellList : board.getBoard()) {
            for(Cell c : cellList) {
                if(c.getCellState() == CellState.EMPTY) {
                    System.out.print("|   |");
                }
                else {
                    System.out.print("| "+c.getPlayer().getSymbol()+" |");
                }
            }
            System.out.println();
        }
    }

    public void makeNextMove() {
        // Player to move next
        Player player = players.get(nextPlayerIndex);

        // Move that the player wants to make
        Move move = player.decideMove(board);

        // Game must validate if the move is possible -> TODO

        // Assign the this player to the cell in the board
        board.getBoard().get(move.getCell().getRow())
                .get(move.getCell().getCol())
                .setPlayer(player);
        board.getBoard().get(move.getCell().getRow())
                .get(move.getCell().getCol())
                .setCellState(CellState.FILLED);

        // Check if the player won
        if(gameWinningStrategy.checkWinner(board, player, move.getCell())) {
           gameStatus = GameStatus.ENDED;
            winner = player;
            return;
        }

        // Cyclic increment of next player
        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();

        // Check if the player wins - Winning strategy -> TODO
    }

    public static class Builder {
        private int dimension;
        private List<Player> players;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        private boolean isValid() {
            if(dimension < 1) {
                return false;
            }

            return true;
        }

        public Game build() throws InvalidGameBuildingException {
            if(!isValid()) {
                throw new InvalidGameBuildingException("Something went wrong!");
            }

            Game game = new Game();
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setBoard(new Board(dimension));
            game.setPlayers(players);
            game.setMoves(new ArrayList<>());
            game.setNextPlayerIndex(0);
            game.setGameWinningStrategy(new OrderOneWinningStrategy(dimension));
            return game;
        }
    }
}
