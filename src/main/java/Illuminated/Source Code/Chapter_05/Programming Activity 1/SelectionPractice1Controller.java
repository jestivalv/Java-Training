/* SelectionPractice1Controller
   Anderson, Franceschi
*/

import java.util.Random;

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

public class SelectionPractice1Controller 
{
 private Path pathObject;
  
 private int key;
  
 @FXML private BorderPane bp;
 @FXML private HBox hBox1;
  
 @FXML private Label message;
 @FXML private TextField scoreInput;
 @FXML private Button fill;
 private int activity; // 0=fill; 1=print; 2=set; 3=count; 4=find

 private Pane pane;
 private Canvas canvas; 
 private GraphicsContext gc;
 
 private int score;
 private String result = "";

 public void workWithIfElse( int score )
 {
    String result = "???";
    // ***** Student code starts here
    // If score is greater than 72, assign "over par" to result
    // If score is equal to 72, assign "par" to result
    // If score is less than 72, assign "below par" to result
    //
    
    
        
    //
    // Student code ends here
    //
    animate( score, result );
 }
 // end of workWithIfElse

 public void initialize( )
 {   
   pathObject = new Path( );
    
   Insets insets = new Insets( Dimensions.APP_PADDING, Dimensions.APP_PADDING, 
                               Dimensions.APP_PADDING, Dimensions.APP_PADDING );
   bp.setPadding( insets );
   hBox1.setPadding( insets );
    
   pane = new Pane( );
   bp.setCenter( pane );
   canvas = new Canvas( Dimensions.APP_WIDTH - 2 * Dimensions.APP_PADDING, 
                        Dimensions.APP_HEIGHT - 2 * Dimensions.APP_PADDING );
   pane.getChildren( ).add( canvas );
   gc = canvas.getGraphicsContext2D( ); 
 }

 public void animate( int score, String result )
 {
   this.score = score;
   this.result = result;
 }

 @FXML protected void activity( ActionEvent event ) 
 {
   disableButtons( true );
   // check if input value is valid 
   boolean goodInput = false;
   try
   {
       String answer = scoreInput.getText( );
       if ( answer != null )
       {
         key = Integer.parseInt( answer );
         goodInput = true;
         // update message in label
         message.setText( "Thank you" );
       }
   }
   catch( Exception e )
   {
        // place message in label
        message.setText( "Enter a golf score as an integer" );
        disableButtons( false );
   }
   
   if ( goodInput )
   {
      workWithIfElse( key );
         
      AnimationTimer timer = new ArrayAnimationTimer( );
      timer.start( );
   }
 }

 public void disableButtons( boolean state )
 {
   fill.setDisable( state );
 }
  
 private class ArrayAnimationTimer extends AnimationTimer 
 {
   @Override
   public void handle( long now ) 
   {
     // update screen       
     pathObject.setInputScore( score );
     pathObject.setCodeResult( result );
     pathObject.setSideCorrectColors( );
     pathObject.setSideColors( );
     gc.clearRect( 0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT );
     pathObject.draw( gc );

     stop( );
     disableButtons( false );  
   }
 }
}