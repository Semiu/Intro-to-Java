
/**
 * Write a description of class Circle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Circle implements Shape
{
    private int radius;
    
    public Circle(int r)
    {
       if( r >= 0)
           radius = r;
    }
    
    public int getRadius()
    {
        return radius;
    }

    //overriding the getArea() abstract method from Shape
    public double getArea()
    {
        return Math.PI*Math.pow(radius, 2);
    }
    
    //overriding the getPerimter() abstract method from Shape
    public double getPerimeter()
    {
        return 2 * Math.PI * radius;
    }
    
    //overriding the toString()method from super class
    public String toString()
    {
        return "The radius of the circle is " + radius;
    }
    
     //overriding equals() method 
   public boolean equals(Object o)
   {
        if(!(o instanceof Circle))
            return false;
        else
        {
            Circle objCir = (Circle)o;
            
            if(this.radius == objCir.radius)
                return true;
            else
                return false;
        }
   }
   
}
