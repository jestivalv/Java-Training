/* UnknownTransaction class
   Anderson, Franceschi
*/

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.text.DecimalFormat;
import javafx.scene.text.Font;
import javafx.scene.shape.ArcType;

public class UnknownTransaction extends Transaction
{
 public UnknownTransaction( double p )
 {
  super( p );
 }

 public void draw( GraphicsContext gc, Color background )
 {
  drawAccountBalance( gc );

  String display1 = "Unknown Transaction:  Amount = " + money.format( amount );
  if ( amount < 0 )
        gc.setFill( Color.RED );
  else
        gc.setFill( Color.BLUE );
  gc.fillText( display1, 20, 50 );

  // set color to black
  gc.setFill( Color.BLACK );
  gc.fillText( display2, 20, 75 );

  // set color to blue
  gc.setFill( Color.BLUE );
  gc.fillText( "Unknown Transaction", startX + 5, startY - 45 );

  gc.setFill( Color.DARKGRAY );
  gc.setStroke( Color.DARKGRAY );
  // Draw a question mark
  gc.strokeArc( x, startY, 20, 20, 0, 180, ArcType.OPEN );
  gc.strokeLine( x + 20, startY + 10, x, startY + 60 );
  gc.strokeArc( x, startY + 55, 10, 10, 180, 225, ArcType.OPEN );
  gc.fillOval( x, startY + 80, 15, 15 );
 }
}
