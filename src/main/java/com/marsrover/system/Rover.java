package com.marsrover.system;

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

    private boolean checkOutOfPlateau(final int MAX_X, final int MAX_Y){
        return x < 0 || y < 0 || x > MAX_X || y > MAX_Y;
    }

    public String move(final int MAX_X, final int MAX_Y, List<Rover> roverList) {
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
            if(checkOutOfPlateau(MAX_X, MAX_Y)) {//check out of boundary
                x = -1; // the rover disappears from the plateau
                y = -1;
                return "Rover is out of boundary.";
            }else{//check crash with other rover
                for (Rover tmpRover : roverList) {
                    if(tmpRover != this && (tmpRover.getX() == x && tmpRover.getY() == y)) //skip comparing between my own rover AND checking if x,y is occupied
                        return "Rover is crash.";
                }
            }
        }
        return x + " " + y + " " + compassPoint;
    }
}
