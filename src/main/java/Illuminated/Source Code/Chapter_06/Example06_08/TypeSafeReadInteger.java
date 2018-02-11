/* Type-Safe Input Using Scanner
    Anderson Franceschi
*/

import java.util.Scanner;

public class TypeSafeReadInteger
{
  public static void main( String [] args )
  {
      Scanner scan = new Scanner( System.in );

      System.out.print( "Enter your age as an integer > " );
      while ( ! scan.hasNextInt( ) )
      {
            String garbage = scan.nextLine( );
            System.out.print( "\nPlease enter an integer > " );
      }
      int age = scan.nextInt( );
      System.out.println( "Your age is " + age );
  }
}
