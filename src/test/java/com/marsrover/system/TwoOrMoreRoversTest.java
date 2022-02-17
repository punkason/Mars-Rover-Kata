package com.marsrover.system;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TwoOrMoreRoversTest {

    private Plateau plateau;
    private List<Vehicle> vehicleList;
    private Vehicle rover;
    private MainNavigation mainNavigation;
    private String expectedResult;
    private String actualResult;

    @Before
    public void setup(){
        vehicleList = new ArrayList<>();
        mainNavigation = new MainNavigation();
    }

    @Test
    public void twoNormalRovers(){
        plateau = new RectangularPlateau("5 5");
        rover = new Rover("1 2 N","LMLMLMLMM");
        vehicleList.add(rover);
        rover = new Rover("3 3 E","MMRMMRMRRM");
        vehicleList.add(rover);
        mainNavigation.moveVehicle(vehicleList,plateau);

        expectedResult = "1 3 N\n5 1 E";
        actualResult = mainNavigation.getOutput();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void firstRoverCrash(){
        plateau = new RectangularPlateau("5 5");
        rover = new Rover("0 0 N","MMM");
        vehicleList.add(rover);
        rover = new Rover("0 1 N","MMM");
        vehicleList.add(rover);
        mainNavigation.moveVehicle(vehicleList,plateau);

        expectedResult = "Rover is crashed.\n0 4 N";
        actualResult = mainNavigation.getOutput();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void secondRoverCrash(){
        plateau = new RectangularPlateau("5 5");
        rover = new Rover("0 1 N","M");
        vehicleList.add(rover);
        rover = new Rover("0 0 N","MMM");
        vehicleList.add(rover);
        mainNavigation.moveVehicle(vehicleList,plateau);

        expectedResult = "0 2 N\nRover is crashed.";
        actualResult = mainNavigation.getOutput();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void secondAndThirdRoverCrash(){
        plateau = new RectangularPlateau("5 5");
        rover = new Rover("0 1 N","M");
        vehicleList.add(rover);
        rover = new Rover("0 0 N","MMM");
        vehicleList.add(rover);
        rover = new Rover("0 4 S","MMM");
        vehicleList.add(rover);
        mainNavigation.moveVehicle(vehicleList,plateau);

        expectedResult = "0 2 N\nRover is crashed.\nRover is crashed.";
        actualResult = mainNavigation.getOutput();

        assertEquals(expectedResult, actualResult);
    }
}
