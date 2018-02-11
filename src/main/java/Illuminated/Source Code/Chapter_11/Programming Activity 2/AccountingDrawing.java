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
   //
   // ***** Student writes the body of this method *****
   //
   // Using a while loop, read the file transactions.obj
   // The file transactions.obj contains transaction objects
   //
   // You will need to call the animate method inside
   // the body of the loop that reads the objects
   //
   // The animate method takes two arguments:
   //    a Transaction object, representing the transaction
   //    a double, representing the new checkbook balance
   // So if these two variables are transaction and balance,
   // then the call to animate will be:
   //
   //   animate( transaction, balance );
   //
   // You should make that call in the body of your while
   // loop, after you have updated the checkbook balance
   //

   
   
   //
   //  end of student code
   //
 }

 public void writeTransactions( ArrayList<Transaction> transactionList )
 {
   //
   // writing to file transactions.obj
   //

   try
   {
    FileOutputStream fos = new FileOutputStream( "transactions.obj" );
    ObjectOutputStream oos = new ObjectOutputStream( fos );

    Transaction tempTransaction;
    for ( int i = 0; i < transactionList.size( ) ; i++ )
    {
     tempTransaction = ( Transaction ) transactionList.get( i );
     oos.writeObject( tempTransaction );
    }
    oos.close( );
   }
   catch ( IOException ioe )
   {
    System.out.println( ioe.toString( ) );
    System.out.println( ioe.getMessage( ) );
   }
 }
  
 public void animate( Transaction transaction, double balance )
 {
   // update subTotals
   currentSubTotal = new SubTotal( transaction, balance );
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