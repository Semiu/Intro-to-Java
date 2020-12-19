//Chapter 2, programming exercise 2.5
/**
 * Write a program that reads the subtotal and the gratuity rate, and computes the gratuity and total.
 * For example, if the user enters 10 for subtotal and 15% for gratuity rate, the program displays $1.5
 * as gratuity and $11.5 as total.
 * @author Semiu
 *
 */
//import the scanner class for reading input from the console
import java.util.Scanner; 

public class CalculateTips {
	
	public static void main(String[] args) {
		
		//Create scanner object input
		Scanner input = new Scanner (System.in);
		
		//Receive the input (subtotal) with a display message
		System.out.println("Enter the value of the subtotal: ");
		double subtotal = input.nextDouble();
		
		//Receive the input (gratuity rate) with a display message
		System.out.println("Enter the gratuity rate (the number only, e.g 15, not 15%): ");
		double rate = input.nextDouble();
		
		//Calculate the gratuity
		double gratuity = rate/100 * subtotal;
		
		//Calculate the total
		double total = gratuity + subtotal;
		
		//Display the pounds converted to kilogram
		System.out.println("$"+gratuity + " gratuity" + " and the total is $" +total);
		
		//close the input stream of the Scanner class
		input.close();		
		
	}

}
