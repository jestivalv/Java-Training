/* Using GridPane to organize our window
   Anderson, Franceschi
*/

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javax.swing.JOptionPane;

public class GameView extends GridPane
{
 private Button [][] squares;
 private TilePuzzle game;

 /** Constructor
 * @param newSide, an int, the number of rows and columns 
 *                         in the grid of buttons
 */
 public GameView( int newSide )
 {
  game = new TilePuzzle( newSide );
  setUpGameGUI( );
 }

 /** setUpGame method
 * @param newSide, an int, the number of rows and columns 
 *                         in the grid of buttons
 */
 public void setUpGame( int newSide )
 {
  game.setUpGame( newSide );
  setUpGameGUI( );
 }

 /** setUpGameGUI method
 * creates the GUI
 */
 public void setUpGameGUI( )
 {
   // remove all components and constraints     
   getChildren( ).clear( );
   getColumnConstraints( ).clear( );
   getRowConstraints( ).clear( );
    
   // set up grid
   ColumnConstraints col = new ColumnConstraints( );
   col.setPercentWidth( 100.0 / game.getSide( )  );
   RowConstraints row = new RowConstraints( );
   row.setPercentHeight( 100.0 / game.getSide( ) );
   for ( int i = 0; i < game.getSide( ); i++ )
     getColumnConstraints( ).add( col );
   for ( int j = 0; j < game.getSide( ); j++ )    
     getRowConstraints( ).addAll( row ); 

   squares = new Button [game.getSide( )][game.getSide( )];
   ButtonHandler bh = new ButtonHandler( );

   for ( int i = 0; i < game.getSide( ); i++ )
   {
      for ( int j = 0; j < game.getSide( ); j++ )
      {
        squares[i][j] = new Button( game.getTiles( )[i][j] );        
        
        // add the button
        add( squares[i][j], j, i );

        // make button fill up available width and height
        squares[i][j].setMaxWidth( Double.MAX_VALUE );
        squares[i][j].setMaxHeight( Double.MAX_VALUE );
  
        // register listener on button
        squares[i][j].setOnAction( bh );
      }
   }
 }

 /** update method
 * @param row, an int, the row index
 * @param col, an int, the column index 
 * updates this GameView based on the state of game
 * checks if the user won
 */
 private void update( int row, int col )
 {
   for ( int i = 0; i < game.getSide( ); i++ )
     for ( int j = 0; j < game.getSide( ); j++ )
       squares[i][j].setText( game.getTiles( )[i][j] );  

   if ( game.won( ) )
     JOptionPane.showMessageDialog( null,
              "Congratulations! You won!\nSetting up new game" );
 }

 /** private class ButtonHandler
 * processes button clicked by user and plays
 */
 private class ButtonHandler implements EventHandler<ActionEvent>
 {
  public void handle( ActionEvent event )
  {
   for ( int i = 0; i < game.getSide( ); i++ )
   {
    for ( int j = 0; j < game.getSide( ); j++ )
    {
     if ( event.getSource( ) == squares[i][j] )
     {
       if ( game.tryToPlay( i, j ) )
          update( i, j );
       return;
     } 
    }
   }
  }
 }
}
