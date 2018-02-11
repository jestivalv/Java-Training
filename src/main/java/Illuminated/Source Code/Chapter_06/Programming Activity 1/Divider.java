/** Divider
*   Anderson, Franceschi
*/

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.ArrayList;
import java.text.DecimalFormat;import java.text.DecimalFormat;

public class Divider extends Item
{
 public Divider( double p )
 {
   super( p );
 }
 
 public void draw( GraphicsContext gc, Color eraseColor )
 {
  drawBeltAndBag( gc );
  drawData( gc );

  Font smallFont = new Font( Dimensions.MEDIUM_SMALLER_FONT_SIZE );
  gc.setFont( smallFont );

  gc.setFill( Color.YELLOW );
  gc.fillRoundRect( x, y - 2 - height / 3, width, height / 3, 5, 5 );
  gc.setFill( Color.BLACK );
  gc.setStroke( Color.BLACK );
  gc.strokeRoundRect( x, y - 2 - height / 3, width, height / 3, 5, 5 );
  gc.fillText("Thank", x + 10, y - height / 3  + height / 6 );
  gc.fillText(" you!", x + 10, y - height / 3 + height / 6 + Dimensions.MEDIUM_SMALLER_FONT_SIZE );
 }

}