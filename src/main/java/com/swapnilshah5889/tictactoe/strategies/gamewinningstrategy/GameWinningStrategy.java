package com.swapnilshah5889.tictactoe.strategies.gamewinningstrategy;

import com.swapnilshah5889.tictactoe.models.Board;
import com.swapnilshah5889.tictactoe.models.Cell;
import com.swapnilshah5889.tictactoe.models.Player;

public interface GameWinningStrategy {

    boolean checkWinner(Board board,
                        Player player,
                        Cell cell);
}
