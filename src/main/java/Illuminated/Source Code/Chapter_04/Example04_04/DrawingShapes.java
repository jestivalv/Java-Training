/* Drawing Shapes
   Anderson, Franceschi
*/

import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 
public class DrawingShapes extends Application 
{
    @Override
    public void start( Stage stage ) 
    {
        // set up window title and size
        GraphicsContext gc = JIGraphicsUtility.setUpGraphics( 
                  stage, "Drawing Shapes", 700, 400 );
        // specify colors
        gc.setFill( Color.CYAN );
        gc.setStroke( Color.ORANGE ); 
              
        // draw rectangles
        gc.strokeRect( 100, 50, 80, 200 );  // outlined rectangle
        gc.fillRect( 275, 75, 160, 160 );   // solid square
        
        // draw ovals
        gc.fillOval( 100, 50, 80, 200 );    // oval inside rectangle
        gc.strokeOval( 100, 275, 200, 80 );  // outlined oval
        
        // draw circle using center point and radius
        gc.setFill( Color.MEDIUMSEAGREEN );
        int centerX = 550, centerY = 275;
        int radius = 75;
        gc.fillOval( centerX - radius, centerY - radius, 
                     radius * 2, radius * 2 );         
    }    
    
    public static void main( String [] args ) 
    {
        launch( args );
    }    
}