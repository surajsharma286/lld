package controllers;

import models.Board;
import models.Game;
import models.GameState;
import models.Player;
import strategies.winningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public Game startGame(int boardSize, List<Player> players, List<WinningStrategy> winningStrategies) {
        return Game.builder()
                .board(new Board(boardSize))
                .players(players)
                .winningStrategies(winningStrategies)
                .gameState(GameState.IN_PROGRESS)
                .nextMovePlayerIndex(0)
                .moves(new ArrayList<>())
                .build();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public GameState checkState(Game game) {
        return game.getGameState();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }
}
