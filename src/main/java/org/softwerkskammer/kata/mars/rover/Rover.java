package org.softwerkskammer.kata.mars.rover;

public class Rover {

    private Coordinates coordinate;
    private Direction direction;

    public Rover(Coordinates coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public Coordinates position() {
        return coordinate;
    }

    public Direction direction() {
        return direction;
    }

    @Override
    public String toString() {
        return "Rover{" +
                "coordinate=" + coordinate +
                ", direction=" + direction +
                '}';
    }

    public void executeCommand(char[] commands) {
        for (char c: commands) {
            if (c == 'f') {
                this.coordinate = this.direction.forward(this.coordinate);
            } else if (c == 'b') {
                this.coordinate = this.direction.backward(this.coordinate);
            } else if (c == 'l') {
                this.direction = this.direction.turnLeft();
            } else if (c == 'r') {
                this.direction = this.direction.turnRight();
            }
        }
    }
}
