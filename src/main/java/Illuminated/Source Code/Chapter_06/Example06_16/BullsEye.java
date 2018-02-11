/* Bull's-eye Target
   Anderson, Franceschi
*/

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 
public class BullsEye extends Application 
{
 
    @Override
    public void start( Stage stage ) 
    {
        // set up window title and size
        GraphicsContext gc = JIGraphicsUtility.setUpGraphics( 
                  stage, "Bull's Eye", 700, 400 );
                  
       // center of the bull's eye
       final int CENTER_X = 350, CENTER_Y = 200;
       
       // start and end diameter, amount to decrease diameter
       final int START_DIAMETER = 300, END_DIAMETER = 25,
                 DECREMENT = 25;
                 
       // color of first circle
       Color toggleColor = Color.BLACK;
       gc.setFill( toggleColor );
       
       for ( int diameter = START_DIAMETER; diameter >= END_DIAMETER;
                 diameter -= DECREMENT )
       {
          // draw circle with current diameter value
          gc.fillOval( CENTER_X - diameter / 2, CENTER_Y - diameter / 2,
                       diameter, diameter );
          // switch color
          if ( toggleColor.equals( Color.BLACK ) )
               toggleColor = Color.RED;
          else
               toggleColor = Color.BLACK; 
                          
          gc.setFill( toggleColor );                            
       }
    }    
    
    public static void main( String [ ] args ) 
    {
        launch( args );
    }    
}