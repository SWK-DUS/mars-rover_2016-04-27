package org.softwerkskammer.kata.mars.rover;

public enum Direction {
    NORTH {
        public Coordinates forward(Coordinates origin) {
            return new Coordinates(origin.x, origin.y == Coordinates.MAX_Y ? 0 : origin.y + 1);
        }

        @Override
        public Coordinates backward(Coordinates origin) {
            return SOUTH.forward(origin);
        }

        @Override
        public Direction turnRight() { return EAST; }

        @Override
        public Direction turnLeft() { return WEST; }

    },
    EAST {
        public Coordinates forward(Coordinates origin) {
            return new Coordinates(origin.x == Coordinates.MAX_X ? 0 : origin.x + 1, origin.y);
        }

        @Override
        public Coordinates backward(Coordinates origin) {
            return WEST.forward(origin);
        }

        @Override
        public Direction turnRight() { return SOUTH; }

        @Override
        public Direction turnLeft() { return NORTH; }
    },
    SOUTH {
        public Coordinates forward(Coordinates origin) {
            return new Coordinates(origin.x, origin.y == 0 ? Coordinates.MAX_Y : origin.y - 1);
        }

        @Override
        public Coordinates backward(Coordinates origin) {
            return NORTH.forward(origin);
        }

        @Override
        public Direction turnRight() { return WEST; }

        @Override
        public Direction turnLeft() { return EAST; }
    },
    WEST {
        public Coordinates forward(Coordinates origin) {
            return new Coordinates(origin.x == 0 ? Coordinates.MAX_X : origin.x -1, origin.y);
        }

        @Override
        public Coordinates backward(Coordinates origin) {
            return EAST.forward(origin);
        }

        @Override
        public Direction turnRight() { return NORTH; }

        @Override
        public Direction turnLeft() { return SOUTH; }
    };

    public abstract Coordinates forward(Coordinates origin);

    public abstract Coordinates backward(Coordinates origin);

    public abstract Direction turnRight();

    public abstract Direction turnLeft();

}
