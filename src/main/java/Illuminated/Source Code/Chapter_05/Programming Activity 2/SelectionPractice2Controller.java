/** SelectionPractice2Controller
    Anderson, Franceschi
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

public class SelectionPractice2Controller 
{
 private final int SIZE = 6;

 public static boolean [] array;
 private static int count1 = 0;
 private static int current1 = -1;

 private int key;
 private MultiPath mp;
  
 @FXML private BorderPane bp;
 @FXML private HBox hBox1;
  
 @FXML private Label message;
 @FXML private TextField scoreInput;
 @FXML private Button go;
 private int activity; // 0=fill; 1=print; 2=set; 3=count; 4=find

 private Pane pane;
 private Canvas canvas; 
 private GraphicsContext gc;
 
 private int index;
 private int value;

   // ***** 1. student writes this method
   public void workWithSwitch( int value )
   {
    //
    // Student code starts here
    //
   
   
   
    //
    // Student code ends here
    //
   }
   // end of workWithSwitch

 public void initialize( )
 {   
   array = new boolean[SIZE];

   // fill with values false
   for ( int i = 0; i < array.length; i++ )
       array[i] =  false;

   mp = new MultiPath( array, count1, current1 );
    
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
         // delete message in label
         message.setText( "Thank you" );
       }
   }
   catch( Exception e )
   {
        // place message in label
        message.setText( "Enter an int" );
        disableButtons( false );
   }
   
   if ( goodInput )
   {
      mp.setControl( true );
      workWithSwitch( key );         
   }
 }
 
 private void animate( int index, int value )
 {
   this.index = index;
   this.value = value;

   mp.setCurrent( value );
   mp.setPath( index, true );
   mp.addToCount( );
   AnimationTimer timer = new ArrayAnimationTimer( );
   timer.start( );   
 }

 public void disableButtons( boolean state )
 {
   go.setDisable( state );
 }

 private class ArrayAnimationTimer extends AnimationTimer 
 {   
   @Override
   public void handle( long now ) 
   {
       gc.clearRect( 0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT );
       mp.draw( gc );
     
       stop( );
       mp.setCount( 0 );
     
       disableButtons( false );       
   }
 }
}