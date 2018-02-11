/* SavingsAccount class
*  Anderson, Franceschi
*/

import java.text.DecimalFormat;

// 1. ***** indicate that SavingsAccount inherits
//          from BankAccount
public class SavingsAccount
{
   public final double DEFAULT_RATE = .03;
   // 2. ****** define the private interestRate instance variable
   // interestRate, a double, represents an annual rate
   

   // 3 ***** write the default constructor
   /** default constructor
   *   explicitly calls the BankAccount default constructor
   *   set interestRate to default value DEFAULT_RATE
   *   print a message to System.out indicating that this
   *     constructor is called
   */
   
   
   // 4 ***** write the overloaded constructor
   /** overloaded constructor
   *   explicitly call BankAccount overloaded constructor
   *   call setInterestRate method, passing interestRate
   *   print a message to System.out indicating that this
   *     constructor is called
   *  @param  balance      starting balance
   *  @param  interestRate starting interest rate
   */
   
   
   // 5 ****** write this method:
   /** applyInterest method, no parameters.
   *   call the deposit method, passing a month's worth of interest
   *   remember that the interestRate instance variable is the annual rate
   *   
   *   @return a reference to this object 
   */
  
  
   /** accessor method for interestRate
   *  @return  interestRate
   */
   public double getInterestRate( )
   {
     return interestRate;
   }

   /** mutator method for interestRate
   *  @param  interestRate new value for interestRate
   *          interestRate must be >= 0.0
   *            if not, do not change the value
   *          stores interestRate as input value / 100
   *          that is, 3.5 is stored as .035
   *  @return  a reference to this object
   */
   public SavingsAccount setInterestRate( double interestRate )
   {
     if ( interestRate >= 0.0 )
        this.interestRate = interestRate / 100;
        
     return this;
   }

   // 6 *****  write this method
   /* toString method
   *  @return a String containing formatted balance and interestRate
   *    invokes superclass toString to format balance
   *    formats interestRate as percent using a DecimalFormat object
   *    To create a DecimalFormat object for formatting percentages
   *    use this pattern in the constructor: "0.00%"
   */
  
}
