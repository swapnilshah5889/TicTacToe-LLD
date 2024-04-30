package com.swapnilshah5889.tictactoe.strategies.botplayingstrategy;

import com.swapnilshah5889.tictactoe.models.Board;
import com.swapnilshah5889.tictactoe.models.Bot;
import com.swapnilshah5889.tictactoe.models.Move;

public interface BotPlayingStrategy {
    Move decideMove(Bot bot, Board board);
}
