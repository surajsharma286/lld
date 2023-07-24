package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Move {
    private Cell cell;
    private Player player;

    public Move(){

    }

    public Move(Cell cell, Player player) {
        this.cell = cell;
        this.player = player;
    }
}
