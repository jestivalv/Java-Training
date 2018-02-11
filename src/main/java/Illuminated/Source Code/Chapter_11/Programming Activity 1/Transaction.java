/* Transaction
*  Anderson, Franceschi
*/
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.text.DecimalFormat;
import javafx.scene.text.Font;

public abstract class Transaction
{
 public static final DecimalFormat money = new DecimalFormat( "$0.00" );
 protected double amount;
 protected double currentBalance;
 protected String display2 = "";

 protected double currentStudentSubTotal;
 protected double correctCorrectSubTotal;
 
 protected int x;
 protected int y = 200;
 protected int startX = 50;
 protected int startY = 200;
 
 protected int height = 130;
 protected int width = 240;
 protected int endX = startX + 4 * width / 5;
 protected int endY = startY + 2 * width / 5;
 
 protected int digitSide = 3 * height / 13;

 public Transaction( double newAmount )
 {
  amount = newAmount;
 }

 public void setAmount( double amount )
 {
  this.amount = amount;
 }

 public double getAmount( )
 {
  return amount;
 }
 
 public void addToX( int delta )
 {
   x += delta;
 }
 
 public void addToY( int delta )
 {
   y += delta;
 }

 
 public void resetX( )
 {
   x = startX;
 }
 
 public boolean done( )
 {
   return ( x >= endX );
 }
 
 public void setCurrentStudentSubTotal( double currentStudentSubTotal )
 {
   this.currentStudentSubTotal = currentStudentSubTotal;
 }
 
 public void setCurrentCorrectSubTotal( double currentCorrectSubTotal )
 {
   this.correctCorrectSubTotal = currentCorrectSubTotal;
 }

 public void updateCurrentCorrectSubTotal( )
 {
   correctCorrectSubTotal += amount;
 }
 
 public double getCurrentCorrectSubTotal( )
 {
   return correctCorrectSubTotal;
 }


 public abstract void draw( GraphicsContext gc, Color eraseColor );
 
 public void drawAccountBalance( GraphicsContext gc )
 {
   DecimalFormat money = new DecimalFormat( "$0.00" );

   String displayStudentBalance = "Your current account balance = " + money.format( currentStudentSubTotal );
   // String displayExactTotal = "Correct subtotal = " + money.format( correctCorrectSubTotal );

   gc.setFill( Color.BLACK );
   Font mediumFont = new Font( Dimensions.MEDIUM_FONT_SIZE );
   gc.setFont( mediumFont );
   gc.fillText( displayStudentBalance, 2 * digitSide / 3, startY - 100 );
   // gc.fillText( displayExactTotal, endX + 30, y + 50 );
 }

 public String toString( )
 {
   return getClass( ).getName( ) + "; " + amount;
 }

}
