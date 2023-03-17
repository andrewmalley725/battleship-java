package Battleship_Java;

import java.util.*;

public class OpponentBoard extends Board {

    private ArrayList<Ship> Ships = new ArrayList<Ship>();
    private String[] orientations = {"HORIZONTAL", "VERTICAL"};

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
            if (s.token == t && s.ShipLength > 0){
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

    private boolean canPlace(Ship ship, int colStart, int rowStart)
    {
        boolean vool = true;

        if (ship.orientation.equals("HORIZONTAL"))
        {
            int colEnd;

            if (this.board[rowStart][colStart] != this.token)
            {
                vool = false;
            }

            else
            {
                if ((colStart + (ship.ShipLength - 1) <= this.boardLength - 1))
                {
                    colEnd = (colStart + (ship.ShipLength - 1));
                    for (int i = colStart; i <= colEnd; i++){
                        if (this.board[rowStart][i] != this.token){
                            vool = false;
                        }
                    }
                }
                else
                {
                    colEnd = (colStart - (ship.ShipLength - 1));
                    for (int i = colStart; i >= colEnd; i--){
                        if (this.board[rowStart][i] != this.token){
                            vool = false;
                        }
                    }
                }
            }
        }
        else
        {
            int rowEnd;

            if (this.board[rowStart][colStart] != this.token)
            {
                vool = false;
            }

            else
            {
                if ((rowStart + (ship.ShipLength - 1) <= this.boardLength - 1))
                {
                    rowEnd = (rowStart + (ship.ShipLength - 1));
                    for (int i = rowStart; i <= rowEnd; i++){
                        if (this.board[i][colStart] != this.token){
                            vool = false;
                        }
                    }
                }
                else
                {
                    rowEnd = (rowStart - (ship.ShipLength - 1));
                    for (int i = rowStart; i >= rowEnd; i--){
                        if (this.board[i][colStart] != this.token){
                            vool = false;
                        }
                    }
                }
            }
        }
        return vool;
    }


    private void addShips(){
        Random random = new Random();

        Ship battleship = new Ship(4,'B', "BATTLESHIP", "HORIZONTAL");
        this.Ships.add(battleship);

        Ship cruiser = new Ship(3,'C', "CRUISER", "HORIZONTAL");
        this.Ships.add(cruiser);

        Ship destroyer = new Ship(5,'D', "DESTROYER", "HORIZONTAL");
        this.Ships.add(destroyer);

        Ship submarine = new Ship(2,'S', "SUBMARINE", "HORIZONTAL");
        this.Ships.add(submarine);

        for (Ship ship : this.Ships){
            
            int randElement = random.nextInt(this.orientations.length);
            ship.orientation = orientations[randElement];

            int rowStart = random.nextInt(this.boardLength);
            int colStart = random.nextInt(this.boardLength);
            int rowStartCopy = rowStart;
            int colStartCopy = colStart;
            int count = ship.ShipLength;
            String orient = ship.orientation;

            while (!this.canPlace(ship, colStart, rowStart))
            {
                rowStart = random.nextInt(this.boardLength);
                colStart = random.nextInt(this.boardLength);
                rowStartCopy = rowStart;
                colStartCopy = colStart;
            }

            while (count > 0){
                this.board[rowStartCopy][colStartCopy] = ship.token;

                if (orient == "VERTICAL"){

                    if (((rowStart + (ship.ShipLength - 1) <= this.boardLength - 1) || (rowStart - (ship.ShipLength - 1) >= 0)))
                    {

                        if (rowStart + (ship.ShipLength - 1) < this.boardLength)
                        {
                            rowStartCopy++;
                        }
                        else if ((rowStart - (ship.ShipLength - 1) > -1))
                        {
                            rowStartCopy--;
                        }
                    }
                }
                else
                {
                    if (((colStart + (ship.ShipLength - 1) <= this.boardLength - 1) || (colStart - (ship.ShipLength - 1) >= 0)))
                    {

                        if (colStart + (ship.ShipLength - 1) < this.boardLength)
                        {
                            colStartCopy++;
                        }
                        else if ((colStart - (ship.ShipLength - 1) > -1))
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
