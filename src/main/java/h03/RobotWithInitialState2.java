package h03;

import fopbot.*;

public class RobotWithInitialState2 extends RobotWithInitialState {

  private int relativeNumberOfCoins;

  /**
   * Constructor of the class RobotWithinitialState
   *
   * @param x             = initial x-coordinate
   * @param y             = initial y-coordinate
   * @param direction     = initial direction
   * @param numberOfCoins = initial numberOfCoins
   */
  public RobotWithInitialState2(int x, int y, Direction direction, int numberOfCoins) {
    super(x, y, direction, numberOfCoins);
    this.relativeNumberOfCoins = 0;
  }

  @Override
  public void pickCoin() {
    super.pickCoin();
    relativeNumberOfCoins++;
  }

  @Override
  public void putCoin() {
    super.putCoin();
    relativeNumberOfCoins--;
  }

  @Override
  public int getRelativeNumberOfCoins() {
    return relativeNumberOfCoins;
  }
}
