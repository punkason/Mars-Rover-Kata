package com.marsrover.system;

public class Coordination {
    private static final int X_CHAR = 0;
    private static final int Y_CHAR = 1;
    protected int x;
    protected int y;
    protected String input;

    public Coordination(String str){
        input = str.replace(" ", "");
        x = Character.getNumericValue(input.charAt(X_CHAR));
        y = Character.getNumericValue(input.charAt(Y_CHAR));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

