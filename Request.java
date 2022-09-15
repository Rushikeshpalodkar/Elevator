/**
 * The Request class is an object representation of a call to an elevator.
 */

public class Request {
  private int sourceFloor;
  private int destinationFloor;
  private int timeEntered;

  private int noOfFloors;

  Request(int noOfFloors) {
    this.noOfFloors = noOfFloors;

    int randomNumber = (int)Math.random();
    this.sourceFloor = (int)(Math.random() * (noOfFloors +1)- 1);
    randomNumber = (int)Math.random();
    this.destinationFloor = (int)(Math.random() * (noOfFloors +1) -1);
  }

  public int getSourceFloor() {
    return sourceFloor;
  }

  public void setSourceFloor(int sourceFloor) {
    this.sourceFloor = sourceFloor;
  }

  public int getDestinationFloor() {
    return destinationFloor;
  }

  public void setDestinationFloor(int destinationFloor) {
    this.destinationFloor = destinationFloor;
  }

  public int getTimeEntered() {
    return timeEntered;
  }

  public void setTimeEntered(int timeEntered) {
    this.timeEntered = timeEntered;
  }

  public int getNoOfFloors() {
    return noOfFloors;
  }
}
