package com.marsrover.system;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TwoOrMoreRoversTest {

    private Plateau plateau;
    private List<Rover> roverList;
    private Rover rover;
    private MainNavigation mainNavigation;
    private String expectedResult;
    private String actualResult;

    @Before
    public void setup(){
        roverList = new ArrayList<>();
        mainNavigation = new MainNavigation();
    }

    @Test
    public void twoInput(){
        plateau = new RectangularPlateau("5 5");
        rover = new Rover("1 2 N","LMLMLMLMM");
        roverList.add(rover);
        rover = new Rover("3 3 E","MMRMMRMRRM");
        roverList.add(rover);
        mainNavigation.moveRover(roverList,plateau);

        expectedResult = "1 3 N\n5 1 E";
        actualResult = mainNavigation.getOutput();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void firstRoverCrash(){
        plateau = new RectangularPlateau("5 5");
        rover = new Rover("0 0 N","MMM");
        roverList.add(rover);
        rover = new Rover("0 1 N","MMM");
        roverList.add(rover);
        mainNavigation.moveRover(roverList,plateau);

        expectedResult = "Rover is crashed.\n0 4 N";
        actualResult = mainNavigation.getOutput();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void secondRoverCrash(){
        plateau = new RectangularPlateau("5 5");
        rover = new Rover("0 1 N","M");
        roverList.add(rover);
        rover = new Rover("0 0 N","MMM");
        roverList.add(rover);
        mainNavigation.moveRover(roverList,plateau);

        expectedResult = "0 2 N\nRover is crashed.";
        actualResult = mainNavigation.getOutput();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void secondAndThirdRoverCrash(){
        plateau = new RectangularPlateau("5 5");
        rover = new Rover("0 1 N","M");
        roverList.add(rover);
        rover = new Rover("0 0 N","MMM");
        roverList.add(rover);
        rover = new Rover("0 4 S","MMM");
        roverList.add(rover);
        mainNavigation.moveRover(roverList,plateau);

        expectedResult = "0 2 N\nRover is crashed.\nRover is crashed.";
        actualResult = mainNavigation.getOutput();

        assertEquals(expectedResult, actualResult);
    }
}
