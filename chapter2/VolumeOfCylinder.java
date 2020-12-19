//Chapter 2, programming exercise 2.2
/**
 * Write a program that reads in the radius and length of a cylinder and computes volume using:
 * area = radius * radius * pi
 * volume = area * length
 * where pi is a constant of value 3.142
 * @author Semiu
 *
 */
//import the scanner class for reading input from the console
import java.util.Scanner; 
public class VolumeOfCylinder {

	public static void main(String[] args) {
		
		//Create scanner object input
		Scanner input = new Scanner (System.in);
		
		//Receive the input (radius) with a display message
		System.out.println("Enter the value of the radius: ");
		double radius = input.nextDouble();
		
		//Receive the input (radius) with a display message
		System.out.println("Enter the value of the length: ");
		double length = input.nextDouble();
		
		//Assign the value of the constant PI
		final double PI = 3.142;
		
		//Calculate the area
		double area = radius * radius * PI;
		
		//Calculate the volume
		double volume = area * length;
		
		//Display the calculated volume to nearest whole number (cast to int)
		System.out.println("The volume of the cylinder is: " + (int)volume);
		
		input.close();		
		
	}

}
