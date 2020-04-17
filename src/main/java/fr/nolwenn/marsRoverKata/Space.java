package fr.nolwenn.marsRoverKata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Space {
  private final List<Obstacle> obstacle = new ArrayList<>();

  public Space(Obstacle... obstacle) {
    this.obstacle.addAll(Arrays.asList(obstacle));
  }

  public List<Obstacle> getObstacle() {
    return obstacle;
  }
}
