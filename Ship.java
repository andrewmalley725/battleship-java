package Battleship_Java;

public class Ship {
    public int ShipLength;
    public char token;
    public String name;

    public Ship(int len, char t, String n){
        this.ShipLength = len;
        this.token = t;
        this.name = n;
    }
}
