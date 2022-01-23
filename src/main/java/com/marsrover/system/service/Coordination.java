package com.marsrover.system.service;

public class Coordination {

    protected static final int X_CHAR = 0;
    protected static final int Y_CHAR = 1;
    protected int x;
    protected int y;
    protected String s;

    public Coordination(String s){
        this.s = s.replace(" ", "");
        x = Character.getNumericValue(this.s.charAt(X_CHAR));
        y = Character.getNumericValue(this.s.charAt(Y_CHAR));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

