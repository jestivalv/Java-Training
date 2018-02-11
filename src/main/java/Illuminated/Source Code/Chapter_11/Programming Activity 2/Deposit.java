/* Deposit class
   Anderson, Franceschi
*/
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.text.DecimalFormat;
import javafx.scene.text.Font;

public class Deposit extends Transaction
{
 public Deposit( double p )
 {
  super( p );
 }

 public void draw( GraphicsContext gc, Color background )
 {
  drawAccountBalance( gc );
  String display1 = "Deposit:  Amount = " + money.format( amount );
  // set color to blue
  gc.setFill( Color.BLUE );
  gc.fillText( display1, 20, 50 );

  // set color to black
  gc.setFill( Color.BLACK );
  gc.fillText( display2, 20, 75 );

  // set color to blue
  gc.setFill( Color.BLUE );
  gc.fillText( "Deposit", startX + 3, startY - 44 );

  // draw Work, Internet, Bank
  gc.setStroke( Color.BLUE );
  gc.strokeLine( startX, startY - 2 * digitSide / 3, endX, startY - 2 * digitSide / 3 );
  gc.strokeLine( startX, startY + digitSide + digitSide / 3, endX, startY + 4 * digitSide / 3 );
  gc.fillText( "Work", startX - digitSide - digitSide / 3, startY + 2 * digitSide / 3 );
  gc.fillText( "ABC Bank", endX + digitSide / 3, startY + 2 * digitSide / 3 );

  // Draw a dollar bill  
  gc.setFill ( Color.rgb( 0, 255, 0 ) );// green
  gc.fillRect( x, startY - digitSide / 4, 2 * digitSide, digitSide );
  gc.setFill ( Color.rgb( 0, 0, 0 ) );
  gc.fillText( "$$$", x + digitSide / 5, startY + 2 * digitSide / 3 );  
 }
}
