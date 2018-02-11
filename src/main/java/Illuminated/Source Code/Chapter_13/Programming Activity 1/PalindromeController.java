/* PalindromeController Class
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

public class PalindromeController 
{
 private PalindromeDrawing drawing;
  
 @FXML private BorderPane bp;
 @FXML private TextField userInput;
 @FXML private Button check;

 private Pane pane;
 private Canvas canvas; 
 private GraphicsContext gc;
 
 private boolean result;
 
 public void initialize( )
 { 
   drawing = new PalindromeDrawing( );
    
   pane = new Pane( );
   bp.setCenter( pane );
   canvas = new Canvas( Dimensions.APP_WIDTH - Dimensions.APP_PADDING, 
                        Dimensions.APP_HEIGHT - Dimensions.APP_PADDING );
   pane.getChildren( ).add( canvas );
   gc = canvas.getGraphicsContext2D( ); 
 }
  
 @FXML protected void check( ActionEvent event ) 
 {
   drawing.reset( );
   String word = userInput.getText( );
   if ( word.length( ) > 0 && word.length( ) <= 26 )
   {
      drawing.setPalString( word );
      result = drawing.recursivePalindrome( word );
      drawing.setResult( result );
        
      startAnimation( );  
      disableButtons( false ); 
   } else
      userInput.setText( "enter 1-26 characters" );  
 }
 
 public void disableButtons( boolean state )
 {
   check.setDisable( state );
 }
 
 public void startAnimation( ) 
 {
   PalindromeAnimationTimer timer = new PalindromeAnimationTimer( );
   timer.start( );
 }
   
 private class PalindromeAnimationTimer extends AnimationTimer 
 {
   @Override
   public void handle( long now ) 
   {       
     gc.clearRect( 0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT );  

     // update screen        
     drawing.draw( gc );
         
     if ( drawing.done( ) )
       stop( );
     
     Pause.wait( 2.0 );
   }
 }
}