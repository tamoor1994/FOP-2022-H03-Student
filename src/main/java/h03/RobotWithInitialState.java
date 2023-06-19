package h03;

import fopbot.*;

public class RobotWithInitialState extends Robot {

  private final int initialX;
  private final int initialY;
  private final Direction initialDirection;
  private final int initialNumberOfCoins;


  /**
   * Constructor of the class RobotWithinitialState
   * @param x               = initial x-coordinate
   * @param y               = initial y-coordinate
   * @param direction       = initial direction
   * @param numberOfCoins   = initial numberOfCoins
   */
  public RobotWithInitialState(int x, int y, Direction direction, int numberOfCoins) {
    super(x, y, direction, numberOfCoins);
    this.initialX = x;
    this.initialY = y;
    this.initialDirection = direction;
    this.initialNumberOfCoins = numberOfCoins;
  }

  /**
   * @return the initial x coordinate
   */
  public int getInitialX() {
    return initialX;
  }

  /**
   * @return the initial y coordinate
   */
  public int getInitialY() {
    return initialY;
  }

  /**
   * @return the initial direction
   */
  public Direction getInitialDirection() {
    return initialDirection;
  }

  /**
   * @return the initial numberOfCoins
   */
  public int getInitialNumberOfCoins() {
    return initialNumberOfCoins;
  }

  /**
   * calculate the x coodinate by subtracting initialX coodinate from the actual x coodinate
   * @return the relative x coordinate
   */
  public int getRelativeX() {
    return getX() - initialX;
  }

  /**
   * The relative y coordinate is calculated by subtracting the initial y-coordinate from the actual y-coordinate
   * @return the relative y-coordinate
   */
  public int getRelativeY() {
    return getY() - initialY;
  }

  /**
   * The relative Direction is UP, if initial and current Direction are equal;
   * RIGHT, if current Direction is 90° to the right from initial;
   * DOWN, if current is vis-à-vis from the initial Direction;
   * otherwise LEFT
   * @return the relative Direction
   */
  public Direction getRelativeDirection() {
    int result = (getDirection().ordinal() - initialDirection.ordinal() + 4) % 4;
    return Direction.values()[result];
  }

  /**
   *The relative numberOfCoins is calculated by subtracting the initial numberOfCoins from the current numberOfCoins
   * @return the relative number of coins
   */
  public int getRelativeNumberOfCoins() {
    return getNumberOfCoins() - initialNumberOfCoins;
  }

  /**
   * Set the x-Coordinate of Robot, so that a call of getRelativeX() directly afterwards returns relativeX.
   * Robot is only moved, if new x-Coordinate is inside the World
   */
  public void setRelativeX(int relativeX) {
    int newX = initialX + relativeX;
    if (newX < 0 || Main.WORLD_SIZE_X <= newX) {
      crash();
    } else {
      setX(newX);
    }
  }

  /**
   * Set the y-Coordinate of Robot, so that a call of getRelativeY() directly afterwards returns relativeY.
   * Robot is only moved, if new y-Coordinate is inside the World
   */
  public void setRelativeY(int relativeY) {
    int newY = initialY + relativeY;
    if (newY < 0 || newY >= Main.WORLD_SIZE_Y) {
      crash();
    } else {
      setY(newY);
    }
  }

  /**
   * Turn the Robot so, so that a call of getRelativeDirection() directly afterwards returns relativeDirection.
   */
  public void setRelativeDirection(Direction relativeDirection) {
    int newDirection = (initialDirection.ordinal() + relativeDirection.ordinal()) % 4;
    int numberOfTurns = 4 - (4 + newDirection - getDirection().ordinal()) % 4;
    for (int i = 0; i < numberOfTurns; i++) {
      turnLeft();
    }
  }

  /**
   * Put as many coins, so that a call of getRelativeNumberOfCoins() directly afterwards returns relativeNumberOfCoins.
   * But don't do it, if the new numberOfCoins is not in [0, currentNumberOfCoins]
   */
  public void setRelativeNumberOfCoins(int relativeNumberOfCoins) {
    int newNumberOfCoins = initialNumberOfCoins + relativeNumberOfCoins;
    if (newNumberOfCoins > getNumberOfCoins() || newNumberOfCoins < 0) {
      crash();
    } else {
      final int putCoins = getNumberOfCoins() - newNumberOfCoins;
      for (int i = 0; i < putCoins; i++) {
        putCoin();
      }
    }
  }
}
