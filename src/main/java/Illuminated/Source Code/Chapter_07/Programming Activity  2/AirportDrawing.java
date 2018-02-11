/* AirportDrawing Class
*  Anderson, Franceschi
*/

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AirportDrawing
{
  private int boxH = 40;
  private int boxL = 150;
  private int sX = 40;
 
  private int index;
  private String output;
  private Airport airport1, airport2;
  
  private String action1 [] = 
    { "Two airport object references declared:",
      "Instantiated airport1 using overloaded constructor:",
      "Calling toString:",
      "Instantiated airport2 using overloaded constructor:",
      "Getting the value of countAirports:",            
      "Comparing airport1 and airport2 using the == operator ",
      "Comparing airport1 and airport2 using equals:",                 
      "Actions are complete"                                          
    };
                     
  private String action2 [] = 
    { "Airport airport1, airport2;",
      "airport1 = new Airport( \"IAD\", 30 );",
      "System.out.println( airport1.toString( ) );",
      "airport2 = new Airport( \"IAD\", 30 );",
      "System.out.println( \"countAirports is \" +"
                            + "  Airport.getCountAirports( ) );",
      " if ( airport1 == airport2 ) ...",
      " if ( airport1.equals( airport2 ) ) ...",
      ""              
    };
                    
  public AirportDrawing( )
  {    
    index = 0;
    output = "";
  }
  
  // Draws state of the code; called before update executes
  public void draw( GraphicsContext gc )
  {
    int sY = 50;
    gc.clearRect( 0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT );
      
    Font largeFont = new Font( Dimensions.LARGE_FONT_SIZE );
    gc.setFont( largeFont );   

    // countAirports
    gc.setFill( Color.BLACK );
    gc.strokeRect( sX, sY, boxL, boxH );
    gc.fillText( "countAirports", sX, sY - 20 );
    gc.setFill( Color.BLUE );
    gc.fillText( Integer.toString( Airport.getCountAirports( ) ),
                            sX + 30, sY + 30 );   
    
    sY = sY + 5 * boxH / 2;                             
    if ( airport1 != null )
    {
        // object reference box
        gc.setFill( Color.BLACK );
        gc.strokeRect( sX, sY, boxL, boxH );
        gc.fillText( "airport1", sX, sY - 20 );
        drawAirport( gc, sX, sY, airport1 ); // draw airport object
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
        drawAirport( gc, sX, sY, airport2 ); // draw airport object
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
    gc.fillText( action1[index], sX, sY + 6 * boxH );
    gc.fillText( action2[index], sX + 20, sY + 6 * boxH + 50 );
    
    // display output at bottom of screen'
    drawOutput( gc );
  }
  
  private void drawAirport( GraphicsContext gc, int sX, int sY, Airport a )
  {
    // int boxL = 150, boxH = 40;
  
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
  
  private void drawOutput( GraphicsContext gc )
  {
    // int boxH = 40;
    gc.setFill( Color.GREEN );
    gc.fillText( output, 70, 17 * boxH + 50 );
  }

  public void update( )
  {
    index++;
    if ( index == 1 )
      airport1 = new Airport( "IAD", 30 );
    
    /* Call toString( ) */
    if ( index == 2 )
      output = airport1.toString( );

    /* Instantiate a second airport object using overloaded constructor */
    if ( index == 3 )
    {
      airport2 = new Airport( "IAD", 30 );
      output = "";  
    }
    
    /* Get the value of countAirports */
    if ( index == 4 )
      output = "countAirports is " + Airport.getCountAirports( );

    /* Compare the two airport objects using == */
    if ( index == 5 )
    {
      if ( airport1 == airport2 )
        output = "Using ==, airport1 and airport2 are equal";
      else
        output = "Using ==, airport1 and airport2 are not equal";
    }

    /* Compare the two airport objects using equals */
    if ( index == 6 )
    {
      if ( airport1.equals( airport2 ) )
        output = "Using equals, airport1 and airport2 are equal";
      else
        output = "Using equals, airport1 and airport2 are not equal";
    }
    
    if ( index == 7 )
      output = "";
  }
  
  public boolean done( )
  {
    return index >= action1.length;
  } 
}