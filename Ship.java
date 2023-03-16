package Battleship_Java;

public class Ship {
    public int ShipLength;
    public char token;
    public String name;
    public String orientation;

    public Ship(int len, char t, String n, String o){
        this.ShipLength = len;
        this.token = t;
        this.name = n;
        this.orientation = o;
    }
}
