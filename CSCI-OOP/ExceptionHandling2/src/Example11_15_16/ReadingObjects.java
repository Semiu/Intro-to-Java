package Example11_15_16;

/* Demonstrating how to read objects from a file
   Anderson, Franceschi
*/

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.IOException;

public class ReadingObjects
{
  public static void main( String [] args )
  {
   try
   {
     FileInputStream fis = new FileInputStream( "objects " );
     ObjectInputStream ois = new ObjectInputStream( fis );

     try
     {
       while ( true )
       {
         // read object, type cast returned object to FlightRecord
         FlightRecord2 temp = ( FlightRecord2 ) ois.readObject( );

         // print the FlightRecord1 object read
         System.out.println( temp );
       }
     } // end inner try block

     catch( EOFException eofe )
     {
      System.out.println( "End of the file reached" );
     }

     catch( ClassNotFoundException cnfe )
     {
      System.out.println( cnfe.getMessage( ) );
     }

     finally
     {
       System.out.println( "Closing file" );
       ois.close( );
     }
   } // end outer try block

   catch( FileNotFoundException fnfe )
   {
      System.out.println( "Unable to find objects" );
   }

   catch( IOException ioe )
   {
       ioe.printStackTrace( );
   }
 }
}
