package com.swapnilshah5889.tictactoe.factories;

import com.swapnilshah5889.tictactoe.models.BotDifficultyLevel;
import com.swapnilshah5889.tictactoe.strategies.botplayingstrategy.BotPlayingStrategy;
import com.swapnilshah5889.tictactoe.strategies.botplayingstrategy.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel level) {

        // If else condition to decide strategy based on difficulty level -> TODO
        return new RandomBotPlayingStrategy();
    }
}
