package org.softwerkskammer.kata.mars.rover;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class RotationTest {

    Direction origin;
    Direction destination;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {Direction.NORTH, Direction.EAST},
                {Direction.EAST, Direction.SOUTH},
                {Direction.SOUTH, Direction.WEST},
                {Direction.WEST, Direction.NORTH}
        });
    }

    public RotationTest(Direction origin, Direction destination) {
        this.origin = origin;
        this.destination = destination;
    }

    @Test
    public void turnRight() {
        assertThat("turn Right Test:" + origin + " -> " + destination, origin.turnRight(), equalTo(destination));
    }

    @Test
    public void turnLeft() {
        assertThat("turn Left Test:" + destination + " -> " + origin, destination.turnLeft(), equalTo(origin));
    }
}
