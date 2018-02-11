/* Using Logical Operators
   Anderson, Franceschi
*/

public class LogicalOperators
{
  public static void main( String [] args )
  {
   int age = 75;
   boolean test;

   test = ( age > 18 && age < 65 );
   System.out.println( age + " > 18 && " + age + " < 65 is " + test );

   // short circuitry with AND
   test = ( age < 65 && age > 18 );
   System.out.println( age + " < 65 && " + age + " > 18 is " + test );

   // short circuitry with OR
   test = ( age > 65 || age < 18 );
   System.out.println( age + " > 65 || " + age + " < 18 is " + test );

   // AND has higher precedence than OR
   test = ( age > 65 || age < 18  && false );
   System.out.println( age + " > 65 || " + age + " < 18 "
          + " && false is " + test );

   // use of parentheses to force order of execution
   test = ( ( age > 65 || age < 18 )  && false );
   System.out.println( "( " + age + " > 65 || " + age + " < 18 ) "
          + "&& false is " + test );
  }
}