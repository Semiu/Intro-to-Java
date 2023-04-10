//Chapter 2, programming exercise 2.3
/**
 * Write a program that reads a number in feet, converts it to meters and displays the result.
 * One foot is 0.305meters
 * @author Semiu
 *
 */
//import the scanner class for reading input from the console
import java.util.Scanner; 

public class FeetToMeters {
	public static void main(String[] args) {
		
		//Create scanner object input
		Scanner input = new Scanner (System.in);
		
		//Receive the input (radius) with a display message
		System.out.println("Enter the value in feet: ");
		double feet = input.nextDouble();
		
		//Convert the feet to meters
		double meters = feet * 0.305;
	
		
		//Display the feet converted to meters
		System.out.println( feet+"feet is "+ meters+"meters");
		
		//close the input stream of the Scanner class
		input.close();		
		
	}

}
