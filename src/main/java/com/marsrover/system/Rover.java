package com.marsrover.system;

import java.util.List;

public class Rover extends Coordination {
    private static final int COMPASS_CHAR = 2;
    private final String MOVE;
    private CompassEnum compassPoint;
    private String message;

    public Rover(String str, String move){
        super(str);
        compassPoint = CompassEnum.valueOf(this.input.substring(COMPASS_CHAR,COMPASS_CHAR+1));
        MOVE = move;
    }

    private void roverChangeDirection(char action){
        if (action == 'L')
            compassPoint = compassPoint.getPre();
        else
            compassPoint = compassPoint.getNext();
    }

    private void roverMoveXAxis() {
        if (compassPoint == CompassEnum.E)
            x++;
        else
            x--;
    }

    private void roverMoveYAxis(){
        if (compassPoint == CompassEnum.N)
            y++;
        else
            y--;
    }

    private void roverLostSignal(){
        x = -1; // the rover disappears from the plateau
        y = -1;
        message = "Rover is crashed.";
    }

    private boolean checkRoverCrash(List<Rover> roverList){
        for (Rover tmpRover : roverList)
            if(tmpRover != this && (tmpRover.getX() == x && tmpRover.getY() == y)) {//skip comparing between my own rover AND checking if x,y is occupied
                return true;
            }
        return false;
    }

    private boolean roverHealthCheck(List<Rover> roverList, Plateau plateau){
        if(plateau.checkOutOfPlateau(x,y)||checkRoverCrash(roverList)) {
            roverLostSignal();
            return false;
        }
        return true;
    }

    public void sendSignalToRover(List<Rover> roverList, Plateau plateau) {
        for (int i = 0; i < MOVE.length(); i++){
            char action = MOVE.charAt(i);
            switch (action){
                case 'L':
                case 'R':
                    roverChangeDirection(action);
                    break;
                case 'M':
                    switch (compassPoint) {
                        case E, W -> roverMoveXAxis();
                        case N, S -> roverMoveYAxis();
                    }
            }
            if(!roverHealthCheck(roverList, plateau))
                return;
        }
        message =  x + " " + y + " " + compassPoint;
    }

    public String receiveSignalFromRover() {
        return message;
    }
}
