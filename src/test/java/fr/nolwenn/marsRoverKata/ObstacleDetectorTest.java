package fr.nolwenn.marsRoverKata;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import fr.nolwenn.marsRoverKata.Position;
import fr.nolwenn.marsRoverKata.Space;

class ObstacleDetectorTest {

  @Test
  void test() {
    var detector = new fr.nolwenn.marsRoverKata.Detector();
    var space =
        new Space(new fr.nolwenn.marsRoverKata.Obstacle(Position.of(5, 5), Position.of(3, 3)));
    var obstacle = new fr.nolwenn.marsRoverKata.Obstacle(Position.of(5, 5), Position.of(3, 3));
    assertEquals(obstacle.getContour(), detector.scan(space).getContour());
  }
}
