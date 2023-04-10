
public class Main1 {
	
	public static void main (String[] args) {
		
		double length;
		double breadth;
		
		length = 6;
		breadth = 4;
		
		Rectangle1 Rec1 = new Rectangle1();
		Rec1.setLength(length);
		Rec1.setBreadth(breadth);
		Rec1.getBreadth();
		Rec1.getLength();
		
		System.out.println("The area of the rectangle, based on Rectangle 1, is " + Rec1.computeArea(length, breadth));
		
		System.out.println("The perimeter of the rectangle, based on Rectangle 1, is " + Rec1.computePerimeter(length, breadth));
		
		
		Square1 Squ1 = new Square1();
		//Squ1.setLength(length);
		//Squ1.getLength();
		
		System.out.println("The area of the square, based on Square 1, is " + Squ1.computeArea(length));
		
		System.out.println("The perimeter of the square, based on Square 1, is " + Squ1.computePerimeter(length));
		
		//
		Square2 Squ2 = new Square2();
		Squ2.setLength(length);
		Squ2.getLength();
		
		System.out.println("The area of the square, based on Square 2, is " + Squ2.computeArea(length));
		
		System.out.println("The perimeter of the square, based on Square 2, is " + Squ2.computePerimeter(length));
		
		Rectangle2 Rec2 = new Rectangle2();
		Rec2.setLength(length);
		Rec2.setBreadth(breadth);
		Rec2.getBreadth();
		Rec2.getLength();
		
		System.out.println("The area of the rectangle, based on Rectangle 2, is " + Rec2.computeArea(length, breadth));
		
		System.out.println("The perimeter of the rectangle, based on Rectangle 2, is " + Rec2.computePerimeter(length, breadth));
		
	}

}
