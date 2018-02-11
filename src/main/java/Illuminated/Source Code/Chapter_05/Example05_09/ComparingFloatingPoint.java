/* Using a threshold to compare floating-point numbers
   Anderson, Franceschi
*/

public class ComparingFloatingPoint
{
  public static void main( String [] args )
  {
    final double THRESHOLD = .0001;

    // Part 1: Compute 11 * .1 two ways
    double d1 = .0; // add .1 to 0 eleven times
    d1 += .1;  // 1
    d1 += .1;  // 2
    d1 += .1;  // 3
    d1 += .1;  // 4
    d1 += .1;  // 5
    d1 += .1;  // 6
    d1 += .1;  // 7
    d1 += .1;  // 8
    d1 += .1;  // 9
    d1 += .1;  // 10
    d1 += .1;  // 11

    double d2 = .1 * 11; // compute 11 * .1

    System.out.println( "d1 = " + d1 );
    System.out.println( "d2 = " + d2 );
    if ( Math.abs( d1 - d2 ) < THRESHOLD )
       System.out.println( "d1 and d2 are considered equal" );
    else
       System.out.println( "d1 and d2 are not equal" );

   // Part 2: Compare float and double with same value
   float  piF = 3.141592653589793f;
   double piD = 3.141592653589793;

   System.out.println( "\npiF = " + piF );
   System.out.println( "piD = " + piD );
   if ( Math.abs( piF - piD ) < THRESHOLD )
       System.out.println( "piF and piD are considered equal" );
   else
       System.out.println( "piF and piD are not equal" );
 }
}