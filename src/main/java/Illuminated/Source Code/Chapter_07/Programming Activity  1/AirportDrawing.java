/* AiportDrawing Class
* Anderson, Franceschi
*/

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AirportDrawing
{
  private int index;
  private Airport airport1, airport2;
  
  private String action1 [] = 
    { "Two airport object references declared:",
      "Instantiated airport1 using default constructor:",
      "Set the airport1 code to IAD:",
      "Set the number of gates to 30:",
      "Attempted to set the number of gates to -1:",
      "Instantiated airport2 using overloaded constructor:",
      "Actions are complete"                                          
    };
                     
  private String action2 [] = 
    { "Airport airport1, airport2;",
      "airport1 = new Airport( );",
      "airport1.setAirportCode( \"IAD\" );",
      "airport1.setGates( 30 );",
      "airport1.setGates( -1 );",
      "airport2 = new Airport( \"JFK\", 69 );",
      ""              
    };
                    
  public AirportDrawing( )
  {    
    index = 0;
  }
  
  // Draws state of the code; called before update executes
  public void draw( GraphicsContext gc )
  {
    gc.clearRect( 0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT );
       
    Font largeFont = new Font( Dimensions.LARGE_FONT_SIZE );
    gc.setFont( largeFont );   
       
    int boxL = 150, boxH = 40;
    int sX = 100;

    int sY = 75;
    if ( airport1 != null )
    {
        // object reference box
        gc.setFill( Color.BLACK );
        gc.strokeRect( sX, sY, boxL, boxH );
        gc.fillText( "airport1", sX, sY - 20 );
        draw( gc, sX, sY, airport1 ); // draw airport object
    }
    else
    {
        // indicate null reference
        gc.setFill( Color.BLACK );
        gc.strokeRect( sX, sY, boxL, boxH );
        gc.fillText( "airport1", sX, sY - 20 );
        gc.setFill( Color.BLUE );
        gc.fillText( "null", sX + 30, sY + 30 );
    }

    sY = sY + 6 * boxH;
    if ( airport2 != null )
    {
        // object reference box
        gc.setFill( Color.BLACK );
        gc.strokeRect( sX, sY, boxL, boxH );
        gc.fillText( "airport2", sX, sY - 20 );
        draw( gc, sX, sY, airport2 ); // draw airport object
    }
    else
    {
        // indicate null reference
        gc.setFill( Color.BLACK );
        gc.strokeRect( sX, sY, boxL, boxH );
        gc.fillText( "airport2", sX, sY - 20 );
        gc.setFill( Color.BLUE );
        gc.fillText( "null", sX + 30, sY + 30 );
    }

    // display action at bottom of screen
    gc.setFill( Color.BLUE );
    gc.fillText( action1[index], 40, sY + 6 * boxH );
    gc.fillText( action2[index], 70, sY + 6 * boxH + 50 );
  }
  
  private void draw( GraphicsContext gc, int sX, int sY, Airport a )
  {
    int boxL = 150, boxH = 40;

    // arrow
    gc.setStroke( Color.BLACK );
    gc.strokeLine( sX + boxL, sY + boxH / 2,
                 sX + boxL + 90, sY + boxH / 2 );
    gc.strokeLine( sX + boxL + 90, sY + boxH / 2,
                 sX + boxL + 90, sY + boxH * 2 );
    gc.strokeLine( sX + boxL + 90 - 10, sY + boxH * 2 - 10,
                 sX + boxL + 90, sY + boxH * 2 );
    gc.strokeLine( sX + boxL + 90 + 10, sY + boxH * 2 - 10,
                 sX + boxL + 90, sY + boxH * 2 );

    // airportCode
    gc.setFill( Color.BLACK );
    gc.fillText( "airport code", sX + boxL - 150, sY + 2 * boxH + 30 );
    gc.strokeRect( sX + boxL + 40, sY + 2 * boxH, boxL, boxH );
    gc.setFill( Color.BLUE );
    gc.fillText( a.getAirportCode( ),
                  sX + boxL + 40 + 10, sY + 2 * boxH + 30 );

    // gates
    gc.setFill( Color.BLACK );
    gc.fillText( "gates", sX + boxL - 150, sY + 3 * boxH + 30 );
    gc.strokeRect( sX + boxL + 40, sY + 3 * boxH, boxL, boxH );
    gc.setFill( Color.BLUE );
    gc.fillText( Integer.toString( a.getGates( ) ),
                  sX + boxL + 40 + 10, sY + 3 * boxH + 30 );
  }

  public void update( )
  {
    index++;
    if ( index == 1 )
      airport1 = new Airport( );
    
    /* Set the airport code to IAD */
    if ( index == 2 )
      airport1.setAirportCode( "IAD" );

    /*  Set the number of gates to 30 */
    if ( index == 3 )
      airport1.setGates( 30 );
    
    /*  Set the number of gates to -1, an invalid value */
    if ( index == 4 )
      airport1.setGates( -1 );

    /*  Instantiate a second airport object using non-default constructor*/
    if ( index == 5 )
      airport2 = new Airport( "JFK", 69 );
   
  }
  
  public boolean done( )
  {
    return index >= action1.length;
  } 
}