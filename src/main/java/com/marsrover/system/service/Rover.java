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
        int A = x + y;
        //for (int i = 0; i < str.length(); i++){
            switch (compassPoint){
               case N:
                    System.out.println(compassPoint);
                    break;
                case E:
                    break;
                case S:
                    break;
                case W:
                    break;
            }

        //}

    }

    public String getOutput(){

        return "";
    }
}
