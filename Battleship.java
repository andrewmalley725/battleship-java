package Battleship_Java;

import java.util.Scanner;

public class Battleship {
    public static void main(String[] args){
        int boardlength = 7;

        Board myBoard = new Board(boardlength);
        OpponentBoard oBoard = new OpponentBoard(boardlength);

        try (Scanner scan = new Scanner(System.in)) {

            while(!oBoard.gameOver() && myBoard.numTrys > 0){
                
                System.out.println();
                myBoard.printBoard();
                System.out.println();

                System.out.print("Enter a row: ");
                int row = scan.nextInt() - 1;
                System.out.print("Enter a column: ");
                int col = scan.nextInt() - 1;

                if (oBoard.isHit(row, col)){
                    System.out.println();

                    if (myBoard.board[row][col] != 'X')
                    {
                        oBoard.decrementShip(row, col);
                    }
                    
                    myBoard.reportHit(row, col);
                }
                else
                {
                    myBoard.reportMiss(row, col);
                } 
            }

            if (myBoard.numTrys == 0)
            {
                oBoard.printBoard();
            }
            
        }
    }
}
