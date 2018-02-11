/*  Practice using layouts
    Anderson, Franceschi
*/

import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class NestedLayoutPractice extends BorderPane
{
 private GameView gameView;

 private Label bottom;

 // ***** Task 1: declare an HBox named top
 // also declare three Button instance variables
 // that will be added to the HBox top.
 // These buttons will determine the grid size of the game:
 // 3-by-3, 4-by-4, or 5-by-5

 


 // task 1 ends here

 public NestedLayoutPractice( )
 {
  super( );

  // ***** Task 2: student code starts here
  // instantiate the GameView object
  
  // add gameView to the center of this BorderPane
  

  // task 2 ends here

  bottom = new Label( "Have fun playing this Tile Puzzle game" );
  setBottom( bottom );

  // ***** Task 3: Student code restarts here
  // instantiate the HBox component named top
  

  // instantiate the Buttons that determine the grid size
  


  // add the buttons to HBox top
  // make them take all the available space
  


  // add HBox top to this BorderPane as its top component
  

  // task 3 ends here

  // ***** Task 5: Student code restarts here
  // Note: search for and complete Task 4 before performing this task
  // declare and instantiate an EventHandler
  

  // register the handler on the 3 buttons
  // that you declared in Task 1
  


  // task 5 ends here
 }

 // ***** Task 4: Student code restarts here
 // create a private inner class that implements EventHandler
 // your method should identify which of the 3 buttons
 //    was the source of the event
 // depending on which button was pressed,
 //    call the setUpGame method of the GameView class
 //    with arguments 3, 4, or 5
 // the API of that method is:
 //   public void setUpGame( int nSides )

 



 // task 4 ends here
}
