/*  Shortcut Arithmetic Operators
    Anderson, Franceschi
*/

public class ShortcutArithmeticOperators
{
   public static void main( String [ ] args )
   {
      int a = 5;
      System.out.println( "a is " + a );

      a += 10;      //  a = a + 10;
      System.out.println( "\nAfter a += 10; a is " + a );

      a -= 3;       //  a = a - 3;
      System.out.println( "\nAfter a -= 3; a is " + a );

      a *= 2;       //  a = a * 2;
      System.out.println( "\nAfter a *= 2; a is " + a );

      a /= 6;       //  a = a / 6;
      System.out.println( "\nAfter a /= 6; a is " + a );

      a %= 3;       //  a = a % 3;
      System.out.println( "\nAfter a %= 3; a is " + a );
   }
}
