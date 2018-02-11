/* Drawing a Sprite
   Anderson, Franceschi
*/

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 
public class DrawingASprite extends Application 
{
    @Override
    public void start( Stage stage ) 
    {
        // set up window title and size
        GraphicsContext gc = JIGraphicsUtility.setUpGraphics( 
                  stage, "Drawing a Sprite", 700, 400 );
                  
       // drawing the sprite
       int sX = 275;
       int sY = 100;
       gc.setFill( Color.CORAL ); // body
       gc.fillOval( sX, sY + 20, 120, 160 );
       gc.setFill( Color.DARKGOLDENROD ); // hat
       gc.fillRect( sX + 30, sY, 60, 30 );
       gc.setStroke( Color.DARKGOLDENROD ); // hat brim
       gc.setLineWidth( 3 );
       gc.strokeLine( sX, sY + 30, sX + 120, sY + 30 );
       gc.setFill( Color.CHOCOLATE ); // eye
       gc.fillOval( sX + 80, sY + 60, 24, 16 );
       gc.setFill( Color.DARKSALMON ); // feet
       gc.setLineWidth( 1 );
       gc.fillOval( sX + 64, sY + 166, 60, 16 );
       gc.strokeOval( sX + 64, sY + 166, 60, 16 );
       gc.fillOval( sX + 36, sY + 170, 60, 16 );
       gc.strokeOval( sX + 36, sY + 170, 60, 16 );
    }    
    
    public static void main( String [] args ) 
    {
        launch( args );
    }    
}