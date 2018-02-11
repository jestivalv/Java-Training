/* Computing the number of combinations
   of picking p objects among n, using recursion
   Anderson, Franceschi
*/

public class RecursiveCombinations
{
  public static void main( String [] args )
  {
    // compute and output number of combinations
    System.out.println( "C( 5, 2 ) = "
                         + combinations( 5, 2 ) );
  }

  /** recursive combinations method
  *   @param    n a positive number
  *   @param   p a positive number, less than or equal to n
  *   @return   the number of combinations of choosing p among n
  */
  public static int combinations( int n, int p )
  {
    if ( p == 0 )       // base case # 1
      return 1;
    else if ( n == p )  // base case # 2
      return 1;
    else                // general case
      return ( combinations( n - 1, p - 1 )
               + combinations( n - 1, p ) );
  }
}
