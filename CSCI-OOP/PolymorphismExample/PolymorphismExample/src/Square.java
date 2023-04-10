
/**
 * Write a description of class Square here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Square implements Shape
{
   private int length;
   
   public Square(int l)
   {
       length = l;
        
   }
   
   public int getLength()
   {
       return length;
   }
   
   //overriding the getArea() abstract method  from Shape
   public double getArea()
   {
        return length * length;    
   }
   
   //overriding the getPerimeter() abstract method from Shape
   public double getPerimeter( )
   {
        return 4 * length;    
   }
   
   //overriding the toString() method inherited from Shape
   public String toString()
   {
        return "The length of a side of the square is " + length;    
   }
   
   //overriding equals() method from super class Shape
   public boolean equals(Object o)
   {
        if(!(o instanceof Square))
            return false;
        else
        {
            Square objSqu = (Square)o;
            
            if(this.length == objSqu.length)
                return true;
            else
                return false;
        }
   }
   
   
   
}
