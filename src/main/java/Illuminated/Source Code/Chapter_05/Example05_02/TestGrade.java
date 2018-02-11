/* Using if to calculate a final test grade
   Anderson, Franceschi
*/
import java.util.Scanner;

public class TestGrade
{
  public static void main( String [] args )
  {
    Scanner scan = new Scanner( System.in );

    System.out.print( "Enter your test grade > " );
    int grade = scan.nextInt( );

    System.out.print( "Enter your extra credit > " );
    int extraCredit = scan.nextInt( );

    if ( extraCredit > 0 )
      grade += extraCredit;

    System.out.println( "Your final test grade is "
                        + grade ) ;
  }
}
