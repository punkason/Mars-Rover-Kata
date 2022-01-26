package com.marsrover.system;

import java.util.List;

public class Plateau extends Coordination {
    private final int MAX_X;
    private final int MAX_Y;
    private String message;

    public Plateau(String s){
        super(s);
        MAX_X = x;
        MAX_Y = y;
        message="";
    }

    public boolean checkOutOfPlateau(){
        return x < 0 || y < 0 || x > MAX_X || y > MAX_Y;
    }

    public void moveRover(List<Rover> roverList){
        for (Rover curRover : roverList) {
            if (!message.equals(""))
                message += "\n";
            message += curRover.move(MAX_X, MAX_Y, roverList, this);
        }
    }

    public String getOutput(){
        return message;
    }
}
