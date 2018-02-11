/* Transaction
*  Anderson, Franceschi
*/
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.text.DecimalFormat;
import javafx.scene.text.Font;

public class SubTotal
{
 private double subTotal;
 private Transaction transaction;

 public SubTotal( Transaction newTransaction, double newSubTotal )
 {
  transaction = newTransaction;
  subTotal = newSubTotal;
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

 public void addToSubTotal( double price )
 {
  this.subTotal += price;
 }
 
 public String toString( )
 {
  String result = "";
  result += transaction + "; " + "; " + subTotal; 
  return result;
 }

}
