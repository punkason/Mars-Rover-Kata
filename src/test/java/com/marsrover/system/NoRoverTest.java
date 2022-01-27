package com.marsrover.system;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NoRoverTest {

    private List<Rover> roverList;

    @Before
    public void setup(){
        roverList = new ArrayList<>();
    }

    @Test
    public void noRover(){
        Plateau plateau = new RectangularPlateau("5 5");
        plateau.moveRover(roverList);

        String expectedResult = "There is no rover";
        String actualResult = plateau.getOutput();

        assertEquals(expectedResult, actualResult);
    }
}
