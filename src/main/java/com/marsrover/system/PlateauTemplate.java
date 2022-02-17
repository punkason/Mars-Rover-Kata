package com.marsrover.system;

import java.util.List;

public abstract class PlateauTemplate implements Plateau {
    private static final int X_CHAR = 0;
    private static final int Y_CHAR = 1;
    protected final int MAX_X;
    protected final int MAX_Y;

    public PlateauTemplate(String str) {
        String[] input = str.split(" ");
        MAX_X = Integer.parseInt(input[X_CHAR]);
        MAX_Y = Integer.parseInt(input[X_CHAR]);
    }

    @Override
    public abstract boolean checkOutOfPlateau(int x, int y) throws Exception;

}
