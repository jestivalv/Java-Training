/* Drawing Text
   Anderson, Franceschi
*/

import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class DrawingText extends Application 
{
    @Override
    public void start( Stage stage ) 
    {
        // set up window title and size
        GraphicsContext gc = JIGraphicsUtility.setUpGraphics( 
                  stage, "Drawing Text", 700, 400 );
        
        String message = "Programming is not a spectator sport!";          
        gc.setFill( Color.RED );
        
        gc.fillText( message, 100, 100 );
        
        Font largeFont = new Font( 28 );
        gc.setFont( largeFont );
        gc.setStroke( Color.RED );

        gc.strokeText( message, 100, 250 );                       
    }    
    
    public static void main( String [] args ) 
    {
        launch( args );
    }    
}