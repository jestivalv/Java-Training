/* Using BigDecimal to compute precise decimal numbers
   Anderson, Franceschi
*/
import java.math.BigDecimal;

public class UsingBigDecimal
{
  public static void main( String [] args )
  {
    BigDecimal d1 = new BigDecimal( "0.0"  );
    BigDecimal pointOne = new BigDecimal( "0.1" );

    // Compute 11 * .1 two ways
    // add .1 to d1 eleven times
    d1 = d1.add( pointOne ); // 1
    d1 = d1.add( pointOne ); // 2
    d1 = d1.add( pointOne ); // 3
    d1 = d1.add( pointOne ); // 4
    d1 = d1.add( pointOne ); // 5
    d1 = d1.add( pointOne ); // 6
    d1 = d1.add( pointOne ); // 7
    d1 = d1.add( pointOne ); // 8
    d1 = d1.add( pointOne ); // 9
    d1 = d1.add( pointOne ); // 10
    d1 = d1.add( pointOne ); // 11

    // multiply .1 * 11
    BigDecimal  d2 = new BigDecimal( "0.1" );
    BigDecimal  eleven = new BigDecimal( "11" );
    d2 = d2.multiply( eleven );

    System.out.println( "d1 = " + d1 );
    System.out.println( "d2 = " + d2 );
    if ( d1.compareTo( d2 ) == 0 )
       System.out.println( "d1 and d2 are equal" );
    else
       System.out.println( "d1 and d2 are not equal" );
 }
}
