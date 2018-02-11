/* AiportPractice2Controller Class
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

import javax.swing.JOptionPane;

import javafx.animation.AnimationTimer;

public class AirportPractice2Controller 
{
 private AirportDrawing drawing;
  
 @FXML private BorderPane bp;

 private Pane pane;
 private Canvas canvas; 
 private GraphicsContext gc;

 public void initialize( )
 { 
   drawing = new AirportDrawing( );
    
   pane = new Pane( );
   bp.setCenter( pane );
   canvas = new Canvas( Dimensions.APP_WIDTH - Dimensions.APP_PADDING, 
                        Dimensions.APP_HEIGHT - Dimensions.APP_PADDING );
   pane.getChildren( ).add( canvas );
   gc = canvas.getGraphicsContext2D( ); 
    
   startActivity( );
 }
 
 public void startActivity( ) 
 {
   AnimationTimer timer = new ArrayAnimationTimer( );
   timer.start( );
 }
   
 private class ArrayAnimationTimer extends AnimationTimer 
 {
   @Override
   public void handle( long now ) 
   {         
     // update screen        
     drawing.draw( gc ); 
     drawing.update( ); 
     
     if( drawing.done( ) )
       stop( );
       
     Pause.wait( 5.0 );
   }
 }
}