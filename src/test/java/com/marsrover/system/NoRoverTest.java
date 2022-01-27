package com.marsrover.system;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NoRoverTest {

    @Test
    public void noRover(){
        List<Rover> roverList = new ArrayList<>();
        Plateau plateau = new RectangularPlateau("5 5");
        plateau.moveRover(roverList);

        String expectedResult = "There is no rover";
        String actualResult = plateau.getOutput();

        assertEquals(expectedResult, actualResult);
    }
}
