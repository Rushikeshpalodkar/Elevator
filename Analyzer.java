
import java.util.Scanner;

public class Analyzer {

    public static void main(String[] args) {
//       Simulator.simulate(0.3,10,2,11);

        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the Elevator simulator!");

        System.out.println("Please enter the probability of arrival for Requests");
        double probability = s.nextDouble();

        System.out.println("Please enter the number of floors: ");
        int numberOfFloor = s.nextInt();

        System.out.println("Please enter the number of elevators: ");
        int numberOfElevators = s.nextInt();

        System.out.println("Please enter the length of the simulation (in time units):");
        int time = s.nextInt();

        Simulator.simulate(probability,numberOfFloor,numberOfElevators,time);



    }
}
