/* AccountingDrawing Class
* Anderson, Franceschi
*/

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class AccountingDrawing
{
 // ArrayList representing the various Items and subtotals
 // as they are used by the loop
 private ArrayList<SubTotal> subTotals;
 SubTotal currentSubTotal;
 Transaction transaction;
 // current index of subTotals
 private int index;
                    
 public AccountingDrawing( )
 {
   subTotals = new ArrayList<SubTotal>( );
   index = 0;
 }

 public void balanceCheckBook( )
 {
    // ***** Write the body of this method *****
    //
    // Using a while loop, read the file transactions.txt
    // The file transactions.txt contains
    // transactions between you and your bank
    //
    //  You will need to call the animate method inside
    //  the body of the loop that reads the file contents
    //
    // The animate method takes three arguments:
    //    a String, representing the type of transaction
    //    a double, representing the transaction money amount
    //    a double, representing the new checkbook balance
    // So if these three variables are:
    //     transactionName, currentAmount, and balance,
    //  then the call to animate will be:
    //
    //  animate( transactionName, currentAmount, balance );
    //
    // You should make that call in the body of your while
    // loop, after you have updated the checkbook balance
    //

 
 
   
    //
    // end of student code
    //
 }
  
 public void animate( String transactionName, double amount, double total )
 {
   // update subTotals
   currentSubTotal = new SubTotal( transactionName, amount, total );
   
   if( transactionName.startsWith( "Check" ) )
     transaction = new Check( amount );
   else if( transactionName.startsWith( "Deposit" ) )
     transaction = new Deposit( amount );
   else if( transactionName.startsWith( "Withdrawal" ) )
     transaction = new Withdrawal( amount );
   else
     transaction = new UnknownTransaction( amount );
   
   currentSubTotal.setTransaction( transaction );
   // put it in ArrayList
   subTotals.add( currentSubTotal );
 }
  
  public void reset( )
  {
   index = 0;
  }
  
  public void incrementIndex( )
  {
   index++;
  }
  
  public int getIndex( )
  {
   return index;
  }
  
  public boolean done( )
  {
    return index >= subTotals.size( );
  } 
  
  public SubTotal getSubTotal( int index )
  {
    return subTotals.get( index );
  }
  
  public String toString( )
  {
    String result = "List: ";
    for( SubTotal current : subTotals )
    {
      result += current.toString( ) + " ";
    }
    return result;
  }
  
  public boolean isEmpty( )
  {
    return subTotals.size( ) == 0;
  }
  
}