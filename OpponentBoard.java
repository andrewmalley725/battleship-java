package Battleship_Java;

import java.util.*;

public class OpponentBoard extends Board {

    private ArrayList<Ship> Ships = new ArrayList<Ship>();

    public OpponentBoard(int length) {
        super(length);
        addShips();

        for (Ship ship : this.Ships){
            int rowStart = 3;
            int colStart = 2;
            int count = ship.ShipLength;

            while (count > 0){
                this.board[rowStart][colStart] = ship.token;
                rowStart += 1;
                colStart += 1;
                count -= 1;
            }
        }
        
    }

    public Boolean isHit(int row, int col){
        if (this.board[row][col] != this.token){
            char t = this.board[row][col];
            for (Ship s : this.Ships){
                if (s.token == t){
                    if (s.ShipLength > 0) {
                        s.ShipLength -= 1;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean gameOver(){
        for (Ship ship : this.Ships){
            if (ship.ShipLength > 0){
                return false;
            }
        }
        return true;
    }

    public void addShips(){
        Ship battleship = new Ship(5,'B', "BATTLESHIP");
        this.Ships.add(battleship);
    }
}
