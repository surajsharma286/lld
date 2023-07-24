package strategies.winningstrategies;

import models.Board;
import models.Move;
import models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy{
    // In Each Column, each Symbol is present how many times

    Map<Integer, HashMap<Symbol, Integer>> counts = new HashMap<>();
    // | 0 | -> { X-> 0; O->0 }
    // | 1 | -> { X-> 0; O->0 }
    // | 2 |
    // | 3 |

    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!counts.containsKey(col)){
            counts.put(col, new HashMap<>());
        }
        Map<Symbol, Integer> colMap = counts.get(col);

        if(!colMap.containsKey(symbol)){
            colMap.put(symbol, 0);
        }

        colMap.put(symbol, colMap.get(symbol)+1);

        if(colMap.get(symbol).equals(board.getSize())){
            return true;
        }

        return false;
    }
}
