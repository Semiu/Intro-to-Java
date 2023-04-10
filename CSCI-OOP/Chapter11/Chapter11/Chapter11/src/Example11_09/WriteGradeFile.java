package Example11_09;

/* Demonstrating how to write basic data types to a text file
    Anderson, Franceschi
 */

 import java.io.FileOutputStream;
 import java.io.PrintWriter;
 import java.io.FileNotFoundException;

 public class WriteGradeFile
 {
   public static void main( String [ ] args )
   {
     try
     {
       FileOutputStream fos = new FileOutputStream
               ( "grades.txt", false );
       // false means we will be writing to grades.txt,
       // rather than appending to it

       PrintWriter pw = new PrintWriter( fos );

       // write data to the file
       pw.print( "CS130: " );
       pw.println( 95 );
       pw.print( "Letter grade: " );
       pw.println( 'A' );
       pw.print( "Current GPA: " );
       pw.println( 3.68 );
       pw.print( "Successful student as of Spring semester: " );
       pw.println( true );

       // release the resources associated with grades.txt
       pw.close( );
     }

     catch ( FileNotFoundException fnfe )
     {
       System.out.println( "Unable to find grades.txt" );
     }
   }
}  
