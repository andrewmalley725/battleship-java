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

    public void decrementShip(int row, int col){
        char t = this.board[row][col];
        for (Ship s : this.Ships){
            if (s.token == t){
                if (s.ShipLength > 1) {
                    System.out.println("HIT!");
                    s.ShipLength -= 1;
                }
                else
                {
                    System.out.println("You sunk my " + s.name + '!');
                    s.ShipLength -= 1;
                }
            }
        }
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
