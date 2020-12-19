//Chapter 2, programming exercise 2.4
/**
 * Write a program that converts pounds to kilograms. The program prompts the user to enter a number in pounds,
 * converts it and displays the result.
 * Hint: One pound is 0.454 kilograms.
 * @author Semiu
 *
 */
//import the scanner class for reading input from the console
import java.util.Scanner; 

public class PoundsToKg {
	public static void main(String[] args) {
		
		//Create scanner object input
		Scanner input = new Scanner (System.in);
		
		//Receive the input (pounds) with a display message
		System.out.println("Enter the weight in pounds: ");
		double pounds = input.nextDouble();
		
		//Convert the pounds to kilograms
		double kg = pounds * 0.454;
	
		
		//Display the pounds converted to kilogram
		System.out.println(pounds+"pounds is "+ kg+"kg");
		
		//close the input stream of the Scanner class
		input.close();		
		
	}

}
