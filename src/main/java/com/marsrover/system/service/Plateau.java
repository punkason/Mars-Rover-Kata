package com.marsrover.system.service;

import java.util.List;

public class Plateau extends Coordination {
    private final int MAX_X;
    private final int MAX_Y;

    public Plateau(String s){
        super(s);
        MAX_X = x;
        MAX_Y = y;
    }

    public String getOutput(List<Rover> roverList){
        String message="";
        for (Rover curRover : roverList) {
            if (!message.equals(""))
                message += "\n";
            message += curRover.move(MAX_X, MAX_Y, roverList);
        }
        return message;
    }
}
