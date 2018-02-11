/* Print a sentence backwards
   Anderson, Franceschi
*/
import java.util.Scanner;

public class Backwards
{
  public static void main( String [] args )
  {
    Scanner scan = new Scanner( System.in );
    
    String backwards = "";

    System.out.println( "Enter a sentence:" );
    String original = scan.nextLine( );

    for ( int i = original.length( ) - 1; i >= 0; i-- )
    {
        backwards += original.charAt( i );
    }

    System.out.println( "The sentence backwards is: \n" + backwards );
  }
}
