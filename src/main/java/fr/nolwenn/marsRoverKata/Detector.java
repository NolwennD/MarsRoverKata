package fr.nolwenn.marsRoverKata;

import java.util.List;

public final class Detector {

  private final Space space;

  public Detector(Space space) {
    this.space = space;
  }

  public MoveSafety scan(Position position) {
    List<Obstacle> obstacles = space.getObstacle();
    for (var obstacle : obstacles) {
      if (obstacle.getContour().contains(position)) {
        return MoveSafety.UNSAFE;
      }
    }
    return MoveSafety.SAFE;
  }
}
