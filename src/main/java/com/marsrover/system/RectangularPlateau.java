package com.marsrover.system;

public class RectangularPlateau extends PlateauTemplate {
    public RectangularPlateau(String str) {
        super(str);
    }

    @Override
    public boolean checkOutOfPlateau(int x, int y) throws Exception {
        if (x < 0 || y < 0 )
            throw new Exception();
        return x > MAX_X || y > MAX_Y;
    }
}
