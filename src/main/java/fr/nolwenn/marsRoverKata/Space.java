package fr.nolwenn.marsRoverKata;

public final class Space {
  private final Obstacle obstacle;

  public Space(Obstacle obstacle) {
    this.obstacle = obstacle;
  }

  public Obstacle getObstacle() {
    return obstacle;
  }
}
