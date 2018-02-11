/*  A demonstration of object reference assignment  
    Anderson, Franceschi
*/

public class ObjectReferenceAssignment
{
  public static void main( String [] args )
  {
     SimpleDate d1 = new SimpleDate( 2, 15, 2020 );
     System.out.println( "d1 is " + d1.getMonth( )
                         + "/" + d1.getDay( )
                         + "/" + d1.getYear( ) );

     SimpleDate d2 = new SimpleDate( 9, 28, 2021 );
     System.out.println( "d2 is "
                         + d2.getMonth( )
                         + "/" + d2.getDay( )
                         + "/" + d2.getYear( ) );

     d2 = d1;
     System.out.println( "\nAfter assigning d1 to d2:" );
     System.out.println( "d1 is " + d1.getMonth( )
                         + "/" + d1.getDay( )
                         + "/" + d1.getYear( ) );
     System.out.println( "d2 is " + d2.getMonth( )
                         + "/" + d2.getDay( )
                         + "/" + d2.getYear( ) );
  }
}
