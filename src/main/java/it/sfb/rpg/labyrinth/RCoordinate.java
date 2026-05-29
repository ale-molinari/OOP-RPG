package it.sfb.rpg.labyrinth;

public record RCoordinate(int x, int y)  {

    public RCoordinate calculateNeighborRoom(EDirections direction) {
            int newX = this.x + direction.abs;
            int newY = this.y + direction.ord;
            return new RCoordinate(newX, newY);
    }
}
