package com.marsrover.system.service;

public class Plateau extends Coordination {

    public Plateau(String s){
        s = s.replace(" ", "");
        x = Character.getNumericValue(s.charAt(X_CHAR));
        y = Character.getNumericValue( s.charAt(Y_CHAR));
    }

    public boolean checkWithinPlateau(){

        return false;
    }
}
