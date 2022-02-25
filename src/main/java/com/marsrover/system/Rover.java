package com.marsrover.system;

import java.util.List;

public class Rover implements Vehicle{
    private static final int X_CHAR = 0;
    private static final int Y_CHAR = 1;
    private static final int COMPASS_CHAR = 2;
    private final String MOVE;
    private CompassEnum compassPoint;
    private String message;
    private int x;
    private int y;

    public Rover(String str, String move){
        String[] input = str.split(" ");
        x = Integer.parseInt(input[X_CHAR]);
        y = Integer.parseInt(input[Y_CHAR]);
        compassPoint = CompassEnum.valueOf(input[COMPASS_CHAR]);
        MOVE = move;
    }

    private void roverChangeDirection(char action){
        if (action == 'L')
            compassPoint = compassPoint.getPrevious();
        else //R
            compassPoint = compassPoint.getNext();
    }

    private void roverMoveXAxis() {
        if (compassPoint == CompassEnum.E)
            x++;
        else //W
            x--;
    }

    private void roverMoveYAxis(){
        if (compassPoint == CompassEnum.N)
            y++;
        else //S
            y--;
    }

    private void roverLostSignal(){
        x = -1; // the rover disappears from the plateaucurrentVehicle
        y = -1;
        message = "Rover is crashed.";
    }

    private void negativeCoordinate(){
        message = "The coordinates are negative.";
    }

    private boolean checkRoverCrash(List<Vehicle> vehicleList){
        for (Vehicle tmpRover : vehicleList)
            if(tmpRover != this && (tmpRover.getX() == x && tmpRover.getY() == y)) {//skip comparing between my own rover AND checking if x,y is occupied
                return true;
            }
        return false;
    }

    private boolean roverHealthCheck(List<Vehicle> vehicleList, Plateau plateau){
        try {
            if (plateau.checkOutOfPlateau(x, y) || checkRoverCrash(vehicleList)) {
                roverLostSignal();
                return false;
            }
            return true;
        }catch (Exception e){
            negativeCoordinate();
            return false;
        }
    }

    @Override
    public void sendSignalToVehicle(List<Vehicle> vehicleList, Plateau plateau) {
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
            if(!roverHealthCheck(vehicleList, plateau))
                return;
        }
        message =  x + " " + y + " " + compassPoint;
    }

    @Override
    public String receiveSignalFromVehicle() {
        return message;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
