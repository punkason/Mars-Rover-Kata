package com.marsrover.system;

import java.util.List;

public interface Plateau {
    boolean checkOutOfPlateau(int x, int y);

    void moveRover(List<Rover> roverList);

    String getOutput();

}
