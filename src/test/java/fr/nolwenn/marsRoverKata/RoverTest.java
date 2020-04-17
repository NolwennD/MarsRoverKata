package fr.nolwenn.marsRoverKata;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RoverTest {

  @Test
  void moveForwardWhenHeadingNorthfrom00ShouldGoTo01() {
    var position = Position.of(0, 0);
    var rover = new Rover(position, Heading.NORTH, new Space());
    assertEquals(Position.of(0, 1), rover.moveForward().position());
  }

  @Test
  void moveForwardWhenHeadingEastfrom00ShouldGoTo10() {
    var position = Position.of(0, 0);
    var rover = new Rover(position, Heading.EAST, new Space());
    assertEquals(Position.of(1, 0), rover.moveForward().position());
  }

  @Test
  void moveForwardWhenHeadingWesttfrom10ShouldGoTo00() {
    var position = Position.of(1, 0);
    var rover = new Rover(position, Heading.WEST, new Space());
    assertEquals(Position.of(0, 0), rover.moveForward().position());
  }

  @Test
  void moveForwardWhenHeadingSouthfrom01ShouldGoTo00() {
    var position = Position.of(0, 1);
    var rover = new Rover(position, Heading.SOUTH, new Space());
    assertEquals(Position.of(0, 0), rover.moveForward().position());
  }

  @Test
  void moveBackwardWhenHeadingNorthfrom01ShouldGoTo00() {
    var position = Position.of(0, 1);
    var rover = new Rover(position, Heading.NORTH, new Space());
    assertEquals(Position.of(0, 0), rover.moveBackward().position());
  }

  @Test
  void turnLeftWherHeadingNorthShouldHeadingWest() {
    var position = Position.of(0, 0);
    var rover = new Rover(position, Heading.NORTH, new Space());
    assertEquals(Heading.WEST, rover.turnLeft().heading());
  }

  @Test
  void shouldFollowCommands() {
    var position = Position.of(0, 0);
    var rover =
        new Rover(position, Heading.NORTH, new Space())
            .commands(Action.LEFT, Action.FORWARD, Action.FORWARD);
    assertEquals(Heading.WEST, rover.heading());
    assertEquals(Position.of(-2, 0), rover.position());
  }

  @Test
  void shouldFollowOtherCommands() {
    var position = Position.of(0, 0);
    var rover =
        new Rover(position, Heading.NORTH, new Space())
            .commands(Action.RIGHT, Action.BACKWARD, Action.BACKWARD);
    assertEquals(Heading.EAST, rover.heading());
    assertEquals(Position.of(-2, 0), rover.position());
  }

  @Test
  void shouldreveniraumemepoint() {
    var position = Position.of(0, 0);
    var rover =
        new Rover(position, Heading.NORTH, new Space())
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
  void shouldRoverMoveToNextPositionWhenWillNotHitAnObstacle() {
    Obstacle obstacle = new Obstacle(Position.of(2, 2), Position.of(4, 4));
    Space space = new Space(obstacle);
    var rover = new Rover(Position.of(1, 1), Heading.NORTH, space);
    Rover rover2 = rover.moveForward();
    assertEquals(Position.of(1, 2), rover2.position());
  }

  @Test
  void roverShouldStayOnSamePositionWhenWhillHitAnObstacle() {
    Obstacle obstacle = new Obstacle(Position.of(1, 2), Position.of(4, 4));
    Space space = new Space(obstacle);
    var rover = new Rover(Position.of(1, 1), Heading.NORTH, space);
    Rover rover2 = rover.moveForward();
    assertEquals(Position.of(1, 1), rover2.position());
  }

  @Test
  void roverShouldStayOnTheSecondPositionWhenWhillHitAnObstacle() {
    Obstacle obstacle = new Obstacle(Position.of(1, 2), Position.of(4, 4));
    Space space = new Space(obstacle);
    var rover = new Rover(Position.of(1, 0), Heading.NORTH, space);
    Rover rover2 = rover.moveForward().moveForward();
    assertEquals(Position.of(1, 1), rover2.position());
  }

  @Test
  void roverShouldStayOnSamePositionWhenMoveBackwardWhillHitAnObstacle() {
    Obstacle obstacle = new Obstacle(Position.of(1, 2), Position.of(4, 4));
    Space space = new Space(obstacle);
    var rover = new Rover(Position.of(4, 5), Heading.NORTH, space);
    Rover rover2 = rover.moveBackward();
    assertEquals(Position.of(4, 5), rover2.position());
  }
}
