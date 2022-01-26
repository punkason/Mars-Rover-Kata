package com.marsrover.system;

import java.util.List;

public abstract class AbstractPlateau extends Coordination implements Plateau {
    protected final int MAX_X;
    protected final int MAX_Y;
    protected String message;

    public AbstractPlateau(String str) {
        super(str);
        MAX_X = x;
        MAX_Y = y;
        message="";
    }

    @Override
    public void moveRover(List<Rover> roverList){
        for (Rover curRover : roverList) {
            if (!message.equals(""))
                message += "\n";
            message += curRover.move(roverList, this);
        }
    }

    public String getOutput(){
        return message;
    }
}
