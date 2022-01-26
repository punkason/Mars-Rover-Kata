package com.marsrover.system;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MarsRoverKataTest {

    private Plateau plateau;
    private List<Rover> roverList;
    String expectedResult;
    String actualResult;

    @Before
    public void setup(){
        roverList = new ArrayList<>();
    }

    @Test
    public void noMovement(){
        plateau = new Plateau("5 5");
        Rover rover = new Rover("1 1 N", "");
        roverList.add(rover);

        expectedResult = "1 1 N";
        actualResult = plateau.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void changeToWest(){
        plateau = new Plateau("5 5");
        Rover rover = new Rover("1 1 N", "L");
        roverList.add(rover);

        expectedResult = "1 1 W";
        actualResult = plateau.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void changeToEast(){
        plateau = new Plateau("5 5");
        Rover rover = new Rover("1 1 N", "R");
        roverList.add(rover);

        expectedResult = "1 1 E";
        actualResult = plateau.getOutput(roverList);


        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void changeToSouth(){
        plateau = new Plateau("5 5");
        Rover rover = new Rover("1 1 N", "RR");
        roverList.add(rover);

        expectedResult = "1 1 S";
        actualResult = plateau.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void moveNorth(){
        plateau = new Plateau("5 5");
        Rover rover = new Rover("1 1 N", "M");
        roverList.add(rover);

        expectedResult = "1 2 N";
        actualResult = plateau.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void moveEast(){
        plateau = new Plateau("5 5");
        Rover rover = new Rover("1 1 E", "M");
        roverList.add(rover);

        expectedResult = "2 1 E";
        actualResult = plateau.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void moveSouth(){
        plateau = new Plateau("5 5");
        Rover rover = new Rover("1 1 S","M");
        roverList.add(rover);

        expectedResult = "1 0 S";
        actualResult = plateau.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void moveWest(){
        plateau = new Plateau("5 5");
        Rover rover = new Rover("1 1 W","M");
        roverList.add(rover);

        expectedResult = "0 1 W";
        actualResult = plateau.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void twoInput(){
        plateau = new Plateau("5 5");
        Rover rover = new Rover("1 2 N","LMLMLMLMM");
        roverList.add(rover);
        rover = new Rover("3 3 E","MMRMMRMRRM");
        roverList.add(rover);

        expectedResult = "1 3 N\n5 1 E";
        actualResult = plateau.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void roverOutOfXBoundary(){
        plateau = new Plateau("2 2");
        Rover rover = new Rover("1 1 W","MMM");
        roverList.add(rover);
        rover = new Rover("1 0 E","MMM");
        roverList.add(rover);

        expectedResult = "Rover is out of boundary.\nRover is out of boundary.";
        actualResult = plateau.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void roverOutOfYBoundary(){
        plateau = new Plateau("2 2");
        Rover rover = new Rover("1 1 S","MMM");
        roverList.add(rover);
        rover = new Rover("0 1 N","MMM");
        roverList.add(rover);

        expectedResult = "Rover is out of boundary.\nRover is out of boundary.";
        actualResult = plateau.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void firstRoverCrash(){
        plateau = new Plateau("5 5");
        Rover rover = new Rover("0 0 N","MMM");
        roverList.add(rover);
        rover = new Rover("0 1 N","MMM");
        roverList.add(rover);

        expectedResult = "Rover is crash.\n0 4 N";
        actualResult = plateau.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void secondRoverCrash(){
        plateau = new Plateau("5 5");
        Rover rover = new Rover("0 1 N","M");
        roverList.add(rover);
        rover = new Rover("0 0 N","MMM");
        roverList.add(rover);

        expectedResult = "0 2 N\nRover is crash.";
        actualResult = plateau.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void secondAndThirdRoverCrash(){
        plateau = new Plateau("5 5");
        Rover rover = new Rover("0 1 N","M");
        roverList.add(rover);
        rover = new Rover("0 0 N","MMM");
        roverList.add(rover);
        rover = new Rover("0 4 S","MMM");
        roverList.add(rover);

        expectedResult = "0 2 N\nRover is crash.\nRover is crash.";
        actualResult = plateau.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }
}
