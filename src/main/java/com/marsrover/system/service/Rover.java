package com.marsrover.system.service;

import com.marsrover.system.model.CompassEnum;

public class Rover extends Coordination {

    private static final int COMPASS_CHAR = 2;
    private CompassEnum compassPoint;
    private String message;

    public Rover(String s){
        super(s);
        compassPoint = CompassEnum.valueOf(this.s.substring(COMPASS_CHAR,COMPASS_CHAR+1));
    }

    private void move(Plateau p, String str) {
        for (int i = 0; i < str.length(); i++){
            char action = str.charAt(i);
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
            if(p.checkOutOfPlateau(x,y)) {
                message = "Rover is out of boundary.";
                return;
            }
        }
        message = x + " " + y + " " + compassPoint;
    }

    public String getOutput(Plateau p, String str){
        move(p, str);
        return message;
    }
}
