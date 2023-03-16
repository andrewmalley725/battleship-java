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
            return true;
        }
        return false;
    }

    public void addShips(){
        Ship ship = new Ship(5,'B');
        this.Ships.add(ship);
    }
}