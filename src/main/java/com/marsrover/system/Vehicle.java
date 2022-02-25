package com.marsrover.system;

import java.util.List;

public interface Vehicle {

    void sendSignalToVehicle(List<Vehicle> vehicleList, Plateau plateau);

    String receiveSignalFromVehicle();

    int getX();

    int getY();
}
