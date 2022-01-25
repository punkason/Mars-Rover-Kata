package com.marsrover.system.service;

import com.marsrover.system.model.CompassEnum;

import java.util.List;

public class Rover extends Coordination {
    private static final int COMPASS_CHAR = 2;
    private CompassEnum compassPoint;
    private final String move;

    public Rover(String s, String move){
        super(s);
        compassPoint = CompassEnum.valueOf(this.input.substring(COMPASS_CHAR,COMPASS_CHAR+1));
        this.move = move;
    }

    private boolean checkOutOfPlateau(final int MAXX, final int MAXY){
        return x < 0 || y < 0 || x > MAXX || y > MAXY;
    }

    public String move(final int MAXX, final int MAXY, List<Rover> roverList, Rover curRover) {
        for (int i = 0; i < move.length(); i++){
            char action = move.charAt(i);
            switch (action){
                case 'L':
                    compassPoint = compassPoint.getPre();
                    break;
                case 'R':
                    compassPoint = compassPoint.getNext();
                    break;
                case 'M':
                    switch (compassPoint) {
                        case N -> y++;
                        case E -> x++;
                        case S -> y--;
                        case W -> x--;
                    }
            }
            if(checkOutOfPlateau(MAXX, MAXY)) {//check out of boundary
                x = -1; // the rover disappers from the plateau
                y = -1;
                return "Rover is out of boundary.";
            }else{//check crash with other rover
                for (Rover tmpRover : roverList) {
                    if(tmpRover != curRover)
                        if(tmpRover.getX() == x && tmpRover.getY() == y)
                            return "Rover is crash.";
                }
            }
        }
        return x + " " + y + " " + compassPoint;
    }
}
