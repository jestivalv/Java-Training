/* HanoiController Class
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

public class HanoiController 
{
 private HanoiDrawing drawing;
  
 @FXML private BorderPane bp;
 @FXML private Label message;
 @FXML private TextField userInput;
 @FXML private Button run;

 private Pane pane;
 private Canvas canvas; 
 private GraphicsContext gc;
 
 private boolean started;
 private int numberOfDisks;
 
 public void initialize( )
 { 
   drawing = new HanoiDrawing( );
    
   pane = new Pane( );
   bp.setCenter( pane );
   canvas = new Canvas( Dimensions.APP_WIDTH - Dimensions.APP_PADDING, 
                        Dimensions.APP_HEIGHT - Dimensions.APP_PADDING );
   pane.getChildren( ).add( canvas );
   gc = canvas.getGraphicsContext2D( ); 
 }
  
 @FXML protected void run( ActionEvent event ) 
 { 
   disableButtons( true );
   // check if input value is valid 
   boolean goodInput = false;
   try
   {
       String input = userInput.getText( );
       if ( input != null )
       {
         numberOfDisks = Integer.parseInt( input );
         if ( numberOfDisks < 1 || numberOfDisks > 9 )
         {
           numberOfDisks = 4;
           userInput.setText( "4" );  
         }
         drawing.setDisks( numberOfDisks );
         drawing.reset( );
         goodInput = true;
         // update message in label
         message.setText( "Enter an integer between 1 and 9" );
         // drawing.printMe( );
         started = false;
         gc.clearRect( 0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT ); 
         drawing.draw( gc );
         Pause.wait( 1.0 );
       }
   }
   catch ( Exception e )
   {
        // place message in label
        message.setText( "Enter an integer between 1 and 9" );
        disableButtons( false );
   }
   
   if ( goodInput )
   {
      drawing.recursiveTOfH( numberOfDisks, 0, 2, 1 );
      startAnimation( );
   }
 }
 
 public void disableButtons( boolean state )
 {
   run.setDisable( state );
 }
 
 public void startAnimation( ) 
 { 
   HanoiAnimationTimer timer = new HanoiAnimationTimer( );
   timer.start( );
 }
   
 private class HanoiAnimationTimer extends AnimationTimer 
 {
   @Override
   public void handle( long now ) 
   {      
     if ( started )
     {
       Pause.wait( 2.0 ); 
       gc.clearRect( 0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT );  

       // update screen 
       drawing.updateTowers( );       
       drawing.draw( gc ); 
         
       if ( drawing.done( ) )
       {
         stop( );
         disableButtons( false );  
       }
     }
     started = true;
   }
 }
}