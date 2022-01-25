package com.marsrover.system.service;

import java.util.List;

public class Plateau extends Coordination {
    private final int MAXX;
    private final int MAXY;

    public Plateau(String s){
        super(s);
        MAXX = x;
        MAXY = y;
    }

    public String getOutput(List<Rover> roverList){
        String message="";
        for (Rover curRover : roverList) {
            if (!message.equals(""))
                message += "\n";
            message += curRover.move(MAXX, MAXY, roverList, curRover);
        }
/*
        for (Rover r : roverList) {
            System.out.println("DEBUG:"+ r.getX() + " " +r.getY());
        }*/
        return message;
    }
}
