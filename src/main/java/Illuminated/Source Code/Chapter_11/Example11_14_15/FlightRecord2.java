/* The FlightRecord2 class
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
  *  @param  flightNumber   flight number
  *  @param  origin         origin airport
  *  @param  destination    destination airport
  *  @param  numPassengers  number of passengers
  *  @param  avgTicketPrice average ticket price
  */
  public FlightRecord2( String flightNumber,
                        String origin,
                        String destination,
                        int numPassengers,
                        double avgTicketPrice )
  {
    this.flightNumber = flightNumber;
    this.origin = origin;
    this.destination = destination;
    this.numPassengers = numPassengers;
    this.avgTicketPrice = avgTicketPrice;
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
