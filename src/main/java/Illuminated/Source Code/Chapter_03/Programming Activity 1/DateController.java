/* DateController Class
*  Anderson, Franceschi
*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.animation.AnimationTimer;

public class DateController 
{
 private DateDrawing drawing;
  
 @FXML private BorderPane bp;

 private Pane pane;
 private Canvas canvas; 
 private GraphicsContext gc;
 private boolean firstTime;
 private AnimationTimer timer;
 private boolean stop;
 
 public void initialize( )
 {  
   pane = new Pane( );
   bp.setCenter( pane );
   canvas = new Canvas( Dimensions.APP_WIDTH - Dimensions.APP_PADDING, 
                        Dimensions.APP_HEIGHT - Dimensions.APP_PADDING );
   pane.getChildren( ).add( canvas );
   gc = canvas.getGraphicsContext2D( );
   
   firstTime = true;
   stop = false;
   
   drawing = new DateDrawing( gc, this ); 
   startActivity( );
 }
 
 public void startActivity( ) 
 {
   timer = new ArrayAnimationTimer( );
   timer.start( );
 }
 
 public void stopAnimation( )
 {
   stop = true;
 }
   
 private class ArrayAnimationTimer extends AnimationTimer 
 {
   @Override
   public void handle( long now ) 
   {         
     if ( firstTime )
     {
       drawing.draw( gc );
       firstTime = false;
     }
     
     try
     {
       drawing.workWithDates( );
     }
     catch ( NullPointerException npe )
     {
       if ( stop || drawing.done( ) )
       {
         npe.printStackTrace( );
         drawing.update( );
         drawing.draw( gc );
         stop( );
       }
     }

     // update screen        
     drawing.update( ); 
     
     if ( stop ) // drawing.done( ) )
     {
       stop( );
     }
      
     Pause.wait( 2.0 );
   }
 }
}