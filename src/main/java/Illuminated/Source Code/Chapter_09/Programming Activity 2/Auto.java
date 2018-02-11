/* Auto class
   Anderson, Franceschi
*/
import java.text.DecimalFormat;
import javafx.scene.canvas.GraphicsContext;

public class Auto
{
    // Static instance variable - number of Auto objects references created
    private static int numberAutos = 0;
    // Instance variables
    private String model;          //  model of auto
    private int milesDriven;       //  number of miles driven
    private double gallonsOfGas;   //  number of gallons of gas
    private int index;             //  car number

    /** default constructor:
    *  Initializes model to an empty String
    *  milesDriven are autoinitialized to 0, gallonsOfGas to 0.0
    *  increments numberOfAutos
    */
    public Auto( )
    {
      model = "";
      index = numberAutos;
      numberAutos++;
    }

    // Overloaded constructor:
    // Allows client to set beginning values for
    //   model, milesDriven, and gallonsOfGas.
    //   Calls mutator methods to validate new values.
    public Auto( String model,
                 int milesDriven,
                 double gallonsOfGas )
    {
      this.model = model;
      setMilesDriven( milesDriven );
      setGallonsOfGas( gallonsOfGas );
      index = numberAutos;
      numberAutos++;
    }

    // Accessor method:
    // Returns current value of index
    public int getIndex( )
    {
      return index;
    }

    // Accessor method:
    // Returns current value of model
    public String getModel( )
    {
      return model;
    }

    // Accessor method:
    // Returns current value of milesDriven
    public int getMilesDriven( )
    {
      return milesDriven;
    }

    // Accessor method:
    //  Returns current value of gallonsOfGas
    public double getGallonsOfGas( )
    {
      return gallonsOfGas;
    }

    // Mutator method:
    // Allows client to set model
    public Auto setModel( String model )
    {
      this.model = model;
      return this;
    }

    // Mutator method:
    // Allows client to set value of milesDriven
    public Auto setMilesDriven( int milesDriven )
    {
      if ( milesDriven >= 0 )
         this.milesDriven = milesDriven;
      return this;
    }

    // Mutator method:
    // Allows client to set value of gallonsOfGas;
    public Auto setGallonsOfGas( double gallonsOfGas )
    {
      if ( gallonsOfGas >= 0.0 )
         this.gallonsOfGas = gallonsOfGas;
      return this;
    }

    // Mutator method
    // Allows client to add miles driven and gallons of gas used
    //  to current values;
    // prints error messages if new values are less than 0
    public void addMileage( int newMilesDriven,
                            double newGallonsOfGas )
    {
      if ( newMilesDriven < 0 )
         return;   // do not continue executing method

      if ( newGallonsOfGas < 0.0 )
         return;  // do not continue executing method

      // ok to change values
      milesDriven += newMilesDriven;  // add newMilesDriven
      gallonsOfGas += newGallonsOfGas; // add newGallonsOfGas
    }

    // Calculates mileage as miles per gallon.
    //  If no gallons of gas have been used, returns 0.0;
    //  Otherwise, returns miles per gallon
    //        as milesDriven / gallonsOfGas
    public double milesPerGallon( )
    {
      if ( gallonsOfGas != 0.0 )
         return milesDriven / gallonsOfGas;
      else
         return 0.0;
    }

    public static void clearNumberAutos( )
    {
        numberAutos = 0;
    }

    @Override
    public String toString( )
    {
      DecimalFormat gallonsFormat = new DecimalFormat( "##.0" );
      return "Model: " + model
           + " Miles driven: " + milesDriven
           + " Gallons of gas: "
           + gallonsFormat.format( gallonsOfGas );
    }

 } // end Auto class definition
