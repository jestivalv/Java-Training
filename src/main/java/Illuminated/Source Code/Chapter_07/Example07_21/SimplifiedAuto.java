/**  Simplified Auto Class with Javadoc comments
     Anderson, Franceschi
*/

public class SimplifiedAuto
{
 private String model;
 private int milesDriven;
 private double gallonsOfGas;
 
 /**
 * Default constructor:<br/>
 * initializes model to "unknown"<br/>
 * milesDriven are autoinitialized to 0, and gallonsOfGas to 0.0
 */
 public SimplifiedAuto( )
 {
    model = "unknown";
 }

 /**
 * Mutator method:<br/>
 * Allows client to set value of milesDriven<br/>
 * <strong>setMilesDriven</strong> does not change the value
 * of <strong>milesDriven</strong> if newMilesDriven has negative value
 * @param newMilesDriven the new number of miles driven
 * @return a reference to this object
 */
 public SimplifiedAuto setMilesDriven( int milesDriven )
 {
    if ( milesDriven > 0 )
        this.milesDriven = milesDriven;
    return this;
 }

 /** Accessor method for milesDriven:<br/>
 * @return an int, the value of milesDriven
 */
 public int getMilesDriven( )
 {
      return milesDriven;
 }
}
