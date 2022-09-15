public class Simulator {

  // There will be one queue of requests for the simulation

  // A single time unit represents the amount of time it takes for the elevator to move up or down one floor.

  // At the beginning of each time unit, there is a random chance that a new request will be placed by a passenger.
  // Randomly generated source and destination floors.

  ///// EDGE CASES
  // If the source floor is reached, the elevator will begin heading towards the destination
  // floor on the next time unit.

  // If the destination floor is reached, the elevator will then be marked as idle (on the next
  // time step, it can handle a new request).

  // If an elevator just begins handling a request on the current time unit and if it was already
  // on the source floor, it may begin moving towards the destination on the current time step.

  // If an elevator is on the source floor and if the source floor is also the destination floor, the elevator may be set to idle


  /////// END

  //  task is to calculate the average waiting time for requests.
  // Wait time is defined as the number of time units that pass from when a request is placed on the queue until the elevator picks up the passenger


  //Adding the amount of waiting time for a request to the waiting sum and increment the request count as each request has its elevator reach its source floor.


  // all requests that have not had an assigned elevator are ignored
  // reach its source floor.


    private static int moveElevatorTo(int current, int destination) {
        System.out.println("moving from: "+ current + " to:" + destination );
//        waitTime[]++
        if(destination <= 1){

            return current++;
        } else if (destination > current) {
            System.out.println("going upto");

            return ++current;
        } else if( destination < current) {
            System.out.println("going down");
            return --current;
        } else {
            return current;
        }
    }
   public static void simulate(double probability, int noOfFloors, int noOfElevators,
                               int simLength) {
       int time = 0;
       int waitTime[] = new int[noOfElevators];
       //int waitTime;
       int waitSum = 0;
       int requestCount = 1;
       double avgWaitTime;
    boolean debug = true;





     if ( probability < 0.0 || probability > 1.0) {
       throw new IllegalArgumentException("Probability has to be between 0 and 1");
     }

     if ( noOfFloors <= 1) {
       throw new IllegalArgumentException("There has to be at least 2 floors");
     }

     if (noOfElevators <= 0) {
       throw new IllegalArgumentException("There has to be at least 1 elevator");
     }

     if (simLength <= 0) {
       throw new IllegalArgumentException("Simulation has to run for at least one second");
     }
     Elevator[] elevators = new Elevator[noOfElevators];
     Elevator elevator;
     for (int i =0; i < noOfElevators; i++) {
       elevator = new Elevator();
       elevators[i] = elevator;
     }
     BooleanSource source = new BooleanSource(probability);
     RequestQueue requestQueue = new RequestQueue();
     Request newRequest;



     if (debug)
       System.out.println("The simulation length is: "+ simLength);
     while (time < simLength) {
         time++;
       System.out.println("Time :" + time);
       if(source.RequestArrived()) {
         if (debug)
           System.out.println("New Request at: " + time);
         newRequest = new Request(noOfFloors);
         newRequest.setTimeEntered(time);
         requestQueue.enqueue(newRequest);
         //Should we increase time ?????

       }
       if(!requestQueue.isEmpty()) {
         for (int i =0; i < noOfElevators; i++) {
           elevator = elevators[i];
           if (elevator.getElevatorState() == Elevator.IDLE) {
             if (debug)
               System.out.println("Elevator selected is: " + i);
             elevator.setCurrentRequest(requestQueue.dequeue());
             /**
               **/

             elevator.setElevatorState(Elevator.TO_SOURCE);
             if (debug) {
               System.out.println("Request: "+requestCount);
               System.out.println("Req Time: " + elevator.getCurrentRequest().getTimeEntered());
               System.out.println("Source Floor: " + elevator.getCurrentRequest().getSourceFloor());
               System.out.println("Destination Floor: " + elevator.getCurrentRequest().getDestinationFloor());
             }
             requestCount++;

             waitTime[i] = time - elevator.getCurrentRequest().getTimeEntered();//get the time when person went into queue

             System.out.println("current time  "+time +" elevator.getCurrentRequest().getTimeEntered()  "+elevator.getCurrentRequest().getTimeEntered());
             break;
           }
         }
       }
       for(int i=0; i< noOfElevators; i++) {
         elevator = elevators[i];
         if(elevator.getElevatorState() == Elevator.TO_SOURCE) {
           if (elevator.getCurrentFloor() == elevator.getCurrentRequest().getSourceFloor()) {
             if (debug) {
               System.out.println("Wait time for this elevator was:"+waitTime[i]);
             }

             waitSum += waitTime[i];
               System.out.println("current wait time  " +waitSum);
             waitTime[i] = 0;
             requestCount++;
             elevator.setElevatorState(Elevator.TO_DESTINATION);
           }
           elevator.setCurrentFloor(moveElevatorTo(elevator.getCurrentFloor(),
                   elevator.getCurrentRequest().getSourceFloor()));
         }

         if(elevator.getElevatorState() == Elevator.TO_DESTINATION) {
           if (elevator.getCurrentFloor() == elevator.getCurrentRequest().getDestinationFloor()) {

             elevator.setElevatorState(Elevator.IDLE);
           }
           elevator.setCurrentFloor(moveElevatorTo(elevator.getCurrentFloor(),
                   elevator.getCurrentRequest().getDestinationFloor()));
          // elevators[i] = elevator;
           if (elevator.getCurrentFloor() == elevator.getCurrentRequest().getDestinationFloor()) {

             elevator.setElevatorState(Elevator.IDLE);
           }
         }
       }

       // check if non idle elevators reached and move/set to idle
       // if reached source, add waittime[elev_index] to waitsum, requestCount++,
       // waittime[elev_index] = 0;
       // esp if source == destination, idle
     }
     if(requestCount == 0 ){
         System.out.println("Request count is zero");
     }else {
         avgWaitTime = waitSum / requestCount;
         System.out.println("Total wait time :" + waitSum);
         System.out.println("Total no of requests: " + requestCount);
         System.out.println("Average wait time: " + avgWaitTime);
     }
     // print avg wait time is waitsum/totalrequests;
   }




  // Questions

  // How are we tracking time?
  // Where is the Queue?
  // Where are the elevators?
}
