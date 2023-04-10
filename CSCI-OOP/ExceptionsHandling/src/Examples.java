
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * @author Kotala
 */
public class Examples {

    public static void example01() {
        int a, b, c;
        System.out.println("example01: ");
        a = 5;
        b = 2;
        c = a / b;

        System.out.println("c = " + c);
    }

    public static void example02() {
        int a, b, c;
        System.out.println("example02: ");
        a = 5;
        b = 0;
        c = a / b;

        System.out.println("c = " + c);
    }

    public static void example03() {
        int a, b, c = 0;                                // Had to initialize c
        System.out.println("example03: ");
        a = 5;
        b = 0;
        try 
        {
            c = a / b;
        } catch (ArithmeticException ae) 
        {

        }
        System.out.println("c = " + c);
    }

    public static void example04() {
        int a, b, c;
        System.out.println("example04: ");
        a = 5;
        b = 0;
        try 
        {
            c = a / b;
            System.out.println("c = " + c);
        } 
        catch (ArithmeticException ae) 
        {
            System.out.println("Caught ArithemticExcpetion");
        }

        
    }

        public static void example05() {
        int a, b, c;
        System.out.println("example05: ");
        a = 5;
        b = 0;
        try {
            c = a / b;
            System.out.println("c = " + c);
        } catch (ArithmeticException ae) {
            System.out.println("Infomation returned by getMessage:");
            System.out.println( ae.getMessage() );
            System.out.println("Infomation returned by toString:");
            System.out.println( ae.toString() );
            System.out.println("Infomation returned by printStackTrace:");
            ae.printStackTrace();
        }        
    }

    public static void example06() {
        String inputa, inputb;
        int a, b, c;
        System.out.println("example06: ");
        
        inputa = "55";
        inputb = "11";
        
        a = Integer.parseInt( inputa );
        b = Integer.parseInt( inputb );
        try 
        {
            c = a / b;
            System.out.println("c = " + c);
        } 
        catch (ArithmeticException ae) 
        {
            System.out.println( "Exception is: " + ae.getMessage() );
        }
    }
    
    
    public static void example07() {
        String inputa, inputb;
        int a, b, c;
        System.out.println("example07: ");
        
        inputa = "55";
        inputb = "o";
        

        try 
        {
            a = Integer.parseInt( inputa );
            b = Integer.parseInt( inputb );
            
            c = a / b;
            System.out.println("c = " + c);
        } 
        catch (ArithmeticException ae) 
        {
            System.out.println( "Exception is: " + ae.getMessage() );
        }
    }        
    
    public static void example08() {
        String inputa, inputb;
        int a, b, c;
        System.out.println("example08: ");
        
        inputa = "55";
        inputb = "11";
        
        try 
        {
            a = Integer.parseInt( inputa );
            b = Integer.parseInt( inputb );
            
            c = a / b;
            System.out.println("c = " + c);
        } 
        catch ( ArithmeticException ae ) 
        {
            System.out.println( "Exception is: " + ae.getMessage() );
        }
        catch ( NumberFormatException exception2 )
        {
            System.out.println( "Exception is: " + exception2.getMessage() );
        }
    }            
    
        public static void example09() {
        String inputa, inputb;
        int a, b, c;
        System.out.println("example09: ");
        
        inputa = "55";
        inputb = "0";
        
        try 
        {
            a = Integer.parseInt( inputa );
            b = Integer.parseInt( inputb );
            
            c = a / b;
            System.out.println("c = " + c);
        } 
        catch ( ArithmeticException ae ) 
        {
            System.out.println( "Exception is: " + ae.getMessage() );
        }
        catch ( NumberFormatException exception2 )
        {
            System.out.println( "Exception is: " + exception2.getMessage() );
        }
    }                
        
        
    public static void example10() {
        
        System.out.println("example10: ");
        //Scanner inFile = new Scanner( new File( "dataFile.txt " ) );
    }  
    
    
    public static void example11() {
        
        System.out.println("example11: ");
        try
        {
            Scanner inFile = new Scanner( new File( "dataFile.txt " ) );
        }
        catch ( FileNotFoundException fnfe )
        {
            System.out.println( "Exception is: " + fnfe.getMessage() );        
        }
    }     
    
     public static void example12() {
        
        System.out.println("example12: ");
        
        //Scanner inFile = new Scanner( new File( "dataFile.txt " ) );
                  
    }        
    
    public static void example13() throws CantBeNegative {
        String inputa, inputb;
        int a, b, c;
        System.out.println("example13: ");
        
        inputa = "55";
        inputb = "11";
        
        try 
        {
            a = Integer.parseInt( inputa );
            b = Integer.parseInt( inputb );
            
            if ( a < 0 || b < 0 )
                throw new CantBeNegative( "Inputs can't be negative." );
            
            c = a / b;
            System.out.println("c = " + c);
        } 
        catch ( ArithmeticException ae ) 
        {
            System.out.println( "Exception is: " + ae.getMessage() );
        }
        catch ( NumberFormatException exception2 )
        {
            System.out.println( "Exception is: " + exception2.getMessage() );
        }
        catch ( CantBeNegative cbn )
        {
            System.out.println( "Exception is: " + cbn.getMessage() );
        }
    }                
    
}
