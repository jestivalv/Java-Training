/* A simple calculator
   Anderson, Franceschi
*/

import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculator
{
  public static void main( String [] args )
  {
    double fp1, fp2;
    String operation;

    Scanner scan = new Scanner( System.in );

    // set up the output format of the result
    DecimalFormat twoDecimals = new DecimalFormat( "#,###,###.##" );

    // print a welcome message
    System.out.println( "Welcome to the Calculator" );

    // read the two operands
    System.out.print( "Enter the first operand: " );
    fp1 = scan.nextDouble( );
    System.out.print( "Enter the second operand: " );
    fp2 = scan.nextDouble( );

    //  print a menu, then prompt for the operation
    System.out.println( "\nOperations are: "
                        + "\n\t ADD or + for addition"
                        + "\n\t SUBTRACT or - for subtraction"
                        + "\n\t MULTIPLY or * for multiplication"
                        + "\n\t DIVIDE or / for division" );
    System.out.print( "Enter your selection: " );
    operation = scan.next( );
    operation = operation.toUpperCase( );

    //perform the operation and print the result
    switch ( operation )
    {
     case "ADD":
	  case "+":
         System.out.println( "The sum is "
                 + twoDecimals.format( fp1 + fp2 ) );
         break;
     case "SUBTRACT":
	  case "-":
         System.out.println( "The difference is "
                 + twoDecimals.format( fp1 - fp2 ) );
         break;
     case "MULTIPLY":
	  case "*":
         System.out.println( "The product is "
                 + twoDecimals.format( fp1 * fp2 ) );
         break;
     case "DIVIDE":
	  case "/":
         if ( fp2 == 0.0 )
           System.out.println( "Dividing by 0 is not allowed" );
         else
           System.out.println( "The quotient is "
                   + twoDecimals.format( fp1 / fp2 ) );
         break;
     default:
         System.out.println( operation + " is not valid." );
   }
  }
}
