package fr.nolwenn.marsRoverKata;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DetectorTest {

  @Test
  void shouldReturnUnsafeMoveWhenWillHitAnObstacle() {
    var space = new Space(new Obstacle(Position.of(5, 5), Position.of(3, 3)));
    var detector = new Detector(space);
    MoveSafety safety = detector.scan(Position.of(5, 5));
    assertEquals(MoveSafety.UNSAFE, safety);
  }

  @Test
  void shouldReturnSafeMoveWhenWillNotHitAnObstacle() {
    var space = new Space(new Obstacle(Position.of(5, 5), Position.of(3, 3)));
    var detector = new Detector(space);
    MoveSafety safety = detector.scan(Position.of(0, 0));
    assertEquals(MoveSafety.SAFE, safety);
  }

  @Test
  void shouldReturnEmptyObstacleForAnEmptySpace() {
    var space = new Space();
    var detector = new Detector(space);
    MoveSafety safety = detector.scan(Position.of(0, 0));
    assertEquals(MoveSafety.SAFE, safety);
  }
}
