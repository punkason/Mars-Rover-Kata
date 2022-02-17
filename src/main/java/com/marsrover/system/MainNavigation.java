package com.marsrover.system;

import java.util.List;

public class MainNavigation {
    private String message;
    public MainNavigation(){
        message="";
    }

    public void moveRover(List<Rover> roverList, Plateau plateau){
        for (Rover curRover : roverList) {
            if (!message.equals(""))
                message += "\n";
            curRover.sendSignalToRover(roverList, plateau);
            message += curRover.receiveSignalFromRover();
        }
        if (message.equals(""))
            message = "There is no rover";
    }

    public String getOutput(){
        return message;
    }
}
