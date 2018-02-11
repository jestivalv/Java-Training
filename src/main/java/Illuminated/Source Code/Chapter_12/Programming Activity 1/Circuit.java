/* Circuit - animates the circuit
   Anderson, Franceschi
*/

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circuit
{
 private int xStart = 100;
 private int yStart = 100;

 private boolean switchClosed;

 /** default constructor
 *   sets switchClosed to false, indicating
 *   the switch is open
 */
 public Circuit( )
 {
  switchClosed = false;
 }
 
 /** open method
 *  sets switchClosed to false
 */
 public void open( )
 {
  switchClosed = false;
 }

 /** close method
 *  sets switchClosed to true
 */
 public void close( )
 {
  switchClosed = true;
 }

 /** draw method
 *   draw the current state of the circuit
 *  @param gc the GraphicsContext of the window
 */
 public void draw( GraphicsContext gc )
 {
  // draw Circuit but not the switch
  // set color to blue
  drawSwitchAndBulb( gc );
  gc.setStroke( Color.BLUE );
  gc.setFill( Color.BLUE );
   
  gc.strokeLine( xStart, yStart, xStart, yStart + 205 );

  gc.strokeLine( xStart, yStart + 205, xStart + 100, yStart + 205 );
  gc.strokeLine( xStart + 160, yStart + 205, xStart + 300, yStart + 205 );
  gc.fillText( "Switch", xStart + 115, yStart + 230 );

  gc.strokeLine( xStart + 300, yStart + 205, xStart + 300, yStart + 120 );
  gc.strokeLine( xStart + 300, yStart + 80, xStart + 300, yStart );

  gc.strokeLine( xStart + 300, yStart, xStart + 150, yStart );
  gc.strokeLine( xStart + 140, yStart, xStart, yStart );

  gc.strokeLine( xStart + 140, yStart - 10, xStart + 140, yStart + 10 );
  gc.strokeLine( xStart + 150, yStart - 5, xStart + 150, yStart + 5 );
  gc.fillText( "Power source", xStart + 120, yStart - 20 );

  // draw the light bulb
  gc.strokeOval( xStart + 280, yStart + 80, 40, 40 );
  gc.fillText( "Light bulb", xStart + 330, yStart + 100 );
 }

 public void drawSwitchAndBulb( GraphicsContext gc )
 {
  if ( switchClosed )
    gc.setStroke( Color.GREEN.darker( ) );
  else
    gc.setStroke( Color.RED );

  gc.strokeOval( xStart + 100, yStart + 200, 10, 10);
  gc.strokeOval( xStart + 150, yStart + 200, 10, 10);

  if ( switchClosed )
  {
   gc.strokeLine( xStart + 105, yStart + 200, xStart + 155, yStart + 200 );
   gc.setFill( Color.YELLOW );
   gc.fillOval( xStart + 280, yStart + 80, 40, 40 );
  }
  else
  {
   gc.strokeLine( xStart + 105, yStart + 200, xStart + 155, yStart + 180 );
  }
 }
}
