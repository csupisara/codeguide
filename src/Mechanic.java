/**
 * This class will printing out the process of building and deliver a car.
 * @author Supisara
 */
public class Mechanic {
	
	/**
	 * Printing the process of the car.
	 */
	public static void buildCar() {
		System.out.println("Buying equipment");
		System.out.println("Build a car");
		System.out.println("Recieve order");
		System.out.println("Deliver...");
	}

	/**
	 * Printing the process of the bike.
	 */
	public static void buildBike() {
		System.out.println("Buying equipment");
		System.out.println("Build a bike");
		System.out.println("Recieve order");
		System.out.println("Deliver...");
	}

	/**
	 * Printing the process of the bus.
	 */
	public static void buildBus() {
		System.out.println("Buying equipment");
		System.out.println("Build a bus");
		System.out.println("Recieve order");
		System.out.println("Deliver...");
	}
	
	//TODO Rewrite the code. No duplicate logic.
	//You might create a new method or variables.
	
	/**
	 * Start the program.
	 * @param args not used
	 */
	public static void main(String[] args) {
		buildCar();
		buildBike();
		buildBus();
	}
}
