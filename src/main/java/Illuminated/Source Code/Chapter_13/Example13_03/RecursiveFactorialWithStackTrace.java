/* Tracing the calculation of the factorial
   of a number using recursion
   Anderson, Franceschi
*/
import java.util.List;
import java.util.stream.Collectors;

public class RecursiveFactorialWithStackTrace
{
  public static void main( String [] args )
  {
    // compute factorial of 5 and output it
    System.out.println( "\nFactorial( 5 ) is "
                      + factorial( 5 ) );
  }

  /** recursive factorial method
  *   @param   n  a positive integer
  *   @return   the factorial of n
  */
  public static int factorial( int n )
  {
    List<StackWalker.StackFrame> stack = StackWalker.getInstance( )
             .walk( s -> s.skip(1).collect( Collectors.toList( ) ) );
                       
    System.out.println( "factorial( " + n + " ) called" );  
    System.out.println( "\tCurrent Stack" );
    for ( StackWalker.StackFrame f : stack )
      System.out.println( "\t\t" + f.getLineNumber( ) + " "
                                 + f.getMethodName( ) );  

    if ( n == 0 )  // base case
    {
      System.out.println( "\nBase case detected\n" );
      
      System.out.println( "factorial( " + n + " ) returning 1" );     
      System.out.println( "\tCurrent Stack"  );
      for ( StackWalker.StackFrame f : stack )
        System.out.println( "\t\t" + f.getLineNumber( ) + " "
                                   + f.getMethodName( ) );

      return 1;
    }
    else        // general case
    {
      int factorialNMinus1 = factorial( n - 1 );
      
      System.out.println( "factorial( " + n + " ) returning "
                           + n + " * " + factorialNMinus1 );                         
      System.out.println( "\tCurrent Stack"  );
      for ( StackWalker.StackFrame f : stack )
        System.out.println( "\t\t" + f.getLineNumber( ) + " "
                                   + f.getMethodName( ) );

      return ( n * factorialNMinus1 );
    }
  }
}