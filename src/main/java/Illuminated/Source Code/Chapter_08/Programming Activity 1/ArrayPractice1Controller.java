/** ArrayPractice1Controller
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

public class ArrayPractice1Controller 
{
 public final int SIZE = 15;

 private BarChart bc;
  
 private int [] arr;
 private int key;
 private static int [] result;
  
 @FXML private BorderPane bp;
 @FXML private HBox hBox1;
 @FXML private HBox hBox2;
 
 @FXML private Button fill;
 @FXML private Button print;
 @FXML private Button set;
 @FXML private Button count;
 @FXML private Button find;
 private int activity; // 0=fill; 1=print; 2=set; 3=count; 4=find

 private Pane pane;
 private Canvas canvas; 
 private GraphicsContext gc;
 
 private boolean animate = false;
 private boolean run = false;

 public void initialize( )
 { 
   arr = new int [SIZE];
   result = new int [SIZE];
     
   // fill with random numbers between 50 and 80
   for ( int i = 0; i < arr.length; i++ )
     arr[i] = ( int ) ( Math.random( ) * 31 ) + 50;
     
   bc = new BarChart( arr );
    
   Insets insets = new Insets( Dimensions.APP_PADDING, Dimensions.APP_PADDING, 
                               Dimensions.APP_PADDING, Dimensions.APP_PADDING );
   bp.setPadding( insets );
   hBox1.setPadding( insets );
   hBox2.setPadding( insets );
    
   pane = new Pane( );
   bp.setCenter( pane );
   canvas = new Canvas( Dimensions.APP_WIDTH - 2 * Dimensions.APP_PADDING, 
                        Dimensions.APP_HEIGHT - 6 * Dimensions.APP_PADDING );
   pane.getChildren( ).add( canvas );
   gc = canvas.getGraphicsContext2D( ); 
    
   bc.drawArrayInBlue( gc );
 }
 
 // ***** 1. The first method has been coded as an example
 /**  Fills the array with random numbers between 50 and 80.
 *    The instance variable arr is the integer array
 *    to be filled with values
 */
 public void fillValues( )
 {
	Random rand = new Random( );

   for ( int i = 0; i < arr.length; i++ )
   {
     arr[i] = rand.nextInt( 31 ) + 50;
     storeResult( i, arr[i] );  // needed to create visual feedback
   }
   
 }
 // end of fillValues method

 // ***** 2. student writes this method
 /** Prints the array to the console with elements separated
 *     by a space
 *    The instance variable arr is the integer array to be printed
 */
 public void printArray(  )
 {
  // Write your code here:

  
 } // end of printArray method

 // ***** 3. student writes this method
 /** Sets all the elements in the array to parameter value
 *    The instance variable arr is the integer array to be processed
 *    @param  value    the value to which to set the array elements
 */
 public void setValues( int value )
 {
  // Note:  to animate the algorithm, put this method call as the
  // last statement in your for loop
  //            storeResult( i, arr[i] );
  //      where i is the index of the current array element
  // Write your code here:

 
 } // end of setValues method

 // ***** 4 student writes this method
 /** Counts number of elements equal to parameter value
 *    The instance variable arr is the integer array to be processed
 *      @param  value    the value to count
 *      @return   the number of elements equal to value
 */
 public int countFrequency( int value )
 {
    // Note:  to animate the algorithm, put this method call as the
    // last statement in your for loop
    //          storeResult( i, count );
    //         where i is the index of the current array element
    //               count is the variable holding the frequency
    // Write your code here:
    
    
       return 0; // replace this line with your return statement
 } // end of countFrequency method

 // 5 ***** student writes this method
 /** Finds and returns the minimum value in arr
 *    The instance variable arr is the integer array to be processed
         @return the minimum value found in arr
 */
 public int findMinimum(  )
 {
    // Note:  to animate the algorithm, put this method call as the
    // last statement in your for loop
    //        storeResult( i, minimum );
    //            where i is the index of the current array element
    //                  minimum is the variable holding the  minimum
    // Write your code here:
   
   
     return 0; // replace this line with your return statement
 } // end of findMinimum method
//
// End of student code
//


 public void storeResult( int index, int value )
 {
     result[index] = value;
     animate = true;
 }
   
 public static int getResult( int index )
 {
     return result[index];
 }
 
 public void getKeyInput( int a )
 {
   run = false;
   String keyString = "";
   if ( a == 2 )
     keyString = "Set All the Elements to a Value";
   else if ( a == 3 )
     keyString = "Count the Frequency of a Value";

   boolean goodInput = false;
   while ( !goodInput || key < 50 || key > 80 )
   {
     try
     {
       TextInputDialog dialog = new TextInputDialog( "" );
       dialog.setTitle( "User Input" );
       dialog.setHeaderText( keyString );
       dialog.setContentText( "Enter an int between 50 and 80" );
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
         run = false;
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
     if( activity != 1 )
       Pause.wait( .5 );
          
     // update screen       
     if ( activity == 0 )
       bc.drawFillValues( gc ); 
     else if ( activity ==  1)
     {}
     else if ( activity ==  2)
       bc.drawSetValue( key, gc ); 
     else if ( activity ==  3)
       bc.drawFrequency( key, gc );
     else if ( activity ==  4)
       bc.drawMinimum( gc );
          
     bc.incrementCurrentIndex( );  
     if ( ! bc.checkCurrentIndex( ) )
     {
       bc.resetCurrentIndex( );
       stop( );
       disableButtons( false );
     } 
   }
 }
 
 @FXML protected void activity( ActionEvent event ) 
 {
   bc.drawArrayInBlue( gc );
   if ( event.getSource( ) == fill )
   {
     activity = 0;
     fillValues( );
     bc.setData( arr );
   }
   else if ( event.getSource( ) == print )
   {
     activity = 1;
     printArray( );
   } 
   else if ( event.getSource( ) == set )
   {
     activity = 2;
     getKeyInput( activity );
     if ( run ) 
     {
       bc.setKey( key );
       setValues( key );
       bc.setData( arr );
     }
     else
       animate = false;
   }
   else if ( event.getSource( ) == count )
   {
     activity = 3;
     getKeyInput( activity );
     if ( run )
     {
       bc.setKey( key );
       int frequencyResult = countFrequency( key );
     }
     else
       animate = false;
   } 
   else if ( event.getSource( ) == find )
   {
     activity = 4;
     findMinimum( );
   }
   if ( animate )
   {
     disableButtons( true );
     AnimationTimer timer = new ArrayAnimationTimer( );
     timer.start( );
   }
 }

 public void disableButtons( boolean state )
 {
   fill.setDisable( state );
   print.setDisable( state );
   set.setDisable( state );
   count.setDisable( state );
   find.setDisable( state );
 }

}