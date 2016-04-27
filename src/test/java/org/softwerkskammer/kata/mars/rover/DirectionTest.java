package org.softwerkskammer.kata.mars.rover;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@RunWith(Parameterized.class)
public class DirectionTest {

    private final Coordinates origin;
    private final Direction direction;
    private final Coordinates destination;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new Coordinates(0, 0), Direction.NORTH, new Coordinates(0, 1)},
                {new Coordinates(0, 1), Direction.NORTH, new Coordinates(0, 2)},
                {new Coordinates(1, 1), Direction.NORTH, new Coordinates(1, 2)},
                {new Coordinates(0, Coordinates.MAX_Y), Direction.NORTH, new Coordinates(0, 0)},

                {new Coordinates(0, 0), Direction.EAST, new Coordinates(1, 0)},
                {new Coordinates(1, 0), Direction.EAST, new Coordinates(2, 0)},
                {new Coordinates(1, 1), Direction.EAST, new Coordinates(2, 1)},
                {new Coordinates(Coordinates.MAX_X, 1), Direction.EAST, new Coordinates(0, 1)},

                {new Coordinates(0, 1), Direction.SOUTH, new Coordinates(0, 0)},
                {new Coordinates(0, 0), Direction.SOUTH, new Coordinates(0, Coordinates.MAX_Y)},
                {new Coordinates(1, 1), Direction.SOUTH, new Coordinates(1, 0)},

                {new Coordinates(0, 0), Direction.WEST, new Coordinates(Coordinates.MAX_X, 0)},
                {new Coordinates(1, 0), Direction.WEST, new Coordinates(0, 0)},
                {new Coordinates(1, 1), Direction.WEST, new Coordinates(0, 1)},
        });
    }

    public DirectionTest(Coordinates origin, Direction direction, Coordinates destination) {
        this.origin = origin;
        this.direction = direction;
        this.destination = destination;
    }

    @Test
    public void checkForward(){
        assertThat(direction.forward(origin),equalTo(destination));
    }

    @Test
    public void checkBackward(){
        assertThat(direction.backward(destination),equalTo(origin));
    }
}
