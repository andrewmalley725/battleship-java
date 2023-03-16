package Battleship_Java;

import java.util.Scanner;

public class Battleship {
    public static void main(String[] args){
        int boardlength = 8;

        Board myBoard = new Board(boardlength);
        OpponentBoard oBoard = new OpponentBoard(boardlength);

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter a row: ");
            int row = scan.nextInt() - 1;
            System.out.print("Enter a column: ");
            int col = scan.nextInt() - 1;

            if (oBoard.isHit(row, col)){
                myBoard.reportHit(row, col);
            }
            else
            {
                System.out.println("Incorrect!");
            }

            System.out.println();
            myBoard.printBoard();
        }
    }
}