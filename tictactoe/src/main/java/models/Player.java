package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
@Builder
public class Player {
    private Symbol symbol;
    private Long id;
    private PlayerType playerType;
    private String name;

    public Move makeMove(Board board){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter Row : ");
        int row = scanner.nextInt();
        System.out.println("Please Enter Column : ");
        int col = scanner.nextInt();

        return new Move(new Cell(row, col),this);
    }
}
