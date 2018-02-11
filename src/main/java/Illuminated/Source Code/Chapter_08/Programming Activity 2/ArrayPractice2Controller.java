/** ArrayPractice2Controller 
*   Anderson, Franceschi
*/
import java.util.*;

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

public class ArrayPractice2Controller 
{
 public final int SIZE = 15;
 
 private BarChart bc;
  
 private int [] arr;
 private int key;
 private static int [] result;
  
 @FXML private BorderPane bp;
 @FXML private HBox hBox1;
 @FXML private HBox hBox2;
 
 @FXML private Button sequentialSearch;
 @FXML private Button bubbleSort;
 private int activity; // 0=sequentialSearch; 1=bubbleSort

 private Pane pane;
 private Canvas canvas; 
 private GraphicsContext gc;
 
 private static int maxIndex = -1;
 private static int found = -1;
 private boolean animate = false;
 private boolean run = false;
 
 public void initialize( )
 { 
   arr = new int [SIZE];
   result = new int [SIZE];
          
   // fill with random numbers between 50 and 80
   for ( int i = 0; i < arr.length; i++ )
     arr[i] = ( int ) ( Math.random( ) * 70 ) + 30;
   bc = new BarChart( arr );
    
   Insets insets = new Insets( Dimensions.APP_PADDING, Dimensions.APP_PADDING, 
                               Dimensions.APP_PADDING, Dimensions.APP_PADDING );
   bp.setPadding( insets );
   hBox1.setPadding( insets );
    
   pane = new Pane( );
   bp.setCenter( pane );
   canvas = new Canvas( Dimensions.APP_WIDTH - 2 * Dimensions.APP_PADDING, 
                        Dimensions.APP_HEIGHT - 6 * Dimensions.APP_PADDING );
   pane.getChildren( ).add( canvas );
   gc = canvas.getGraphicsContext2D( ); 
    
   bc.drawArrayInBlue( gc );
 }

 @FXML protected void activity( ActionEvent event ) 
 {
   bc.drawArrayInBlue( gc );
   if ( event.getSource( ) == sequentialSearch )
   {
     activity = 0;
     getKeyInput( );
     if ( run )
       found = sequentialSearch( key );
     else
       animate = false;
   }
   else if ( event.getSource( ) == bubbleSort )
   {
     activity = 1;
     bubbleSort( );
   }

   if ( animate )
   {
     disableButtons( true );
     bc.clearMessages( gc );
     AnimationTimer timer = new ArrayAnimationTimer( );
     timer.start( );
   }
 }

 public void disableButtons( boolean state )
 {
   sequentialSearch.setDisable( state );
   bubbleSort.setDisable( state );
 }
 
 //  1 ***** student writes this method
 /**  Searches for key in integer array named arr
 //     arr is an instance variable of the class and has been
 //     instantiated and filled with random values.
 //  @param key value to search for
 //  @return  if key is found, the  index of the first element
 //     in array whose value is key; if key is not found,
 //      the method returns -1
 */
 public int sequentialSearch( int key )
 {
   // Note:  To animate the algorithm, put this method call as the
   // first statement in your for loop
   //  animate( i, 0 );
   //         where i is the index of the current array element
    
   
   return 0; // replace this statement with your return statement
 } // end of sequentialSearch

 //  2. *****  student writes this method
 /**  Sorts arr in ascending order using the bubble sort algorithm
 */
 public void bubbleSort( )
 {
   // Note:  To animate the algorithm, put this method call as the
   // last statement in your innermost for loop
   //  animate( i, j );
   //           where i is the value of the outer loop counter
   //            and j is the value of the inner loop counter,
   //            or the index of the current array element
   
 } // end of bubbleSort

 public void animate( int index )
 {
   animate = true;
   maxIndex = index;
 }
 
 public void animate( int i, int j )
 {        
   BubbleSortState bss = new BubbleSortState( i, j, arr );
   bc.addToBSStates( bss );
   animate = true;
 }
     
 public static int getMaxIndex( )
 {
     return maxIndex;
 }

 public static int getFound( )
 {
     return found;
 }
 
 public static int getResult( int index )
 {
     return result[index];
 }
 
 public void getKeyInput( )
 {
   String keyString = "Sequential Search";
   run = false;
   boolean goodInput = false;
   while ( !goodInput || key < 30 || key > 99 )
   {
     try
     {
       TextInputDialog dialog = new TextInputDialog( "" );
       dialog.setTitle( "User Input" );
       dialog.setHeaderText( keyString );
       dialog.setContentText( "Enter an int between 30 and 99" );
       Optional<String> result = dialog.showAndWait( );
       String answer = null;
       if ( result.isPresent( ) ) 
         answer = result.get( );
       if ( answer != null )
       {
         key = Integer.parseInt( answer );
         bc.setKey( key );
         goodInput = true;
         run = true;
       }
       else
       {
         goodInput = false;
         break;
       }
     }
     catch ( Exception e )
     {}
   }
 }

 private class ArrayAnimationTimer extends AnimationTimer 
 {
   @Override
   public void handle( long now ) 
   {
     Pause.wait( .5 );
           
     // update screen       
     if ( activity == 0 )
     {
       bc.drawSequentialSearch( key, gc ); 
       // manage animation sequence
       bc.incrementCurrentIndex( );  
       if ( ! bc.checkCurrentIndexSequentialSearch( ) )
       {
         bc.resetCurrentIndex( );
         stop( );
         disableButtons( false );
       } 

     }
     else if ( activity ==  1)
     {
       bc.drawBubbleSort( gc ); 
       // manage animation sequence
       bc.incrementCurrentIndex( );  
       if ( ! bc.checkCurrentIndexBubbleSort( ) )
       {
         bc.resetCurrentIndex( );
         bc.clearBSStates( );
         stop( );
         disableButtons( false );
       } 
     }          
   }
 }
}