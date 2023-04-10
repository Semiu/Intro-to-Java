import java.util.ArrayList;
import java.util.Random;

public class ShapeTest
{
    public static void main(String[] args)
    {
        //list to store various Shapes
        ArrayList<Shape> list = new ArrayList<Shape>();
        Random rand = new Random();
        
        //populating the list with different Shape objects.
        for(int i = 0 ; i < 10 ; i++)
        {
            int value = rand.nextInt(3);
            
            if(value == 0)
            {
                Shape s = new Square(rand.nextInt(10)+1);
                list.add(s);
            }
            else if (value == 1)
            {
                int l = rand.nextInt(20) + 5;
                int w = rand.nextInt(10) + 1;
                
                Shape s = new Rectangle(l , w);
                
                list.add(s);
            }
            else
            {
                Circle s = new Circle(rand.nextInt(10) + 1);
                list.add(s);
            }
            
        }
        
        //printing the contents of the list
        for(Shape s: list)
        {
            System.out.println(s);
            System.out.println("\tThe area is: " + s.getArea());
            System.out.println("\tThe perimeter is: " + s.getPerimeter()+ "\n");
            
        }
    }
    
}
