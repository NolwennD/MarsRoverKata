package fr.nolwenn.marsRoverKata;

  public final class Rover {private final Position position;
  private final Heading heading;

  public Rover(Position position, Heading heading) {
    this.position = position;
    this.heading = heading;
  }

  public Rover moveForward() {
    int x = position.x();
    int y = position.y();
    var newPosition = switch (heading) {
      case EAST -> Position.of(x + 1, y);
      case NORTH -> Position.of(x, y + 1);
      case WEST -> Position.of(x - 1, y);
      case SOUTH -> Position.of(x, y - 1);
    };
    return new Rover(newPosition, heading);
  }

  public Position position() {
    return position;
  }

  public Rover turnLeft() {
    return new Rover(position, heading.turnLeft());
  }

  public Heading heading() {
    return heading;
  }

  public Rover moveBackward() {
    int x = position.x();
    int y = position.y();
    Position newPosition = switch (heading) {
        case EAST -> Position.of(x - 1, y);
        case NORTH -> Position.of(x, y - 1);
        case WEST -> Position.of(x + 1, y);
        case SOUTH -> Position.of(x, y + 1);
      };
    return new Rover(newPosition, heading);
  }

  public Rover turnRight() {
    return new Rover(position, heading.turnRight());
  }

  private Rover apply(Action action) {
    return switch (action) {
      case FORWARD -> moveForward();
      case BACKWARD -> moveBackward();
      case RIGHT -> turnRight();
      case LEFT -> turnLeft();
    };
  }

  public Rover commands(Action... actions) {
    var rover = this;
    for (Action current : actions) {
      rover = rover.apply(current);
    }
    return rover;
  }
}