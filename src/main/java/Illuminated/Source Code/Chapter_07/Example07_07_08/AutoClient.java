/* Auto Client, Version 4
   Anderson, Franceschi
*/

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class AutoClient
{
   public static void main( String [] args )
   {
     Auto suv = new Auto( "Trailblazer", 7000, 437.5 );

     double mileage = suv.milesPerGallon( );
     DecimalFormat mpgFormat = new DecimalFormat( "0.0" );
     System.out.println( "Mileage for suv is "
                          + mpgFormat.format( mileage ) );
                          
     double gasCost = suv.moneySpentOnGas( 2.79 );
     NumberFormat money = NumberFormat.getCurrencyInstance( );
     System.out.println( "Gas cost for suv is "
                          + money.format( gasCost ) );
   }
}
