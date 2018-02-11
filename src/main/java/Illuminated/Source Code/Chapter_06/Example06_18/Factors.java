/* Factors of integers
   with checks for primes
   Anderson, Franceschi
*/
import java.util.Scanner;

public class Factors
{
  public static void main( String [] args )
  {
    int number;           // positive integer entered by user
    final int SENTINEL = 0;
    boolean factorsFound; // flag signals whether factors are found

    Scanner scan = new Scanner( System.in );

    // priming read
    do
    {
      System.out.print( "Enter a positive integer "
                         + "or 0 to exit > " );
      number = scan.nextInt( );
    } while ( number < 0 );

    while ( number != SENTINEL )
    {
      System.out.print( "Factors of " + number + ":  " );
      factorsFound = false;  // reset flag to no factors

      for ( int factor = 2; factor <= number / 2; factor++ )
      {
        if ( number % factor == 0 )
        {
           System.out.print( factor + " " );
           factorsFound = true;
        }
      } // end of for loop

      if ( ! factorsFound )
          System.out.print( "none, " + number + " is prime" );

      System.out.println( );  // print a new line
      System.out.println( );  // skip a line

      // read next number
      do
      {
         System.out.print( "Enter a positive integer "
                            +  "or 0 to exit > " );
         number = scan.nextInt( );
      } while ( number < 0 );
    } // end of while loop
  }
}
