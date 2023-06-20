package h03;

import fopbot.*;

public class TwinRobots {

  private final Robot twin1;
  private final Robot twin2;
  private boolean firstTwinIsCurrent;

  /**
   * Constructor of the class TwinRobots
   */
  public TwinRobots() {
    this.twin1 = new Robot(0, 0, Direction.UP, 0);
    this.twin2 = new Robot(1, 1, Direction.RIGHT, 0);
    this.firstTwinIsCurrent = true;
  }

  /**
   * Methode to Negate the attribute firstTwinIsCurrent
   */
  public void toggleCurrentRobot() {
    firstTwinIsCurrent = !firstTwinIsCurrent;
  }

  /**
   * If the attribute firstTwinIsCurrent is true
   * @return twin1, otherwise twin2
   */
  public Robot getCurrentRobot() {
    return firstTwinIsCurrent ? twin1 : twin2;
  }
}
