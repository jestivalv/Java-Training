/** ButtonPracticeController
*   Anderson, Franceschi
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

public class ButtonPracticeController 
{
  private Circuit circuit;
  
  @FXML private BorderPane bp;
  @FXML private HBox hBox;
  @FXML private Button open;
  @FXML private Button close;

  private Pane pane;
  private Canvas canvas; 
  private GraphicsContext gc;

  public void initialize( )
  { 
    circuit = new Circuit( );   

    Insets insets = new Insets( Dimensions.APP_PADDING, Dimensions.APP_PADDING, 
                                Dimensions.APP_PADDING, Dimensions.APP_PADDING );
    bp.setPadding( insets );
    hBox.setPadding( insets );
    
    pane = new Pane( );
    bp.setCenter( pane );
    canvas = new Canvas( Dimensions.APP_WIDTH - 2 * Dimensions.APP_PADDING, 
                         Dimensions.APP_HEIGHT - 6 * Dimensions.APP_PADDING );
    pane.getChildren( ).add( canvas );
    gc = canvas.getGraphicsContext2D( ); 
    
    resetCanvas( Color.rgb( 245, 245, 245 ) );
    circuit.draw( gc );
  }

  // ***** 3. Student code restarts here
  // Code the flip method.
  // To open the switch, call the open method 
  //   with circuit, the object reference of the 
  //   Circuit object.
  //   The open method does not take any parameters.
  // To close the switch, call the close method 
  //   with circuit.
  //   The close method does not take any parameters.
  // The last statement of the method should be
  //   animate( );  
  


  // end of task 3

 private void animate( )
 {
   resetCanvas( Color.rgb( 245, 245, 245 ) );   
   circuit.draw( gc );
 }

 private void resetCanvas( Color color ) 
 {
   GraphicsContext gc = canvas.getGraphicsContext2D( );
   gc.setFill( color );
   gc.fillRect( 0, 0, canvas.getWidth( ), canvas.getHeight( ) );
 }

}