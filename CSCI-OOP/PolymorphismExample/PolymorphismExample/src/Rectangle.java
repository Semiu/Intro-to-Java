
/**
 * Write a description of class Rectangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rectangle implements Shape
{
   private int width; //additional instance variable 
   private int length;
   
   public Rectangle(int l, int w)
   {
        length = l;
        width = w;
   }
   
   public int getLength()
   {
       return length;
   }
   
   public int getWidth()
   {
       return width;
   }
   
   //overriding the getArea() abstract method from Shape
   public double getArea( )
   {
        return length * width;
   }
   
   //overriding the getPerimeter() abstract method from Shape
   public double getPerimeter( )
   {
        return 2 * length + 2 * width;    
   }
   
   //overriding the toString()method inherited from Shape
   public String toString()
   {
        return "The length of the rectangle is : " + length 
                +  " and the width of the rectangle is : " + width;
   }
   
   //overriding equals() method from super class Shape
   public boolean equals(Object o)
   {
        if(!(o instanceof Rectangle))
            return false;
        else
        {
            Rectangle objRect = (Rectangle)o;
            
            if(this.length == objRect.length &&
                width == objRect.width)
                return true;
            else
                return false;
        }
   }
   
   
}
