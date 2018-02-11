/* Check class
   Anderson, Franceschi
*/

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.text.DecimalFormat;
import javafx.scene.text.Font;

public class Check extends Transaction
{

 public Check( double p )
 {
  super( p );
  resetX( );
  // System.out.println( "Check( " + p + " ) called" );
 }

 public void draw( GraphicsContext gc, Color background )
 {
  drawAccountBalance( gc );
  String display1 = "Check:  Amount = " + money.format( amount );
  // set color to red
  gc.setFill( Color.RED );
  gc.fillText( display1, 2 * digitSide / 3, 5 * digitSide / 3 );
  // set color to black
  gc.setFill( Color.BLACK );
  gc.fillText( display2, 2 * digitSide / 3, 15 * digitSide / 6 );

  // set color to blue
  gc.setFill( Color.BLUE );
  gc.fillText( "Check", startX + 3, startY - 44 );

  // draw check
  gc.setStroke( Color.BLUE );
  gc.strokeRect( startX, startY, width, height );
  gc.fillText( "ABC Bank", startX + width / 4, startY + height / 3 );
 
  // sign the check
  gc.setStroke( Color.BLACK );
  for( int signX = startX + width / 2; signX <= x ; signX++ )
    gc.strokeLine( signX, ( int ) ( startY + 2 * height / 3 + 10 * Math.sin( signX ) ),
              signX + 1, ( int ) ( startY + 2 * height / 3 + 10 * Math.sin( signX + 1 ) ) );
 }
 
 public void resetX( )
 {
   x = startX + width / 3;
 }

}
