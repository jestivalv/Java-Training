/* Validate input is between 1 and 10
   Anderson, Franceschi
*/

import java.util.Scanner;

public class ValidateInput
{
  public static void main( String [] args )
  {
    int number;  // input value
    Scanner scan = new Scanner( System.in );

    do
    {
       System.out.print( "Enter a number between 1 and 10 > "  );
       number = scan.nextInt( );
    } while ( number < 1 || number > 10 );

    System.out.println( "Thank you!" );
  }
}
