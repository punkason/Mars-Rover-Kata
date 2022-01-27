package com.marsrover.system;

public class RectangularPlateau extends PlateauTemplate {
    public RectangularPlateau(String str) {
        super(str);
    }

    @Override
    public boolean checkOutOfPlateau(int x, int y){
        return x < 0 || y < 0 || x > MAX_X || y > MAX_Y;
    }

}
