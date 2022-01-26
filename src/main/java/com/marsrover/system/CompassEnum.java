package com.marsrover.system;

public enum CompassEnum {
    N,
    E,
    S,
    W
    ;

    public static final int COMPASS_LENGTH = values().length;

    public CompassEnum getNext(){
        return CompassEnum.values()[(this.ordinal() + 1) % COMPASS_LENGTH] ;
    }

    public CompassEnum getPre(){
        return CompassEnum.values()[(COMPASS_LENGTH + this.ordinal() - 1) % COMPASS_LENGTH] ;
    }
}

