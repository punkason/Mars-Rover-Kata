package com.marsrover.system;

import java.util.List;

public interface Vehicle {

    void sendSignalToVehicle(List<Vehicle> vehicleList, Plateau plateau);

    String receiveSignalFromRover();

    int getX();

    int getY();
}
