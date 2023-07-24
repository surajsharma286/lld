package models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Board {
    private int size;
    private List<List<Cell>> board;


    public Board(int size){
        this.size = size;
        board = new ArrayList<>();

        for(int i=0;i<size;i++){
            board.add(new ArrayList<>());

            for(int j=0;j<size;j++){
                Cell cell = new Cell(i,j);
                cell.setCellState(CellState.EMPTY);
                board.get(i).add(cell);
            }
        }

    }

}
