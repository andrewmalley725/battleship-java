package Battleship_Java;

import java.util.*;

public class OpponentBoard extends Board {

    private ArrayList<Ship> Ships = new ArrayList<Ship>();
    private String[] orientations = {"DIAGONAL", "HORIZONTAL", "VERTICAL"};

    public OpponentBoard(int length) {
        super(length);
        addShips();
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

    // private boolean canPlace(Ship ship, int scol, int srow){
    //     if (ship.orientation == "HORIZONTAL"){
    //         int endcol;
    //         if ((scol + (ship.ShipLength - 1) <= this.boardLength - 1) || (scol - (ship.ShipLength - 1) >= 0)){
    //             if (scol + (ship.ShipLength - 1) <= this.boardLength - 1){
    //                 endcol = scol + (ship.ShipLength - 1);
    //                 for (int i = scol; i <= endcol; i++){
    //                     this.board[srow][i] = ship.token;
    //                 }
    //             }
    //             else if (scol - (ship.ShipLength - 1) >= 0){
    //                 endcol = scol - (ship.ShipLength - 1);
    //                 for (int i = scol; i >= endcol; i--){
    //                     this.board[srow][i] = ship.token;
    //                 }
    //             }
    //         }
            
    //     }
    //     else if(ship.orientation == "VERTICAL"){
    //         return true;
    //     }
    //     else if (ship.orientation == "DIAGONAL"){
    //         return true;
    //     }
    //     return true;
    // }

    private void addShips(){
        Random random = new Random();

        //int randElement = random.nextInt(this.orientations.length);

        Ship battleship = new Ship(5,'B', "BATTLESHIP", "HORIZONTAL");
        this.Ships.add(battleship);

        // randElement = random.nextInt(this.orientations.length);

        // Ship cruiser = new Ship(2,'C', "CRUISER", this.orientations[randElement]);
        // this.Ships.add(cruiser);

        for (Ship ship : this.Ships){
            int rowStart = random.nextInt(this.boardLength);
            int colStart = random.nextInt(this.boardLength);
            int rowStartCopy = rowStart;
            int colStartCopy = colStart;
            int count = ship.ShipLength;
            String orient = ship.orientation;

            while (count > 0){
                this.board[rowStartCopy][colStartCopy] = ship.token;
                if (orient == "DIAGONAL"){
                    rowStart++;
                    colStart++;
                }
                else if (orient == "VERTICAL"){
                    rowStart++;
                }
                else
                {
                    if ((colStart + (ship.ShipLength - 1) <= this.boardLength - 1) || (colStart - (ship.ShipLength - 1) >= 0))
                    {
                        if (colStart + (ship.ShipLength - 1) <= this.boardLength - 1)
                        {
                            colStartCopy++;
                        }
                        else
                        {
                            colStartCopy--;
                        }
                    }
                   
                }
                count--;
            }
        }
    }
}
