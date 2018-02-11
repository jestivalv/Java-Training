/* Auto Client, version 7
   Anderson, Franceschi
*/

public class AutoClient
{
   public static void main( String [] args )
   {
      System.out.println( "Before instantiating an Auto object:"
                          + "\nthe count of Auto objects is "
                          + Auto.getCountAutos( ) );

      Auto sporty = new Auto( "Spyder", 0, 0.0 );

      System.out.println( "\nAfter instantiating an Auto object:"
                          + "\nthe count of Auto objects is "
                          + Auto.getCountAutos( ) );
   }
}
