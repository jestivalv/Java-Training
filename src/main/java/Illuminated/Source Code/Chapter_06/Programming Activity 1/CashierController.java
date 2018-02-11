/* CashierController Class
*  Anderson, Franceschi
*/
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;

public class CashierController 
{
 private Item item;
 private double currentStudentSubTotal;
 
 private CashierDrawing drawing;
  
 @FXML private BorderPane bp;
 
 private Pane pane;
 private Canvas canvas; 
 private GraphicsContext gc;
 
 private boolean result;
 
 public void initialize( )
 { 
   drawing = new CashierDrawing( );
    
   pane = new Pane( );
   bp.setCenter( pane );
   canvas = new Canvas( Dimensions.APP_WIDTH - Dimensions.APP_PADDING, 
                        Dimensions.APP_HEIGHT - Dimensions.APP_PADDING );
   pane.getChildren( ).add( canvas );
   gc = canvas.getGraphicsContext2D( ); 
   
   drawing.checkout( );
   drawing.addDivider( );
     
   item = drawing.getSubTotal( 0 ).getItem( );
   currentStudentSubTotal = drawing.getSubTotal( 0 ).getSubTotal( );
   item.setCurrentStudentSubTotal( currentStudentSubTotal );
   item.updateCurrentCorrectSubTotal( );
         
   startAnimation( );  
 }

 public void startAnimation( ) 
 {
   ItemAnimationTimer timer = new ItemAnimationTimer( );
   timer.start( );
 }
      
 private class ItemAnimationTimer extends AnimationTimer 
 {
   @Override
   public void handle( long now ) 
   {         
     // update screen  
     gc.setFill( Color.rgb( 205, 205, 205 ) );
     gc.fillRect( 0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT );       
     item.draw( gc, Color.rgb( 205, 205, 205 ) ); 
         
     if ( item.done( ) )
     {
       stop( );
       drawing.incrementIndex( );
       // get next item
       if ( ! ( drawing.done( ) ) )
       {
        double currentCorrectSubTotal = item.getCurrentCorrectSubTotal( );
        item = drawing.getSubTotal( drawing.getIndex( ) ).getItem( );
        currentStudentSubTotal = drawing.getSubTotal( drawing.getIndex( ) ).getSubTotal( );
        item.setCurrentStudentSubTotal( currentStudentSubTotal );
        item.setCurrentCorrectSubTotal( currentCorrectSubTotal );
        item.updateCurrentCorrectSubTotal( );
        item.resetX( );
        startAnimation( );
       }
      }
     
      Pause.wait( 0.05 );
      item.addToX( 2 );
   }
 }
}