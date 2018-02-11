/* Computing the greatest common divisor using recursion
   Anderson, Franceschi
*/
import java.util.List;
import java.util.stream.Collectors;

public class RecursiveGCDWithStackTrace
{
  public static void main( String [] args )
  {
    // compute gcd of 123450 and 60378 and output it
    System.out.println( "\nThe GCD of " + 474 + " and "
                         + 162 + " is " + gcd( 474, 162 ) );
  }
    
  /** recursive gcd method with trace
  *   @param    dividend   the first strictly positive integer
  *   @param    divisor    the second strictly positive integer
  *   @return              the gcd of dividend and divisor
  */
  public static int gcd( int dividend, int divisor )
  {
    List<StackWalker.StackFrame> stack = StackWalker.getInstance( )
           .walk( s -> s.skip(1).collect( Collectors.toList( ) ) );
     

    System.out.print( "gcd( " + dividend + ", " + divisor + " )" );
    System.out.println( "   " + dividend + " % " + divisor + " = "
                         + ( dividend % divisor ) );
    System.out.println( "\tCurrent stack" );
    for ( StackWalker.StackFrame f : stack )
      System.out.println( "\t\t" + f.getLineNumber( ) 
                           + " " + f.getMethodName( ) );                 
   
    if ( dividend % divisor == 0 )  // base case
    {
      System.out.println( "\nbase case reached, returning "
                           + divisor );
      System.out.println( "\tCurrent stack" );
      for ( StackWalker.StackFrame f : stack )
        System.out.println( "\t\t" + f.getLineNumber( ) 
                             + " " + f.getMethodName( ) );                 
                          
      return divisor;
    }
    else                           // general case
    {         
      int temp = gcd( divisor, dividend % divisor );
      System.out.println( "gcd( " + divisor + ", "
                          + ( dividend % divisor ) 
                          + " ) returning " + temp );
      
      System.out.println( "\tCurrent stack" );
      for ( StackWalker.StackFrame f : stack )
        System.out.println( "\t\t" + f.getLineNumber( ) 
                             + " " + f.getMethodName( ) );                 
   
      return ( temp );
    }
  }
}
