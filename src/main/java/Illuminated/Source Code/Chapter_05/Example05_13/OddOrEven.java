/* Using the conditional operator
   Anderson, Franceschi
*/

import java.util.Scanner;

public class OddOrEven
{
  public static void main( String [] args  )
  {
    Scanner scan = new Scanner( System.in );

    System.out.print( "Enter an integer > " );
    int number = scan.nextInt( );
  
    String outcome = ( number % 2 == 0 ? "even." : "odd." );

    System.out.println( number + " is " + outcome );
           
  }
}