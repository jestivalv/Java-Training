/* Withdrawal class
   Anderson, Franceschi
*/

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.text.DecimalFormat;
import javafx.scene.text.Font;

public class Withdrawal extends Transaction
{
 public Withdrawal( double p )
 {
  super( p );
 }

 public void draw( GraphicsContext gc, Color background )
 {
  drawAccountBalance( gc );

  String display1 = "Withdrawal:  Amount = " + money.format( amount );
  // set color to red
  gc.setFill( Color.RED );
  gc.fillText( display1, 20, 50 );
  // set color to black
  gc.setFill( Color.BLACK );
  gc.fillText( display2, 20, 75 );
  // set color to blue
  gc.setFill( Color.BLUE );
  gc.setStroke( Color.BLUE );
  gc.fillText( "Withdrawal", startX + 5, startY - 45 );

  // draw an automated teller machine
  gc.strokeRect( startX, startY, width, height );

  gc.strokeRect( startX + digitSide / 3, startY + digitSide / 3, digitSide, digitSide );
  gc.strokeRect( startX + digitSide / 3 + 4 * digitSide / 3, startY + digitSide / 3, digitSide, digitSide );
  gc.strokeRect( startX + digitSide / 3 + 8 * digitSide / 3, startY + digitSide / 3, digitSide, digitSide );

  gc.strokeRect( startX + digitSide / 3, startY + 5 * digitSide / 3, digitSide, digitSide );
  gc.strokeRect( startX + digitSide / 3 + 4 * digitSide / 3, startY + 5 * digitSide / 3, digitSide, digitSide );
  gc.strokeRect( startX + digitSide / 3 + 8 * digitSide / 3, startY + 5 * digitSide / 3, digitSide, digitSide );

  gc.strokeRect( startX + digitSide / 3, startY + 9 * digitSide / 3, digitSide, digitSide );
  gc.strokeRect( startX + digitSide + 20, startY + 9 * digitSide / 3, digitSide, digitSide );
  gc.strokeRect( startX + digitSide / 3 + 8 * digitSide / 3, startY + 9 * digitSide / 3, digitSide, digitSide );

  gc.fillText( "1",startX + digitSide / 3 + digitSide / 4, startY + digitSide / 3 + 5 * digitSide / 6 );
  gc.fillText( "2",startX + digitSide + 2 * digitSide / 3 + digitSide / 4, startY + digitSide / 3 + 5 * digitSide / 6 );
  gc.fillText( "3",startX + 2 * digitSide + 3 * digitSide / 3 + digitSide / 4, startY + digitSide / 3 + 5 * digitSide / 6 );

  gc.fillText( "4",startX + digitSide / 3 + digitSide / 4, startY + 5 * digitSide / 3 + 5 * digitSide / 6 );
  gc.fillText( "5",startX + digitSide + 2 * digitSide / 3 + digitSide / 4, startY + 5 * digitSide / 3 + 5 * digitSide / 6 );
  gc.fillText( "6",startX + 2 * digitSide + 3 * digitSide / 3 + digitSide / 4, startY + 5 * digitSide / 3 + 5 * digitSide / 6 );

  gc.fillText( "7",startX + digitSide / 3 + digitSide / 4, startY + 9 * digitSide / 3 + 5 * digitSide / 6 );
  gc.fillText( "8",startX + digitSide + 2 * digitSide / 3 + digitSide / 4, startY + 9 * digitSide / 3 + 5 * digitSide / 6 );
  gc.fillText( "9",startX + 2 * digitSide + 3 * digitSide / 3 + digitSide / 4, startY + 9 * digitSide / 3 + 5 * digitSide / 6 );

  // Draw a dollar bill
  gc.setFill ( Color.rgb( 0, 255, 0 ) ); // green
  gc.fillRect( startX + 2 * digitSide + 3 * digitSide / 3 + digitSide / 4 + 2 * digitSide, y, 
               2 * digitSide, digitSide );
  gc.setFill ( Color.BLACK );
  gc.fillText( "$$$", startX + 2 * digitSide + 3 * digitSide / 3 + digitSide / 4 + 2 * digitSide + digitSide / 6, 
               y + 5 * digitSide / 6 );
 }
 
 public boolean done( )
 {
   return ( y >= endY );
 }

}
