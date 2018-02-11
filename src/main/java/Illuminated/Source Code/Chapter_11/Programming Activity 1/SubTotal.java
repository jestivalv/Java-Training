/* Transaction
*  Anderson, Franceschi
*/
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.text.DecimalFormat;
import javafx.scene.text.Font;

public class SubTotal
{
 private double amount;
 private double subTotal;
 private String transactionName;
 private Transaction transaction;

 public SubTotal( String newTransactionName,
                  double newAmount, double newSubTotal )
 {
  // transaction = newTransaction;
  transactionName = newTransactionName;
  amount = newAmount;
  subTotal = newSubTotal;
 }

 public double getAmount( )
 {
  return amount;
 }
 
 public String getTransactionName( )
 {
  return transactionName;
 }

 public double getSubTotal( )
 {
  return subTotal;
 }
 
 public Transaction getTransaction( )
 {
  return transaction;
 }

 public void setSubTotal( double subTotal )
 {
  if( subTotal >= 0 )
    this.subTotal = subTotal;
 }
 
 public void setTransaction( Transaction transaction )
 {
  this.transaction = transaction;;
 }

 public void setTransactionName( String transactionName )
 {
  this.transactionName = transactionName;
 }
 
  public void setAmount( double amount )
 {
  if( amount >= 0 )
    this.amount = amount;
 }


 public void addToSubTotal( double price )
 {
  this.subTotal += price;
 }
 
 public String toString( )
 {
  String result = "";
  result += transactionName + "; " + amount + "; " + subTotal; 
  return result;
 }

}
