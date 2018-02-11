/*  A demonstration of calling methods     
    Anderson, Franceschi
*/

public class Methods
{
  public static void main( String [] args )
  {
     SimpleDate independenceDay = new SimpleDate( 7, 4, 1776 );
     int independenceMonth = independenceDay.getMonth( );
     System.out.println( "Independence day is in month "
                         + independenceMonth );

     SimpleDate nextCentury = new SimpleDate( 1, 1, 2101 );
     System.out.println( "The day for nextCentury is "
                         + nextCentury.getDay( ) );

     nextCentury.setDay( 2 );
     System.out.println( "The revised day for nextCentury is "
                         + nextCentury.getDay( ) );

     SimpleDate programmersDay = new SimpleDate( 9, 12, 2009 );
     System.out.println( "The first Programmers Day was "
                         + programmersDay.getMonth( ) + '/'
                         + programmersDay.getDay( ) + '/'
                         + programmersDay.getYear( ) );

     programmersDay.nextDay( );
     System.out.println( "The actual date for Programmers Day is "
                         + programmersDay.getMonth( ) + '/'
                         + programmersDay.getDay( ) + '/'
                         + programmersDay.getYear( ) );
  }
}
