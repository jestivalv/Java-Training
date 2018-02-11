/* Auto class, Version 3
   Anderson, Franceschi
*/

public class Auto
{
    // instance variables
    private String model;          //  model of auto
    private int milesDriven;       //  number of miles driven
    private double gallonsOfGas;   //  number of gallons of gas

    // Default constructor:
    //  initializes model to "unknown";
    //  milesDriven is auto-initialized to 0
    //        and gallonsOfGas to 0.0
    public Auto( )
    {
       model = "unknown";
    }

    // Overloaded constructor:
    // allows client to set beginning values for
    //   model, milesDriven, and gallonsOfGas.
    public Auto( String startModel,
                 int startMilesDriven,
                 double startGallonsOfGas )
    {
       model = startModel;
       setMilesDriven( startMilesDriven );
       setGallonsOfGas( startGallonsOfGas );
    }

    // Accessor method:
    // returns current value of model
    public String getModel( )
    {
      return model;
    }

    // Accessor method:
    // returns current value of milesDriven
    public int getMilesDriven( )
    {
      return milesDriven;
    }

    // Accessor method:
    //  returns current value of gallonsOfGas
    public double getGallonsOfGas( )
    {
      return gallonsOfGas;
    }

    // Mutator method:
    // allows client to set model
    public void setModel( String newModel )
    {
      model = newModel;
    }

    // Mutator method:
    // allows client to set value of milesDriven
    // if new value is not less than 0
    public void setMilesDriven( int newMilesDriven )
    {
      if ( newMilesDriven >= 0 )
        milesDriven = newMilesDriven;
    }

    // Mutator method:
    // allows client to set value of gallonsOfGas
    // if new value is not less than 0.0
    public void setGallonsOfGas( double newGallonsOfGas )
    {
      if ( newGallonsOfGas >= 0.0 )
        gallonsOfGas = newGallonsOfGas;
    }
}
