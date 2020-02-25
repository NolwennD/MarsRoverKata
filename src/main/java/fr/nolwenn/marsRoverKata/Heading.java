package fr.nolwenn.marsRoverKata;

public enum Heading {
  NORTH {

    @Override
    Heading turnLeft() {
      return WEST;
    }

    @Override
    Heading turnRight() {
      return EAST;
    }
  },
  EAST {

    @Override
    Heading turnLeft() {
      return NORTH;
    }

    @Override
    Heading turnRight() {
      return SOUTH;
    }
  },
  SOUTH {

    @Override
    Heading turnLeft() {
      return EAST;
    }

    @Override
    Heading turnRight() {
      return WEST;
    }
  },
  WEST {

    @Override
    Heading turnLeft() {
      return SOUTH;
    }

    @Override
    Heading turnRight() {
      return NORTH;
    }
  };

  abstract Heading turnLeft();

  abstract Heading turnRight();
}
