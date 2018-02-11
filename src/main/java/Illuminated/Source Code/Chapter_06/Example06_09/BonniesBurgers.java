/* Order from a menu
   Anderson, Franceschi
*/

import java.util.Scanner;
import java.text.DecimalFormat;

public class BonniesBurgers
{
   public static void main( String [] args )
   {
      String menu = "\tC  Cheeseburger: $7.49";
             menu += "\n\tH  Hot dog: $6.99";
             menu += "\n\tL  Lemonade: $2.50";
             menu += "\n\tT  Iced tea: $2.75";

             
      char option;
      double orderCost = 0; 

      DecimalFormat money = new DecimalFormat( "$#.00" );
      Scanner scan = new Scanner( System.in );

      System.out.println( "Welcome to Bonnie's Burgers. "
                           + "Select from our menu: " );
      
      System.out.println( menu ); // print the menu
      System.out.print( "Order an item, "
                         + "or \"S\" to stop > " );
      option = scan.next( ).charAt( 0 );

      while ( option != 'S' && option != 's' )
      {
        switch ( option )
        {
          case 'c':
          case 'C':
             System.out.print( "Cheeseburger ordered. " );
             orderCost += 7.49;
             break;
          case 'h':
          case 'H':
             System.out.print( "Hot dog ordered. " );
             orderCost += 6.99;
             break;
          case 'l':
          case 'L':
             System.out.print( "Lemonade ordered. " );
             orderCost += 2.50;
             break;
          case 't':
          case 'T':
             System.out.print( "Iced tea ordered. " );
             orderCost += 2.75;
             break;
          default:
             System.out.println( "Unrecognized menu item." );
        }

        System.out.println( "Subtotal: "
                             + money.format( orderCost ) );

        System.out.print( "\nOrder another item, "
                           + "or \"S\" to stop > " );
        option = scan.next( ).charAt( 0 );
      }

      System.out.println( "\nTotal order cost is "
                            + money.format( orderCost ) );
  }
}