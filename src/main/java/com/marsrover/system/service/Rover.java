package com.marsrover.system.service;

import com.marsrover.system.model.CompassEnum;

public class Rover extends Coordination {

    private static final int COMPASS_CHAR = 2;
    private CompassEnum compassPoint;

    public Rover(String s){
        s = s.replace(" ", "");
        x = Character.getNumericValue(s.charAt(X_CHAR));
        y = Character.getNumericValue( s.charAt(Y_CHAR));
        compassPoint = CompassEnum.valueOf(s.substring(COMPASS_CHAR,COMPASS_CHAR+1));
    }

    public void move(Plateau p, String str) {
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

        }

    }

    public String getOutput(){

        return x + " " + y + " " + compassPoint;
    }
}
