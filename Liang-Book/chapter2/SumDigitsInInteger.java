//Chapter 2, programming exercise 2.6
/**
 * Write a program than reads an integer between 0 and 1000 and adds all the digits in the integer. 
 * For example, if an integer is 932, the sum of all its digits is 14.
 * Hint: Use the % operator to extract digits, and use the / operator to remove the extracted digits.
 * For instance, 932 % 10 = 2, and 932/10 = 93.
 * @author Semiu
 *
 */
//import the scanner class for reading input from the console
import java.util.Scanner; 

public class SumDigitsInInteger {
	
	public static void main(String[] args) {
		
		//Create scanner object input
		Scanner input = new Scanner (System.in);
		System.out.println("Enter an integer value between 0 and 1000: ");
		
		//Assign the input to variable value
		int value = input.nextInt();
		
		//If it is two digit integer		
		if (value < 100) {
			
			//Get the first digit
			int first_digit = value % 10;
			
			//Get the other part of the value
			int sub_value_1 = value / 10;
			
			//Get the second digit
			int second_digit = sub_value_1 % 10;
			
			//Sum the digits
			int sumOfdigits = first_digit + second_digit;
			
			//Display sum of the digits
			System.out.println("Sum of the digits is: " +sumOfdigits);
			
		}
		else {
			//When it is three digit integer
			//Get the first digit
			int first_digit = value % 10;
			
			//Get the sub_value 1
			int sub_value_1 = value / 10;
			
			//Get the second digit
			int second_digit = sub_value_1 % 10;
			
			//Get the sub_value 2
			int sub_value_2 = sub_value_1 / 10;
					
			//Get the third digit
			int third_digit = sub_value_2 % 10;
			
			//Sum of the digits
			int sumOfdigits = first_digit + second_digit + third_digit;
			
			//Display sum of the digits
			System.out.println("Sum of the digits is: " +sumOfdigits);
		}
		//close the input stream of the Scanner class
		input.close();		
		
	}

}
