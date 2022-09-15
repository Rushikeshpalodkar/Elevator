/**
 * Rushikesh Palodkar
 * 113808719
 * Class Elevator
 */

public class Elevator {

  private int currentFloor;// TO Store The floor on which the elevator is at this point.

  private int elevatorState; // To know current state of elevator
  public final static Integer IDLE = 1;
  public final static Integer TO_SOURCE = 2;
  public final static Integer TO_DESTINATION = 3;

  private Request currentRequest;

  public Elevator() { //Empty constructor
    currentRequest = null;
    elevatorState = IDLE;
    currentFloor = 1;
  }

  public int getCurrentFloor() {
    return currentFloor;
  }

  public void setCurrentFloor(int currentFloor) {
    if(currentFloor < 1 ) {
      throw new IllegalArgumentException("Floors cannot be negative");
    }

    this.currentFloor = currentFloor;
  }

  public Request getCurrentRequest() {
    return currentRequest;
  }

  public void setCurrentRequest(Request currentRequest) {
    this.currentRequest = currentRequest;
  }

  public int getElevatorState() {
    return elevatorState;
  }

  public void setElevatorState(int elevatorState) {
    this.elevatorState = elevatorState;
  }
}
