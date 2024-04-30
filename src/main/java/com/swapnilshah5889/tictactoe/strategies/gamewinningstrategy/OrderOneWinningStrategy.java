package com.swapnilshah5889.tictactoe.strategies.gamewinningstrategy;

import com.swapnilshah5889.tictactoe.models.Board;
import com.swapnilshah5889.tictactoe.models.Cell;
import com.swapnilshah5889.tictactoe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements  GameWinningStrategy{

    private List<HashMap<Character, Integer>> rowMap;
    private List<HashMap<Character, Integer>> colMap;
    HashMap<Character, Integer> topLeftMap;
    HashMap<Character, Integer> topRightMap;

    public OrderOneWinningStrategy(int dimension) {
        rowMap = new ArrayList<>();
        colMap = new ArrayList<>();
        for(int i=0; i<dimension; i++) {
            rowMap.add(new HashMap<>());
            colMap.add(new HashMap<>());
        }
        topLeftMap = new HashMap<>();
        topRightMap = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Board board, Player player, Cell cell) {

        char symbol = player.getSymbol();
        int row = cell.getRow();
        int col = cell.getCol();
        int dimension = board.getBoard().size();

        // Update row and columns
        rowMap.get(row).put(symbol, rowMap.get(row).getOrDefault(symbol, 0) + 1);
        colMap.get(col).put(symbol, colMap.get(col).getOrDefault(symbol, 0) + 1);

        // Update top left diagonal
        if(row == col) {
            topLeftMap.put(symbol, topLeftMap.getOrDefault(symbol, 0) + 1);
        }
        // Update top right diagonal
        else if(row + col == dimension-1) {
            topRightMap.put(symbol, topRightMap.getOrDefault(symbol, 0) + 1);
        }

        // Check if all cells in current row has same symbol
        if(rowMap.get(row).get(symbol) == dimension) {
            return true;
        }

        // Check if all cells in current column has same symbol
        if(colMap.get(col).get(symbol) == dimension) {
            return true;
        }

        // Check if top left diagonal has same symbols
        if(row == col && topLeftMap.get(symbol) == dimension) {
            return true;
        }
        // Check if top right diagonal has same symbols
        else if(row + col == dimension - 1 && topRightMap.get(symbol) == dimension) {
            return true;
        }

        return false;
    }
}
