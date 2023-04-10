
public class Main1 {
	
	public static void main (String[] args) {
		
		
	
		double length1;
		double breadth1;
		
		length1 = 6;
		breadth1 = 4;
		
		//Scenario 1
		Rectangle1 Rec1 = new Rectangle1();
		Rec1.setLength(length1);
		Rec1.setBreadth(breadth1);
		Rec1.getBreadth();
		Rec1.getLength();
		
		System.out.println("The area of the rectangle, based on Rectangle 1, is " + Rec1.computeArea(length1, breadth1));
		
		System.out.println("The perimeter of the rectangle, based on Rectangle 1, is " + Rec1.computePerimeter(length1, breadth1));
		
		
		Square1 Squ1 = new Square1();
		//Squ1.setLength(length1);
		//Squ1.getLength();
		
		System.out.println("The area of the square, based on Square 1, is " + Squ1.computeArea(length1));
		
		System.out.println("The perimeter of the square, based on Square 1, is " + Squ1.computePerimeter(length1));
		
		//Scenario 2
		double length2;
		double breadth2;
		
		length2 = 8;
		breadth2 = 2;
		
		Square2 Squ2 = new Square2();
		Squ2.setLength(length2);
		Squ2.getLength();
		
		System.out.println("The area of the square, based on Square 2, is " + Squ2.computeArea(length2));
		
		System.out.println("The perimeter of the square, based on Square 2, is " + Squ2.computePerimeter(length2));
	
		Rectangle2 Rec2 = new Rectangle2();
		Rec2.setLength(length2);
		Rec2.setBreadth(breadth2);
		Rec2.getBreadth();
		Rec2.getLength();
		
		System.out.println("The area of the rectangle, based on Rectangle 2, is " + Rec2.computeArea(length2, breadth2));
		
		System.out.println("The perimeter of the rectangle, based on Rectangle 2, is " + Rec2.computePerimeter(length2, breadth2));
		
	}

}
