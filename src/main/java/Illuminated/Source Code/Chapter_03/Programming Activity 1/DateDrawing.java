/* DateDrawing Class
*  Anderson, Franceschi
*/

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DateDrawing
{
  private int sX = 50;
  private int sY = 75;
  private int boxL = 150;
  private int boxH = 40; 

  private int index;
  private int count;
  private GraphicsContext gc;
  private DateController dc;
  private int maxI;
  
  private SimpleDate dateObj; // SimpleDate object reference
 
  private String action [] = 
    { "dateObj reference declared",
      "Instantiated dateObj - empty argument list",
      "Set month to birth month",
      "Set day to birth day",
      "Set year to birth year",
      "Set the date to the next day",
      "Set day to 32"  ,
      "Set month to 13",
      "Set object reference to null",
      "Attempt to set the month to 1"                                        
    };
                    
  public void workWithDates( )
  {
    /***** Add your code here *****/
    /***** 1. Instantiate dateObj using an empty argument list  */
    dateObj = new SimpleDate(  );
    animate( 1 );
    
    /***** 2. Set the month to the month you were born */
    
    //animate( 2 );
    
    /***** 3. Set the day to the day of the month you were born */
    
    //animate( 3 );
    
    /***** 4. Set the year to the year you were born */
    
    //animate( 4 );
    
    /***** 5. Call the nextDay method */
    
    //animate( 5 );
    
    /***** 6. Set the day to 32, an illegal value */
    
    //animate( 6 );
    
    /***** 7. Set the month to 13, an illegal value */
    
    //animate( 7 );
    
    /***** 8. Assign the value null to dateObj */
    
    //animate( 8 );
    
    /***** 9. Attempt to set the month to 1 */
    
    //animate( 9 );
    
  }
  
  public DateDrawing( GraphicsContext gc, DateController dc )
  {    
    index = 0;
    count = 1;
    this.gc = gc;
    this.dc = dc;
  }
   
  // Draws state of the code; called before update executes
  public void draw( GraphicsContext gc )
  {   
    gc.clearRect( 0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT );
     
    Font largeFont = new Font( Dimensions.LARGE_FONT_SIZE );
    gc.setFont( largeFont ); 
    
    // display action
    gc.setFill( Color.BLUE );
    gc.fillText( action[index], 50, sY + 13 * boxH / 2 + boxH / 5 );
    gc.setFill( Color.BLACK );

    // object reference
    gc.strokeRect( sX, sY, boxL, boxH );
    gc.fillText( "dateObj", sX, sY - 10 );

    if ( dateObj == null )
    {
      gc.setFill( Color.BLUE );
      gc.fillText( "null", sX + boxL / 5, sY + boxH / 2 + boxH / 5 );
      return;
    }
    gc.setFill( Color.BLACK );

    // arrow
    gc.strokeLine( sX + boxL, sY + boxH / 2,
                sX + boxL + 25, sY + boxH / 2 );
    gc.strokeLine( sX + boxL + 25, sY + boxH / 2,
                sX + boxL + 25, sY + boxH * 2 );
    gc.strokeLine( sX + boxL + 25 - 5, sY + boxH * 2 - 5,
                sX + boxL + 25, sY + boxH * 2 );
    gc.strokeLine( sX + boxL + 25 + 5, sY + boxH * 2 - 5,
                sX + boxL + 25, sY + boxH * 2 );

    // month
    gc.fillText( "month", sX + boxL / 5, sY + 5 * boxH / 2 + boxH / 5 );
    gc.strokeRect( sX + boxL, sY + 2 * boxH, boxL, boxH );
    gc.setFill( Color.BLUE );
    gc.fillText( Integer.toString( dateObj.getMonth( ) ),
                   sX + boxL + 5, sY + 5 * boxH / 2 + boxH / 5 );
    
    // day
    gc.setFill( Color.BLACK );
    gc.fillText( "day", sX + boxL / 5, sY + 7 * boxH / 2 + boxH / 5 );
    gc.strokeRect( sX + boxL, sY + 3 * boxH, boxL, boxH );
    gc.setFill( Color.BLUE );
    gc.fillText( Integer.toString( dateObj.getDay( ) ),
                  sX + boxL + 5, sY + 7 * boxH / 2 + boxH / 5 );
    
    // year
    gc.setFill( Color.BLACK );
    gc.fillText( "year", sX + boxL / 5, sY + 9 * boxH / 2 + boxH / 5 );
    gc.strokeRect( sX + boxL, sY + 4 * boxH, boxL, boxH );
    gc.setFill( Color.BLUE );
    gc.fillText( Integer.toString( dateObj.getYear( ) ),
                  sX + boxL + 5, sY + 9 * boxH / 2 + boxH / 5 );
                  
    gc.setFill( Color.BLACK );
  }
  
  public void update( )
  {
    index++;
  }
  
  public boolean done( )
  {
    return index > action.length;
  } 
  
  public int getIndex( )
  {
    return index;
  }
  
  public void animate( int i )
  {
    // update index
    if ( i > maxI )
      maxI = i;
    if ( i == index )
      draw( gc );
    if ( i == maxI && maxI < index )
    {
      index--;
      // System.out.println( "stop the animation" );
      draw( gc ); 
      dc.stopAnimation( );  
    }
  }
}