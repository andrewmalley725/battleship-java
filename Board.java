package Battleship_Java;

public class Board {

    public char[][] board;
    public int boardLength;
    public char token = '*';
    
    public Board(int length){
        board = new char[length][length];
        this.boardLength = length;
        for (int row = 0; row < this.board.length; row++){
            for (int col = 0; col < this.board[row].length; col++){
                board[row][col] = token;
            }
        }
    }

    public void printBoard(){
        for (int i = 0; i <= this.board.length; i++)
        {
            if (i == 0)
            {
                System.out.print("  ");
            }
            else
            {
                System.out.print(i + " ");
            }
            
        }
        System.out.println();
        for (int row = 0; row < boardLength; row++){
            System.out.print((row+1) + " ");
            for (int col = 0; col < boardLength; col++){
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public void reportHit(int row, int col){
        this.board[row][col] = 'X';
    }

    public void reportMiss(int row, int col)
    {
        this.board[row][col] = 'O';
    }
}
