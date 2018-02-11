/* Find the total of 5 numbers
   Anderson, Franceschi
*/

import java.util.Scanner;

public class Sum5Numbers
{
  public static void main( String [] args )
  {
    int total = 0;  // stores the sum of the 5 numbers
    int number;     // stores the current input

    Scanner scan = new Scanner( System.in );

    for ( int i = 1; i <= 5; i++ )
    {
      System.out.print( "Enter an integer > " );
      number = scan.nextInt( );

      total += number;  // add input to total
    }

    // process results by printing the total
    System.out.println( "The total is " + total );
  }
}
