/* The FlightRecord class
   Anderson, Franceschi
*/

import java.io.Serializable;
import java.text.DecimalFormat;

public class FlightRecord2 implements Serializable
{
  public static final DecimalFormat MONEY
                        = new DecimalFormat( "$###.00" );
  private String flightNumber;     // ex. = AA123
  private String origin;           // origin airport; ex. = BWI
  private String destination;      // destination airport; ex. = SFO
  private int numPassengers;       // number of passengers
  private double avgTicketPrice;   // average ticket price

  /** Constructor
  *  @param  startFlightNumber   flight number
  *  @param  startOrigin         origin airport
  *  @param  startDestination    destination airport
  *  @param  startNumPassengers  number of passengers
  *  @param  startAvgTicketPrice average ticket price
  */
  public FlightRecord2( String startFlightNumber,
                       String startOrigin,
                       String startDestination,
                       int startNumPassengers,
                       double startAvgTicketPrice )
  {
    flightNumber = startFlightNumber;
    origin = startOrigin;
    destination = startDestination;
    numPassengers = startNumPassengers;
    avgTicketPrice = startAvgTicketPrice;
  }
    
  /** toString
  * @return flight number, origin, destination,
  *         number of passengers, and average ticket price
  */
  @Override
  public String toString( )
  {
    return "Flight " + flightNumber
           + ": from " + origin
           + " to " + destination
           + "\n\t" + numPassengers + " passengers"
           + "; average ticket price: "
           + MONEY.format( avgTicketPrice );
  }
  
  /** getOrigin method
  * @return origin
  */
  public String getOrigin( )
  {
    return origin;
  }
  
  /** getNumPassengers method
  * @return numPassengers
  */
  public int getNumPassengers( )
  {
    return numPassengers;
  }

  // other accessors, mutators, and other methods …
}
