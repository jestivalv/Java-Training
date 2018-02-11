/* Auto Client, version 5
   Anderson, Franceschi
*/

public class AutoClient
{
   public static void main( String [] args )
   {
      Auto sporty = new Auto( "Spyder", 0, 0.0 );               
      sporty.setGallonsOfGas( 3.4 ).setMilesDriven( 67 );
      int sportyMiles = sporty.getMilesDriven( );
      double sportyGallons = sporty.getGallonsOfGas( );
      System.out.println( "Miles driven is " + sportyMiles
                   + "\nGallons of gas is " + sportyGallons );
   }
}
