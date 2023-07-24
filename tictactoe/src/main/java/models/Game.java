package models;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import strategies.winningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves = new ArrayList<>();
    private Player winner;
    private GameState gameState;
    private int nextMovePlayerIndex;
    private List<WinningStrategy> winningStrategies;

    public void makeMove() {
        Player currentPlayer = players.get(nextMovePlayerIndex);

        System.out.println("\nIt is " + currentPlayer.getName() + " turn. Please make a move ");
        Move move = currentPlayer.makeMove(board);
        System.out.println(currentPlayer.getName()
                + " has made move at Row : " + move.getCell().getRow()
                + " and Column : " + move.getCell().getCol());
        if(!validateMove(move)){
            System.out.println("Invalid Move Try Again!!");
            return;
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cellToUpdate = board.getBoard().get(row).get(col);
        cellToUpdate.setCellState(CellState.FILLED);
        cellToUpdate.setPlayer(currentPlayer);
        moves.add(new Move());

        nextMovePlayerIndex++;
        nextMovePlayerIndex = nextMovePlayerIndex % players.size();

        if(checkWinner(this.board, move)){
            gameState = GameState.WIN;
            winner = currentPlayer;
        }else if(moves.size() == this.board.getSize() * this.board.getSize()){
            gameState = GameState.DRAW;
        }

    }

    public boolean checkWinner(Board board, Move move){
        for(WinningStrategy winningStrategy:winningStrategies){
            if(winningStrategy.checkWinner(board, move)){
                return true;
            }
        }
        return false;
    }

    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row >=board.getSize() || row <0){
            return false;
        }

        if(col >=board.getSize() || col <0){
            return false;
        }

        if(board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)){
            return true;
        }
        return false;
    }

    public void printBoard(){
        for(int i=0;i< board.getSize();i++){
            List<Cell> row = this.board.getBoard().get(i);
            System.out.println();
            for(int j=0;j<row.size();j++){
                Cell cell = row.get(j);
                cell.display();
            }
        }
    }

}
