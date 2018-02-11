/* Auto class, version 5
   Anderson, Franceschi
*/

public class Auto
{
    // instance variables
    private String model;          //  model of auto
    private int milesDriven;       //  number of miles driven
    private double gallonsOfGas;   //  number of gallons of gas

    // Constructors:
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

    // Accessor Method:
    // returns current value of model
    public String getModel( )
    {
       return model;
    }

    // Accessor Method:
    // returns current value of milesDriven
    public int getMilesDriven( )
    {
       return milesDriven;
    }

    // Accessor Method:
    // returns current value of gallonsOfGas
    public double getGallonsOfGas( )
    {
       return gallonsOfGas;
    }

    // Mutator Method:
    // allows client to set model
    public Auto setModel( String model )
    {
       this.model = model;
       return this;
    }

    // Mutator Method:
    // allows client to set value of milesDriven
    // if new value is not less than 0
    public Auto setMilesDriven( int milesDriven )
    {
       if ( milesDriven >= 0 )
         this.milesDriven = milesDriven;
       return this;
    }

    // Mutator Method:
    // allows client to set value of gallonsOfGas
    // if new value is not less than 0.0
    public Auto setGallonsOfGas( double gallonsOfGas )
    {
       if ( gallonsOfGas >= 0.0 )
         this.gallonsOfGas = gallonsOfGas;
       return this;
    }

    // Calculates miles per gallon.
    //  if no gallons of gas have been used, returns 0.0;
    //  otherwise, returns miles per gallon
    //        as milesDriven / gallonsOfGas
    public double milesPerGallon( )
    {
       if ( gallonsOfGas >= 0.0001 )
          return milesDriven / gallonsOfGas;
       else
          return 0.0;
    }

    // Calculates money spent on gas.
    // returns price per gallon times gallons of gas
    public double moneySpentOnGas( double pricePerGallon )
    {
       return pricePerGallon * gallonsOfGas;
    }
}
