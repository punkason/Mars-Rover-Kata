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
        for (Rover r : roverList) {
            if (!message.equals(""))
                message += "\n";
            message += r.move(MAXX, MAXY);
        }
        return message;
    }
}
