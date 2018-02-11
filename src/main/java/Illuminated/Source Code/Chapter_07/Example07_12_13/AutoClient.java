/* Auto Client, version 6
   Anderson, Franceschi
*/

public class AutoClient
{
   public static void main( String [] args )
   {
      Auto sporty = new Auto( "Spyder", 0, 0.0 );
      System.out.println( sporty.toString( ) );

      Auto compact = new Auto( "Accent", 0, 0.0 );
      System.out.println( );
      System.out.println( compact );

      if ( compact.equals( sporty ) )
        System.out.println( "\nsporty and compact are equal" );
      else
        System.out.println( "\nsporty and compact are not equal" );
   }
}
