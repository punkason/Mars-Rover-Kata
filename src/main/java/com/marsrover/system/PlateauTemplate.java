package com.marsrover.system;

import java.util.List;

public abstract class PlateauTemplate extends Coordination implements Plateau {
    protected final int MAX_X;
    protected final int MAX_Y;
    protected String message;

    public PlateauTemplate(String str) {
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
            curRover.sendSignalToRover(roverList, this);
            message += curRover.receiveSignalFromRover();
        }
        if (message.equals(""))
            message = "There is no rover";
    }

    public String getOutput(){
        return message;
    }

    @Override
    public abstract boolean checkOutOfPlateau(int x, int y);

}
