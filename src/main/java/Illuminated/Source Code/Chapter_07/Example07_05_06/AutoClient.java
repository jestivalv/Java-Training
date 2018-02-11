/* Auto Client, Version 3
   Anderson, Franceschi
*/

public class AutoClient
{
  public static void main( String [] args )
  {
     Auto suv = new Auto( "Trailblazer", 7000, 437.5 );

     // print initial values of instance variables
     System.out.println( "suv: model is " + suv.getModel( )
            + "\n miles driven is " + suv.getMilesDriven( )
            + "\n gallons of gas is " + suv.getGallonsOfGas( ) );

     // call mutator method for each instance variable
     suv.setModel( "Sportage" );
     suv.setMilesDriven( 200 );
     suv.setGallonsOfGas( 10.5 );

     // print new values of instance variables
     System.out.println( "\nsuv: model is " + suv.getModel( )
            + "\n miles driven is " + suv.getMilesDriven( )
            + "\n gallons of gas is " + suv.getGallonsOfGas( ) );

     // attempt to set invalid value for milesDriven
     suv.setMilesDriven( -1 );
     // print current values of instance variables
     System.out.println( "\nsuv: model is " + suv.getModel( )
            + "\n miles driven is " + suv.getMilesDriven( )
            + "\n gallons of gas is " + suv.getGallonsOfGas( ) );
  }
}
