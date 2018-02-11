/* Demonstrating how to read objects from a file
   Anderson, Franceschi
*/

import java.io.*;
import java.util.ArrayList;

public class ReadingObjectsIntoStream
{
  public static void main( String [] args )
  {
    ArrayList<FlightRecord2> flights = new ArrayList<FlightRecord2>( );
    try
    {
      FileInputStream fis = new FileInputStream( "objects" );
      ObjectInputStream ois = new ObjectInputStream( fis );

      try
      {
        while ( true )
        {
          // read object, type cast returned object to FlightRecord2
          FlightRecord2 temp = ( FlightRecord2 ) ois.readObject( );

          // add the FlightRecord2 object read to flights
          flights.add( temp );
        }
      } // end inner try block

      catch ( EOFException eofe )
      {
        System.out.println( "End of the file reached" );
      }

      catch ( ClassNotFoundException cnfe )
      {
        System.out.println( cnfe.getMessage( ) );
      }

      finally
      {
        System.out.println( "Closing file" );
        ois.close( );
      }
    } // end outer try block

    catch ( FileNotFoundException fnfe )
    {
      System.out.println( "Unable to find objects" );
    }

    catch ( IOException ioe )
    {
      ioe.printStackTrace( );
    }
   
    // calculate number of flights originating from BWI
    long count = 
      flights.stream( )
             .filter( flight -> flight.getOrigin( ).equals( "BWI" ) )
             .count( );
    System.out.println( "There are " + count + " flights from BWI" );
   
    // calculate average number of passengers on all flights 
    double avgNumPassengers = 
      flights.stream( )
             .mapToInt( FlightRecord2::getNumPassengers )
             .average( )
             .getAsDouble( );
    System.out.println( "Average number of passengers: " 
                      + avgNumPassengers );
  }
}
