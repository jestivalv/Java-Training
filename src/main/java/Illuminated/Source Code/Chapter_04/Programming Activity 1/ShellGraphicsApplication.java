/* A Shell for creating graphics applications
   Anderson, Franceschi
*/

import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
 
public class ShellGraphicsApplication extends Application 
{
    @Override
    public void start( Stage stage ) 
    {
        // set up window title and size
        GraphicsContext gc = JIGraphicsUtility.setUpGraphics( 
                  stage, "Shell Graphics Application", 700, 400 );
        
        // your graphics code goes here
                  
    }    
    public static void main( String [] args ) 
    {
        launch( args );
    }    
}