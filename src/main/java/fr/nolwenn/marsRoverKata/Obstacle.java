package fr.nolwenn.marsRoverKata;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Obstacle {

  private final Position topLeft;
  private final Position bottomRight;

  public Obstacle(Position topLeft, Position bottomRight) {
    this.topLeft = topLeft;
    this.bottomRight = bottomRight;
  }

  public Set<Position> getContour() {
    int xMin = Math.min(topLeft.x(), bottomRight.x());
    int xMax = Math.max(topLeft.x(), bottomRight.x());
    int yMin = Math.min(topLeft.y(), bottomRight.y());
    int yMax = Math.max(topLeft.y(), bottomRight.y());
    Set<Position> contour = new HashSet<>();
    IntStream.range(xMin + 1, xMax)
        .boxed()
        .forEach(
            e -> {
              contour.add(Position.of(e, yMin));
              contour.add(Position.of(e, yMax));
            });
    IntStream.rangeClosed(yMin, yMax)
        .boxed()
        .forEach(
            e -> {
              contour.add(Position.of(xMax, e));
              contour.add(Position.of(xMin, e));
            });
    return contour;
  }
}
