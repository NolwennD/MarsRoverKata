package fr.nolwenn.marsRoverKata;

public final class Detector {
  public Detector() {}

  public Obstacle scan(Space space) {
    return space.getObstacle();
  }
}
