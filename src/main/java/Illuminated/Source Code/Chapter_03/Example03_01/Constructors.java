/* A Demonstration of Using Constructors
   Anderson, Franceschi
*/

public class Constructors
{
   public static void main( String [] args )
   {
     SimpleDate independenceDay;
     independenceDay = new SimpleDate( 7, 4, 1776 );

     SimpleDate nextCentury = new SimpleDate( 1, 1, 2101 );

     SimpleDate defaultDate = new SimpleDate( );
   }
}
