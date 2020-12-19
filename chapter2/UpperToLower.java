//Chapter 2, programming exercise 2.7
/**
 * Write a program that converts an uppercase to a lowercase letter. The character is typed in the source 
 * code as a literal value. Chapter 9, "Strings and Text I/O" teaches how to enter character input.
 * Hint: In the ASCII table (see Appendix B), uppercase letters appear before lowercase letter from its corresponding uppercase letter as follows:
 * int offset = (int)'a' - (int)'A';
 * int unicodeForUppercase = (int)uppercase;
 * int unicodeForLowercase = unicodeForUppercase + offset;
 * char lowercase = (char)unicodeForLowercase;
 * @author Semiu
 *
 */
//import the scanner class for reading input from the console
import java.util.Scanner; 

public class UpperToLower {
	
	public static void main(String[] args) {
		
		//Create scanner object input
		Scanner input = new Scanner (System.in);
		
		//close the input stream of the Scanner class
		input.close();		
		
	}

}
