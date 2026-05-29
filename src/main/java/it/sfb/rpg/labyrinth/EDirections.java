package it.sfb.rpg.labyrinth;

public enum EDirections {
    NORTH(0,1),
    EAST(1,0),
    SOUTH(0,-1),
    WEST(-1,0);

    public final int abs;
    public final int ord;

    EDirections(int abs, int ord) {
        this.abs = abs;
        this.ord = ord;
    }
    public EDirections getOpposite() {
        return switch (this) {
            case NORTH -> EDirections.SOUTH;
            case SOUTH -> EDirections.NORTH;
            case EAST -> EDirections.WEST;
            case WEST -> EDirections.EAST;
        };
    }
}
