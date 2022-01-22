import com.marsrover.system.service.Plateau;
import com.marsrover.system.service.Rover;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MarsRoverKataTest {

    private Plateau p;
    private Rover r;

    @Test
    public void twoInput(){// rename method?
        p = new Plateau("5 5");
        r = new Rover("1 2 N");
        r.move(p,"LMLMLMLMM");

    }
}
