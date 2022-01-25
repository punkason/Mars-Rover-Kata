import com.marsrover.system.service.Plateau;
import com.marsrover.system.service.Rover;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MarsRoverKataTest {

    private Plateau p;
    private List<Rover> roverList;
    String expectedResult;
    String actualResult;

    @Before
    public void setup(){
        roverList = new ArrayList<>();
    }

    @Test
    public void noMovement(){
        p = new Plateau("5 5");
        Rover r = new Rover("1 1 N", "");
        roverList.add(r);

        expectedResult = "1 1 N";
        actualResult = p.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void changeToWest(){
        p = new Plateau("5 5");
        Rover r = new Rover("1 1 N", "L");
        roverList.add(r);

        expectedResult = "1 1 W";
        actualResult = p.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void changeToEast(){
        p = new Plateau("5 5");
        Rover r = new Rover("1 1 N", "R");
        roverList.add(r);

        expectedResult = "1 1 E";
        actualResult = p.getOutput(roverList);


        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void changeToSouth(){
        p = new Plateau("5 5");
        Rover r = new Rover("1 1 N", "RR");
        roverList.add(r);

        expectedResult = "1 1 S";
        actualResult = p.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void moveNorth(){
        p = new Plateau("5 5");
        Rover r = new Rover("1 1 N", "M");
        roverList.add(r);

        expectedResult = "1 2 N";
        actualResult = p.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void moveEast(){
        p = new Plateau("5 5");
        Rover r = new Rover("1 1 E", "M");
        roverList.add(r);

        expectedResult = "2 1 E";
        actualResult = p.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void moveSouth(){
        p = new Plateau("5 5");
        Rover r = new Rover("1 1 S","M");
        roverList.add(r);

        expectedResult = "1 0 S";
        actualResult = p.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void moveWest(){
        p = new Plateau("5 5");
        Rover r = new Rover("1 1 W","M");
        roverList.add(r);

        expectedResult = "0 1 W";
        actualResult = p.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void twoInput(){
        p = new Plateau("5 5");
        Rover r = new Rover("1 2 N","LMLMLMLMM");
        roverList.add(r);
        r = new Rover("3 3 E","MMRMMRMRRM");
        roverList.add(r);

        expectedResult = "1 3 N\n5 1 E";
        actualResult = p.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void roverOutOfXBoundary(){
        p = new Plateau("2 2");
        Rover r = new Rover("1 1 W","MMM");
        roverList.add(r);
        r = new Rover("1 0 E","MMM");
        roverList.add(r);

        expectedResult = "Rover is out of boundary.\nRover is out of boundary.";
        actualResult = p.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void roverOutOfYBoundary(){
        p = new Plateau("2 2");
        Rover r = new Rover("1 1 S","MMM");
        roverList.add(r);
        r = new Rover("0 1 N","MMM");
        roverList.add(r);

        expectedResult = "Rover is out of boundary.\nRover is out of boundary.";
        actualResult = p.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void firstRoverCrash(){
        p = new Plateau("5 5");
        Rover r = new Rover("0 0 N","MMM");
        roverList.add(r);
        r = new Rover("0 1 N","MMM");
        roverList.add(r);

        expectedResult = "Rover is crash.\n0 4 N";
        actualResult = p.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void secondRoverCrash(){
        p = new Plateau("5 5");
        Rover r = new Rover("0 1 N","M");
        roverList.add(r);
        r = new Rover("0 0 N","MMM");
        roverList.add(r);

        expectedResult = "0 2 N\nRover is crash.";
        actualResult = p.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void secondAndThirdRoverCrash(){
        p = new Plateau("5 5");
        Rover r = new Rover("0 1 N","M");
        roverList.add(r);
        r = new Rover("0 0 N","MMM");
        roverList.add(r);
        r = new Rover("0 4 S","MMM");
        roverList.add(r);

        expectedResult = "0 2 N\nRover is crash.\nRover is crash.";
        actualResult = p.getOutput(roverList);

        assertEquals(expectedResult, actualResult);
    }
}
