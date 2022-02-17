package com.marsrover.system;

import java.util.List;

public interface Vehicle {

    void sendSignalToRover(List<Vehicle> vehicleList, Plateau plateau);

    String receiveSignalFromRover();

    int getX();

    int getY();
}
