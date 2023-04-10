//Chapter 2, programming exercise 2.1
/**
 * Write a program that reads a Celsius degree in double  from the console, then converts 
 * it to Fahrenheit and displays the result. 
 * The conversion formula is: fahrenheit = (9/5) * celsius + 32
 * Because of type restriction in Java, use 9.0/5 for correct answer
 * @author Semiu
 *
 */
//import the scanner class for reading input from the console
import java.util.Scanner; 
public class CelsiusToF {
	public static void main(String[] args) {
		
		//Create scanner object input
		Scanner input = new Scanner (System.in);
		
		//Receive the input with a display message
		System.out.println("Enter the temperature in degree celsius: ");
		double tempInCelsius = input.nextDouble();
		
		//Convert the temperature taken
		double tempInFahreheit = (9.0/5) * tempInCelsius + 32;
		
		//Display the converted temperature
		System.out.println(tempInCelsius + "C" + " is " +tempInFahreheit+ "F");
		
		input.close();		
		
	}

}
