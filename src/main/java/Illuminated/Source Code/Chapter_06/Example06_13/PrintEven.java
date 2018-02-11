/* Print the even numbers from zero to twenty
   Anderson, Franceschi
*/

public class PrintEven
{
  public static void main( String [] args )
  {
    String toPrint = "";  // initialize output String

    for ( int i = 0; i <= 20; i += 2 )
    {
       toPrint += i + " "; // append current number and a space
    }

    System.out.println( toPrint ); // print results
  }
}
