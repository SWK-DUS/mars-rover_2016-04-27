package org.softwerkskammer.kata.mars.rover;

import java.util.Arrays;
import java.util.Collection;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class RoverTest {

    @Test
    public void createRover(){
        Coordinates coordinate = new Coordinates(0,0);
        Direction direction = Direction.NORTH;

        Rover rover = new Rover(coordinate,direction);

        assertThat(rover,hasPosition(coordinate,Direction.NORTH));
    }

    @Test
    public void roverFacingNorth_movesForwards() {
        Coordinates coordinate = new Coordinates(0,0);
        Direction direction = Direction.NORTH;
        Rover rover = new Rover(coordinate,direction);

        rover.executeCommand(new char[]{'f'});

        assertThat(rover, hasPosition(new Coordinates(0, 1), Direction.NORTH));

    }


    @Test
    public void roverFacingNorth_movesBackwards() {
        Coordinates coordinate = new Coordinates(0,0);
        Direction direction = Direction.NORTH;
        Rover rover = new Rover(coordinate,direction);

        rover.executeCommand(new char[]{'b'});

        assertThat(rover, hasPosition(new Coordinates(0, Coordinates.MAX_Y), Direction.NORTH));
    }

    @Test
    public void roverFacingNorth_turnsLeft() {
        Coordinates coordinate = new Coordinates(0,0);
        Direction direction = Direction.NORTH;
        Rover rover = new Rover(coordinate,direction);

        rover.executeCommand(new char[]{'l'});

        assertThat(rover, hasPosition(new Coordinates(0, 0), Direction.WEST));
    }

    @Test
    public void roverFacingNorth_turnsRight() {
        Coordinates coordinate = new Coordinates(0,0);
        Direction direction = Direction.NORTH;
        Rover rover = new Rover(coordinate,direction);

        rover.executeCommand(new char[]{'r'});

        assertThat(rover, hasPosition(new Coordinates(0, 0), Direction.EAST));
    }

    @Test
    public void roverFacingNorth_doesNothing() {
        Coordinates coordinate = new Coordinates(0,0);
        Direction direction = Direction.NORTH;
        Rover rover = new Rover(coordinate,direction);

        rover.executeCommand(new char[]{'x'});

        assertThat(rover, hasPosition(coordinate, direction));
    }

    @Test
    public void roverFacingNorth_executesMultipleSteps() {
        Coordinates coordinate = new Coordinates(0,0);
        Direction direction = Direction.NORTH;
        Rover rover = new Rover(coordinate,direction);

        rover.executeCommand(new char[]{'f', 'f', 'r', 'b', 'l', 'l'});

        assertThat(rover, hasPosition(new Coordinates(Coordinates.MAX_X, 2), Direction.WEST));
    }

    private Matcher<Rover> hasPosition(final Coordinates coordinate, final Direction direction) {
        return new TypeSafeMatcher<Rover>() {

            @Override
            protected boolean matchesSafely(Rover rover) {
                return rover.position().equals(coordinate) && rover.direction().equals(direction);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Rover with ");
                description.appendValue(coordinate);
                description.appendText(" ");
                description.appendValue(direction);

            }
        };
    }

}
