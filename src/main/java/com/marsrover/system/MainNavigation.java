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
            currentVehicle.sendSignalToVehicle(vehicleList, plateau);
            message += currentVehicle.receiveSignalFromRover();
        }
        if (message.equals(""))
            message = "There is no vehicle";
    }

    public String getOutput(){
        return message;
    }

}
