package com.marsrover.system;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NoRoverTest {

    @Test
    public void noRover(){
        List<Vehicle> vehicleList = new ArrayList<>();
        Plateau plateau = new RectangularPlateau("5 5");
        MainNavigation mainNavigation = new MainNavigation();
        mainNavigation.moveVehicle(vehicleList, plateau);

        String expectedResult = "There is no rover";
        String actualResult = mainNavigation.getOutput();

        assertEquals(expectedResult, actualResult);
    }
}
