/* A simple date class
   Anderson, Franceschi
*/

public class SimpleDate
{
  private int month;
  private int day;
  private int year;

  /** default constructor
  *  sets month to 1, day to 1 and year to 2000
  */
  public SimpleDate( )
  {
    setDate( 1, 1, 2000 );
  }

  /** overloaded constructor
  *  @param month    initial value for month
  *  @param day   initial value for day
  *  @param year  initial value for year
  *
  *  passes parameters to set methods
  */
  public SimpleDate( int month, int day, int year )
  {
    setMonth( month );
    setYear( year );
    setDay( day );
  }

  /* accessor methods */
  int getMonth( ) { return month; }
  int getDay( )   { return day; }
  int getYear( )  { return year; }

  /** mutator method */
  /** setMonth
  *  @param month new value for month
  *  if month is between 1 and 12, sets htis.month to month
  *  otherwise, the value is unchanged
  */
  public void setMonth( int month )
  {
    this.month = ( month >= 1 && month <= 12 ? 
                   month : this.month );
  }

  /** setDay
  *  @param day new value for day
  *  if day is legal day for current month, sets this.day to day
  *  otherwise, value is unchanged
  */
  public void setDay( int day )
  {
    this.day = ( day >= 1 && isValidDay( day ) ? day : this.day );
  }

  /** setYear
  *  @param year new value for year
  *  sets this.year to year
  */
  public void setYear( int year )
  {
    this.year = year;
  }

  /** sets date to the next day
  */
  public void nextDay( )
  {
     if ( ! isValidDay( ++day ) )
     {
         day = 1;
         if ( ++month > 12 )
         {
            month = 1;
            year++;
         }
     }
  }

  private boolean isValidDay( int newDay )
  {
     int [] daysInMonth = { 0, 31, 28, 31,
                               30, 31, 30,
                               31, 31, 30,
                               31, 30, 31 };

    if ( newDay > daysInMonth[month] )
    {
      if ( month == 2 && isLeapYear( ) && newDay == 29 )
       return true;
      else
       return false;
    }
    else
       return true;
  }

  private boolean isLeapYear( )
  {
     return !( year % 4 != 0
            ||( year % 100 == 0 && year % 400 != 0 ) );
  }

  /** setDate
  *  @param month    new value for month
  *  @param day   new value for day
  *  @param year  new value for year
  *  passes parameters to setMonth, setDay, and setYear
  */
  
  public void setDate( int month, int day, int year )
  {
    setYear( year );  // set year first (could be leap year)
    setMonth( month );   // set month next
    setDay( day );     // set day
  }

  /** toString
  *  @return String
  *  returns date in mm/dd/yyyy format
  */
  public String toString( )
  {
    return month + "/" + day + "/" + year;
  }

  /** equals
  *  @param   d  Object to compare to this object
  *  @return  true if d is equal to this object
  *           false, otherwise
  */
  public boolean equals( Object d )
  {
    if ( !( d instanceof SimpleDate ) )
       return false;
    SimpleDate d1 = (SimpleDate)d;
    if ( month == d1.month
         && day == d1.day
         && year == d1.year )
      return true;
    else
      return false;
  }
}
