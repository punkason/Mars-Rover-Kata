package com.marsrover.system;

import java.util.List;

public class MainNavigation {
    private String message;
    public MainNavigation(){
        message="";
    }

    public void moveVehicle(List<Vehicle> vehicleList, Plateau plateau){
        for (Vehicle currentVehicle : vehicleList) {
            if (!message.equals(""))
                message += "\n";
            currentVehicle.sendSignalToRover(vehicleList, plateau);
            message += currentVehicle.receiveSignalFromRover();
        }
        if (message.equals(""))
            message = "There is no rover";
    }

    public String getOutput(){
        return message;
    }
}
