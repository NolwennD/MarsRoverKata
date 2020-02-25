package fr.nolwenn.marsRoverKata;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import fr.nolwenn.marsRoverKata.Action;
import fr.nolwenn.marsRoverKata.Heading;
import fr.nolwenn.marsRoverKata.Position;
import fr.nolwenn.marsRoverKata.Rover;

class RoverTest {

  @Test
  void moveForwardWhenHeadingNorthfrom00ShouldGoTo01() {
    var position = Position.of(0, 0);
    var rover = new Rover(position, Heading.NORTH);
    assertEquals(Position.of(0, 1), rover.moveForward().position());
  }

  @Test
  void moveForwardWhenHeadingEastfrom00ShouldGoTo10() {
    var position = Position.of(0, 0);
    var rover = new Rover(position, Heading.EAST);
    assertEquals(Position.of(1, 0), rover.moveForward().position());
  }

  @Test
  void moveForwardWhenHeadingWesttfrom10ShouldGoTo00() {
    var position = Position.of(1, 0);
    var rover = new Rover(position, Heading.WEST);
    assertEquals(Position.of(0, 0), rover.moveForward().position());
  }

  @Test
  void moveForwardWhenHeadingSouthfrom01ShouldGoTo00() {
    var position = Position.of(0, 1);
    var rover = new Rover(position, Heading.SOUTH);
    assertEquals(Position.of(0, 0), rover.moveForward().position());
  }

  @Test
  void moveBackwardWhenHeadingNorthfrom01ShouldGoTo00() {
    var position = Position.of(0, 1);
    var rover = new Rover(position, Heading.NORTH);
    assertEquals(Position.of(0, 0), rover.moveBackward().position());
  }

  @Test
  void turnLeftWherHeadingNorthShouldHeadingWest() {
    var position = Position.of(0, 0);
    var rover = new Rover(position, Heading.NORTH);
    assertEquals(Heading.WEST, rover.turnLeft().heading());
  }

  @Test
  void shouldFollowCommands() {
    var position = Position.of(0, 0);
    var rover =
        new Rover(position, Heading.NORTH).commands(Action.LEFT, Action.FORWARD, Action.FORWARD);
    assertEquals(Heading.WEST, rover.heading());
    assertEquals(Position.of(-2, 0), rover.position());
  }

  @Test
  void shouldFollowOtherCommands() {
    var position = Position.of(0, 0);
    var rover =
        new Rover(position, Heading.NORTH).commands(Action.RIGHT, Action.BACKWARD, Action.BACKWARD);
    assertEquals(Heading.EAST, rover.heading());
    assertEquals(Position.of(-2, 0), rover.position());
  }

  @Test
  void shouldreveniraumemepoint() {
    var position = Position.of(0, 0);
    var rover =
        new Rover(position, Heading.NORTH)
            .commands(
                Action.RIGHT,
                Action.FORWARD,
                Action.RIGHT,
                Action.FORWARD,
                Action.RIGHT,
                Action.FORWARD,
                Action.RIGHT,
                Action.FORWARD);
    assertEquals(Heading.NORTH, rover.heading());
    assertEquals(position, rover.position());
  }

  @Test
  void shouldRoverReturnUnsafeMoveIfNextPositionHitAnObstacle() {
    var rover = new Rover(Position.of(1, 1), Heading.NORTH);
    assertEquals(Move.UNSAFE, rover.checkSafety());
  }

  @Test
  void shouldRoverReturnSafeMoveIfNextPositionNotHitAnObstacle() {
    var rover = new Rover(Position.of(1, 1), Heading.NORTH);
    assertEquals(Move.SAFE, rover.checkSafety());
  }
}
