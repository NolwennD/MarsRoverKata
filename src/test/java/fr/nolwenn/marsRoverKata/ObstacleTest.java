package fr.nolwenn.marsRoverKata;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ObstacleTest {

  @Test
  void squareContour() {
    var obstacle = new Obstacle(Position.of(5, 5), Position.of(4, 4));
    var contour =
        new HashSet<>(
            Arrays.asList(
                Position.of(5, 5), Position.of(5, 4), Position.of(4, 5), Position.of(4, 4)));
    assertTrue(contour.equals(obstacle.getContour()));
  }

  @Test
  void rectangleContour() {
    var obstacle = new Obstacle(Position.of(5, 5), Position.of(3, 4));
    Set<Position> contour = new HashSet<>();
    contour.add(Position.of(5, 5));
    contour.add(Position.of(5, 4));
    contour.add(Position.of(4, 5));
    contour.add(Position.of(4, 4));
    contour.add(Position.of(3, 4));
    contour.add(Position.of(3, 5));
    assertTrue(contour.equals(obstacle.getContour()));
  }
}
