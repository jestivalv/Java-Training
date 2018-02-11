/* Drawing Shapes Using Paths
   Anderson, Franceschi
*/

import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 
public class DrawingPaths extends Application 
{
    @Override
    public void start( Stage stage ) 
    {
        // set up window title and size
        GraphicsContext gc = JIGraphicsUtility.setUpGraphics( 
                  stage, "Using Paths", 700, 400 );
                  
        // drawing a triangle
        // 1. create the path
        gc.beginPath( );
        gc.moveTo( 175, 113 );
        gc.lineTo( 125, 287 );
        gc.lineTo( 225, 287 );
        gc.closePath( );
        
        // 2 draw the path
        gc.setStroke( Color.CRIMSON );
        gc.stroke( );
        
        // draw a hexagon 
        // 1. create the path
        gc.beginPath( );
        gc.moveTo( 350, 200 );
        gc.lineTo( 400, 113 );
        gc.lineTo( 500, 113 );
        gc.lineTo( 550, 200 );
        gc.lineTo( 500, 287 );
        gc.lineTo( 400, 287 );
        gc.closePath( );
        
        // 2. draw the path
        gc.setFill( Color.CORNFLOWERBLUE );
        gc.fill( );
    }    
    
    public static void main( String [] args ) 
    {
        launch( args );
    }    
}