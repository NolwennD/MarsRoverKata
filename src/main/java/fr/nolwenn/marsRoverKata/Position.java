package fr.nolwenn.marsRoverKata;

public final class Position {

  private final int x;
  private final int y;

  private Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * @param x
   * @param y
   * @return
   */
  public static Position of(int x, int y) {
    return new Position(x, y);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + x;
    result = prime * result + y;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Position)) {
      return false;
    }
    Position other = (Position) obj;
    if (x != other.x) {
      return false;
    }
    if (y != other.y) {
      return false;
    }
    return true;
  }

  public int x() {
    return x;
  }

  public int y() {
    return y;
  }

  @Override
  public String toString() {
    return "Position [x=" + x + ", y=" + y + "]";
  }
}
