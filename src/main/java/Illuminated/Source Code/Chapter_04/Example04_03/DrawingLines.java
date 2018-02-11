/* Drawing Lines
   Anderson, Franceschi
*/

import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;
 
public class DrawingLines extends Application 
{
    @Override
    public void start( Stage stage ) 
    {
        final int WIDTH = 700;
        final int HEIGHT = 400;
        // set up window title and size
        GraphicsContext gc = JIGraphicsUtility.setUpGraphics( 
                  stage, "Drawing Lines", WIDTH, HEIGHT );
                  
        // draw a vertical black line
        gc.strokeLine( 100, 125, 100, 300 );
         
        // draw a horizontal red line
        gc.setStroke( Color.RED );
        gc.setLineWidth( 5 ); // widen the line
        gc.strokeLine( 300, 75, 550, 75 ); 
        
        // draw a diagonal line in a random color
        Random rand =  new Random( );
        int red = rand.nextInt( 0xFF );
        int green = rand.nextInt( 0xFF ); 
        int blue = rand.nextInt( 0xFF );
        Color randomColor = Color.rgb( red, green, blue );       
        gc.setStroke( randomColor );
        
        gc.strokeLine( 0, 0, WIDTH - 1, HEIGHT - 1 );
    }    
    
    public static void main( String [] args ) 
    {
        launch( args );
    }    
}