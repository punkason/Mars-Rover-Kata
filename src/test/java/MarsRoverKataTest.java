import com.marsrover.system.service.Plateau;
import com.marsrover.system.service.Rover;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MarsRoverKataTest {

    private Plateau p;
    private Rover r;
    String expectedResult;
    String actualResult;

    @Test
    public void changeToWest(){
        p = new Plateau("5 5");
        r = new Rover("1 1 N");
        //r.move(p,"L");

        expectedResult = "1 1 W";
        actualResult = r.getOutput(p,"L");


        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void changeToEast(){
        p = new Plateau("5 5");
        r = new Rover("1 1 N");
        //r.move(p,"R");

        expectedResult = "1 1 E";
        actualResult = r.getOutput(p,"R");


        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void changeToSouth(){
        p = new Plateau("5 5");
        r = new Rover("1 1 N");
        //r.move(p,"RR");

        expectedResult = "1 1 S";
        actualResult = r.getOutput(p,"RR");


        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void moveNorth(){
        p = new Plateau("5 5");
        r = new Rover("1 1 N");
        //r.move(p,"M");

        expectedResult = "1 2 N";
        actualResult = r.getOutput(p,"M");


        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void moveEast(){
        p = new Plateau("5 5");
        r = new Rover("1 1 E");
        //r.move(p,"M");

        expectedResult = "2 1 E";
        actualResult = r.getOutput(p,"M");


        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void moveSouth(){
        p = new Plateau("5 5");
        r = new Rover("1 1 S");
        //r.move(p,"M");

        expectedResult = "1 0 S";
        actualResult = r.getOutput(p,"M");


        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void moveWest(){
        p = new Plateau("5 5");
        r = new Rover("1 1 W");
        //r.move(p,"M");

        expectedResult = "0 1 W";
        actualResult = r.getOutput(p,"M");


        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void twoInput(){
        p = new Plateau("5 5");
        r = new Rover("1 2 N");
        //r.move(p,"LMLMLMLMM");

        expectedResult = "1 3 N";
        actualResult = r.getOutput(p,"LMLMLMLMM");

        assertEquals(expectedResult, actualResult);

        r = new Rover("3 3 E");
        //r.move(p,"MMRMMRMRRM");

        expectedResult = "5 1 E";
        actualResult = r.getOutput(p,"MMRMMRMRRM");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void roverOutOfXBoundary(){
        p = new Plateau("2 2");
        r = new Rover("1 1 W");
        //r.move(p,"LLMMM");

        expectedResult = "Rover is out of boundary.";
        actualResult = r.getOutput(p,"MMM");

        assertEquals(expectedResult, actualResult);

        r = new Rover("1 1 E");
        actualResult = r.getOutput(p,"MMM");

        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void roverOutOfYBoundary(){
        p = new Plateau("2 2");
        r = new Rover("1 1 S");
        //r.move(p,"LLMMM");

        expectedResult = "Rover is out of boundary.";
        actualResult = r.getOutput(p,"MMM");

        assertEquals(expectedResult, actualResult);

        r = new Rover("1 1 N");
        actualResult = r.getOutput(p,"MMM");

        assertEquals(expectedResult, actualResult);

    }
}
