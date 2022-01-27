package com.marsrover.system;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class OneRoverTest {
    private List<Rover> roverList;

    @Before
    public void setup(){
        roverList = new ArrayList<>();
    }

    @Parameter
    public String plateauSize;
    @Parameter(value = 1)
    public String roverLocation;
    @Parameter(value = 2)
    public String movement;
    @Parameter(value = 3)
    public String expectedResult;

    //Single parameter, use Object[]
    @Parameters(name = "{index}: - {0}, {1}, {2}, {3}")
    public static Object[][] data() {
        return new Object[][]{
                {"5 5","1 1 N","","1 1 N"}, //noMovement
                {"5 5","1 1 N","L","1 1 W"}, //changeToWest
                {"5 5","1 1 N","R","1 1 E"}, //changeToEast
                {"5 5","1 1 N","RR","1 1 S"}, //changeToSouth
                {"5 5","1 1 N","M","1 2 N"}, //moveNorth
                {"5 5","1 1 E","M","2 1 E"}, //moveEast
                {"5 5","1 1 S","M","1 0 S"}, //moveSouth
                {"5 5","1 1 W","M","0 1 W"}, //moveWest
                {"2 2","1 1 W","MMM","Rover is out of boundary."}, //rover.x < 0
                {"2 2","1 0 E","MMM","Rover is out of boundary."}, //rover.x > MAX_X
                {"2 2","1 1 S","MMM","Rover is out of boundary."}, //rover.y < 0
                {"2 2","0 1 N","MMM","Rover is out of boundary."}, //rover.y > MAX_Y
        };
    }

    @Test
    public void oneRover() {
        Plateau plateau = new RectangularPlateau(plateauSize);
        Rover rover = new Rover(roverLocation, movement);
        roverList.add(rover);
        plateau.moveRover(roverList);

        String actualResult = plateau.getOutput();

        assertEquals(expectedResult, actualResult);
    }
}