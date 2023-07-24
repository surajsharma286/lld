import controllers.GameController;
import models.*;
import strategies.winningstrategies.ColumnWinningStrategy;
import strategies.winningstrategies.DiagonalWinningStrategy;
import strategies.winningstrategies.RowWinningStrategy;
import strategies.winningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        System.out.println("Welcome to Tic Tac Toe !! \n");
        System.out.print("Enter Board Size : ");
        Scanner scanner = new Scanner(System.in);
        int boardSize = scanner.nextInt();
        try {

            GameController gameController = new GameController();

            Player player1 = Player.builder()
                    .id(1L)
                    .name("Suraj")
                    .playerType(PlayerType.HUMAN)
                    .symbol(new Symbol('X'))
                    .build();

            Player player2 = Player.builder()
                    .id(2L)
                    .name("Sharma")
                    .playerType(PlayerType.HUMAN)
                    .symbol(new Symbol('O'))
                    .build();

            List<Player> players = new ArrayList<>();
            players.add(player1);
            players.add(player2);

            List<WinningStrategy> winningStrategies = List.of(
                    new RowWinningStrategy(),
                    new ColumnWinningStrategy(),
                    new DiagonalWinningStrategy()
            );

            Game game = gameController.startGame(
                    boardSize,
                    players,
                    winningStrategies);

            while (gameController.checkState(game).equals(GameState.IN_PROGRESS)) {
                gameController.printBoard(game);

                gameController.makeMove(game);
            }

            System.out.println("\n**************** Game is finished ************");
            GameState state = gameController.checkState(game);

            if (state.equals(GameState.DRAW)) {
                System.out.println("It is a draw");
            } else {
                System.out.println(
                        "\n**************** Winner is " + gameController.getWinner(game).getName() +
                                " (Symbol => "+gameController.getWinner(game).getSymbol().getAchar() +" ) ************");
            }

            gameController.printBoard(game);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}