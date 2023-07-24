package strategies.winningstrategies;

import models.Board;
import models.Move;
import models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy{
    // There can be only 2 Diagonals
    private Map<Symbol, Integer> leftDiagonalCounts = new HashMap<>();
    private Map<Symbol, Integer> rightDiagonalCounts = new HashMap<>();

    // |
    // |
    // |

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(row == col){
            if(!leftDiagonalCounts.containsKey(symbol)){
                leftDiagonalCounts.put(symbol, 0);
            }
            leftDiagonalCounts.put(symbol, leftDiagonalCounts.get(symbol)+1);

            if(leftDiagonalCounts.get(symbol).equals(board.getSize())){
                return true;
            }
        }

        if(row+col == board.getSize()){
            if(!rightDiagonalCounts.containsKey(symbol)){
                rightDiagonalCounts.put(symbol, 0);
            }
            rightDiagonalCounts.put(symbol, rightDiagonalCounts.get(symbol)+1);

            if(rightDiagonalCounts.get(symbol).equals(board.getSize())){
                return true;
            }
        }
        return false;
    }
}
