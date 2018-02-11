/* A Client for a graphics class
   Anderson, Franceschi
*/

import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
 
public class SpriteClient extends Application 
{
    private Sprite s1, s2, s3;
 
    @Override
    public void start( Stage stage ) 
    {
        GraphicsContext gc = JIGraphicsUtility.setUpGraphics( 
                  stage, "Sprites", 700, 400 );
        s1 = new Sprite( 100, 50, .5 );
        s2 = new Sprite( 225, 100, 1 );
        s3 = new Sprite( ).setCoordinates( 400, 150 ).setScale( 1.5 );
       
        s1.draw( gc );
        s2.draw( gc );
        s3.draw( gc );
    }    
    
    public static void main( String [] args ) 
    {
        launch( args );
    }    
}