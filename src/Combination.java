import java.util.Scanner;

/**
 * Calculate the combination of n and r.
 * Combination Formula: Combination = n!/r!(n-r)!
 * 
 * @author Supisara
 */
public class Combination {
	
	/**
	 * 
	 * @param n is a number that user insert.
	 * @param r is a number that user insert.
	 * @return a combination result.
	 */
	public static double combination( double n , double r ) {
		//TODO Rewrite this method to be more simple.
		double combination = 0, factorialN = 1, factorialR = 1, factorialMinus = 1;
		
		for ( int i = 1 ; i <= n ; i++ ) {
			factorialN = factorialN * i;
		}
		for ( int i = 1 ; i <= r ; i++ ) {
			factorialR = factorialR * i;
		}
		for ( int i = 1 ; i <= (n-r) ; i++ ) {
			factorialMinus = factorialMinus * i;
		}
	
		combination = factorialN / (factorialR * factorialMinus) ;
		return combination;
	}
	
	//TODO Write a extract method and replace the old code with a call to the method.
	//The example result:
	//Enter n: 5
	//Enter r: 3
	//Combination of (5,3) is 10
		
	/**
	 * Start the program.
	 * @param args not used
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		System.out.print("Enter n: ");
		double n = scan.nextDouble();
		System.out.print("Enter r: ");
		double r = scan.nextDouble();
		System.out.printf("Combination of (%.0f,%.0f) is %.0f" , n , r , combination(n,r));
	}
}

