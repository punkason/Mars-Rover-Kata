package com.marsrover.system.service;

public class Plateau extends Coordination {

    public Plateau(String s){
        super(s);
    }

    public boolean checkOutOfPlateau(int roverX, int roverY){
        return roverX < 0 || roverY < 0 || roverX > x || roverY > y;
    }
}
