package strategies.winningstrategies;

import models.Board;
import models.Move;
import models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{
    // In Each Row, each Symbol is present how many times

    Map<Integer, HashMap<Symbol, Integer>> counts = new HashMap<>();
    // | 0 | -> { X-> 0; O->0 }
    // | 1 | -> { X-> 0; O->0 }
    // | 2 |
    // | 3 |

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!counts.containsKey(row)){
            counts.put(row, new HashMap<>());
        }
        Map<Symbol, Integer> rowMap = counts.get(row);

        if(!rowMap.containsKey(symbol)){
            rowMap.put(symbol, 0);
        }

        rowMap.put(symbol, rowMap.get(symbol)+1);

        if(rowMap.get(symbol).equals(board.getSize())){
            return true;
        }

        return false;
    }
}
