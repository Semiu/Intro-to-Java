/* Divider
*  Handling multiple exceptions
*  Anderson, Franceschi
*/

import javax.swing.JOptionPane;

public class Divider
{
  public static void main( String [] args )
  {
    // declare and initialize variables
    int divisor = 0;
    int quotient = 0;
    int dividend = 100;

    // initialize flag variable
    boolean goodInput = false;

    // prompt for input
    String s = JOptionPane.showInputDialog( null,
                             "Enter an integer divisor" );
    do
    {
      try
      {
        // attempt to convert the String to an int
        divisor = Integer.parseInt( s );

        // attempt the division
        quotient = dividend / divisor;

        goodInput = true;
      }
      catch ( NumberFormatException nfe )
      {
        s = JOptionPane.showInputDialog( null,
                             s + " is not an integer. "
                             + "Enter an integer divisor" );
      }
      catch ( ArithmeticException ae )
      {
        s = JOptionPane.showInputDialog( null,
                           "Divisor cannot be 0. "
                           + "Enter an integer divisor" );
      }
    } while ( !goodInput );

    JOptionPane.showMessageDialog( null,
                                  "The result is " + quotient );
  }
}
