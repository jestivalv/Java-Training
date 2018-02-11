/* BarChart Class
* Anderson, Franceschi
*/

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BarChart
{
  public static int XMAX = Dimensions.APP_WIDTH;
  public static int YMAX = 250;

  private int [] oldData;
  private int [] data;
  private int barSize;
  private int xStart;
  private int studentResult;
  private int exactFrequencyCount;
  private int exactMinimum;
  private int key;
  
  private int currentIndex;

  public BarChart( int [] dArray )
  {
    oldData = new int [dArray.length];
    data = new int [dArray.length];
    for ( int i = 0; i < dArray.length; i++ )
    {
        data[i] = dArray[i];
        oldData[i] = dArray[i];
    }
    barSize = ( XMAX - 20 ) / data.length;
    studentResult = -1;
    exactFrequencyCount = -1;
    exactMinimum = -1;
    key = -1;
    currentIndex = 0;
  }
  
  public void setData( int [] dArray )
  {
    for ( int i = 0; i < dArray.length; i++ )
    {
      oldData[i] = data[i];
      data[i] = dArray[i];
    }   
  }
  
  public void incrementCurrentIndex( )
  {
    currentIndex++;
  }

  public boolean checkCurrentIndex( )
  {
    return ( currentIndex >= 0 && currentIndex < data.length );
  }

  public void resetCurrentIndex( )
  {
    currentIndex = 0;
  }

  public void setArray( int [] dArray )
  {
    for ( int i = 0; i < dArray.length; i++ )
    {
        oldData[i] = data[i];
        data[i] = dArray[i];
    }
  }

  public void setKey( int newKey )
  {
    key = newKey;
  }

  public void drawArrayInBlue( GraphicsContext gc )
  {
    xStart = 10;
    gc.setFill( Color.BLUE );
    gc.clearRect( 5, YMAX / 3 - 20 - 15, Dimensions.APP_WIDTH, 20 );
    gc.clearRect( 5, YMAX / 3 + 20 - 15, Dimensions.APP_WIDTH, 20 );

    for ( int i = 0; i < data.length; i++ )
    {
      gc.clearRect( xStart - 1, YMAX - 25 - data[i] - 1, barSize - 5 + 2, data[i] + 2 );
      gc.clearRect( xStart - 1, YMAX - 25 - key - 1, barSize - 5 + 2, key + 2 );

      gc.fillRect( xStart, YMAX - 25 - data[i], barSize - 5, data[i] );
      gc.fillText( String.valueOf( data[i]), xStart + barSize / 4, YMAX - 5 );
      xStart += barSize;
    }
  }

  // Called after fillValues execute
  public void drawFillValues( GraphicsContext gc )
  {
    gc.setFill( Color.BLUE );
    gc.clearRect( 5, YMAX / 3 - 20 - 15, Dimensions.APP_WIDTH, 20 );

    studentResult = ArrayPractice1Controller.getResult( currentIndex );

    exactFrequencyCount = findExactFrequencyCount( key );
    gc.clearRect( 5, YMAX / 3 + 20 - 15, Dimensions.APP_WIDTH, 20 );

    xStart = 10;
    for ( int i = 0; i <= currentIndex; i++ )
    {
      studentResult = ArrayPractice1Controller.getResult( i );
      if ( i < currentIndex )
      {
        gc.setFill( Color.BLUE );
        gc.clearRect( xStart - 1, YMAX - 25 - oldData[i] - 1, barSize - 5 + 2, oldData[i] + 2 );
        gc.clearRect( xStart - 1, YMAX - 25 - data[i] - 1, barSize - 5 + 2, data[i] + 2 );
        gc.clearRect( xStart, YMAX - 5 - 15, 20, 20 );
        gc.setFill( Color.BLUE );

        gc.fillRect( xStart, YMAX - 25 - data[i], barSize-5, data[i] );
        gc.fillText( String.valueOf( data[i] ), xStart + barSize / 4, YMAX - 5 );
      }
      else if ( i == currentIndex )
      {
        gc.setStroke( Color.RED );
        gc.setFill( Color.RED );
        gc.clearRect( xStart - 1, YMAX - 25 - oldData[i] - 1, barSize - 5 + 2, oldData[i] + 2 );
        gc.clearRect( xStart, YMAX - 5 - 15, 20, 20 );

        gc.fillRect( xStart, YMAX - 25 - data[i], barSize - 5, data[i] );
        gc.strokeRect( xStart, YMAX - 25 - data[i], barSize - 5, data[i] );
        gc.fillText( String.valueOf( data[i] ), xStart + barSize / 4, YMAX - 5 );
      }
      xStart += barSize; 
    }
  }

  // called after setValues executes
  public void drawSetValue( int key, GraphicsContext gc )
  {
    gc.setFill( Color.BLUE );
    gc.clearRect( 5, YMAX / 3 - 20 - 15, Dimensions.APP_WIDTH, 20 );
    studentResult = ArrayPractice1Controller.getResult( currentIndex );
    
    Font mediumFont = new Font( Dimensions.MEDIUM_SMALLER_FONT_SIZE );
    gc.setFont( mediumFont );
    gc.setFill( Color.BLUE );

    gc.fillText( "Setting new array element to " + key, 25, YMAX / 3 - 20 );
    boolean valuesSetResult = checkIfValuesSetCorrectly( );
    gc.clearRect( 5, YMAX / 3 + 20 - 15, Dimensions.APP_WIDTH, 20 );
    String result = "correctly";
    if( !valuesSetResult )
       result = "incorrectly";
    gc.fillText( "Up to index " + currentIndex + ", the new values are set " + result, 5, YMAX / 3 + 20 );

    Font smallFont = new Font( Dimensions.SMALL_FONT_SIZE );
    gc.setFont( smallFont );

    xStart = 10;
    // System.out.print( "current index = " + currentIndex );
    for ( int i = 0; i <= currentIndex; i++ )
    {
      studentResult = ArrayPractice1Controller.getResult( i );
      if ( i < currentIndex )
      {
        gc.setStroke( Color.BLUE );
        gc.setFill( Color.BLUE );
        gc.clearRect( xStart - 1, YMAX - 25 - oldData[i] - 1, barSize - 5 + 2, oldData[i] + 2 );
        gc.clearRect( xStart - 1, YMAX - 25 - data[i] - 1, barSize - 5 + 2, data[i] + 2 );
        gc.clearRect( xStart - 1, YMAX - 25 - data[i] - 1, barSize - 5 + 2, data[i] + 2 );
        gc.clearRect( xStart, YMAX - 5 - 15, 20, 20 );

        gc.fillRect( xStart, YMAX - 25 - data[i], barSize-5, data[i] );
        gc.fillText( String.valueOf( data[i] ), xStart + barSize / 4, YMAX - 5 );
      }
      else if ( i == currentIndex )
      {
        gc.setStroke( Color.RED );
        gc.setFill( Color.RED );
        gc.clearRect( xStart - 1, YMAX - 25 - oldData[i] - 1, barSize - 5 + 2, oldData[i] + 2 );
        gc.clearRect( xStart - 1, YMAX - 25 - data[i] - 1, barSize - 5 + 2, data[i] + 2 );
        gc.clearRect( xStart, YMAX - 5 - 15, 20, 20 );
   
        gc.fillRect( xStart, YMAX - 25 - data[i], barSize - 5, data[i] );
        gc.strokeRect( xStart, YMAX - 25 - data[i], barSize - 5, data[i] );
        gc.fillText( String.valueOf( data[i] ), xStart + barSize / 4, YMAX - 5 );
      }
      xStart += barSize;
    }
  }
  
  public boolean checkIfValuesSetCorrectly( )
  {
    for ( int i = 0; i <= currentIndex; i++ )
    {
      if ( data[i] != key )
      {
        return false;
      }
    }
    return true;
  }

  public void drawFrequency( int key, GraphicsContext gc )
  {
    gc.clearRect( 5, YMAX / 3 - 20 - 15, Dimensions.APP_WIDTH, 20 );

    studentResult = ArrayPractice1Controller.getResult( currentIndex );

    Font mediumFont = new Font( Dimensions.MEDIUM_SMALLER_FONT_SIZE );
    gc.setFont( mediumFont );
    gc.setFill( Color.BLUE );
    
    gc.fillText( "Your current frequency count: " + studentResult, 25, YMAX / 3 - 20 );
    exactFrequencyCount = findExactFrequencyCount( key );
    gc.clearRect( 5, YMAX / 3 + 20 - 15, Dimensions.APP_WIDTH, 20 );
    gc.fillText( "Correct current frequency count: " + exactFrequencyCount, 25, YMAX / 3 + 20 );
    Font smallFont = new Font( Dimensions.SMALL_FONT_SIZE );
    gc.setFont( smallFont );

    xStart = 10;
    for ( int i = 0; i <= currentIndex; i++ )
    {
      if ( data[i] == key )
      {
        gc.setFill( Color.RED );
        gc.fillRect( xStart, YMAX - 25 - data[i], barSize - 5, data[i] );
        gc.fillText( String.valueOf( data[i] ), xStart + barSize / 4, YMAX - 5 );
      }
      else if ( i < currentIndex )
      {
        gc.clearRect( xStart -1, YMAX - 25 - key - 1, barSize - 5 + 2, key + 2 );
        gc.setFill( Color.BLUE );
        gc.fillRect( xStart, YMAX - 25 - data[i], barSize - 5, data[i] );
      }
      else
      {
        gc.setStroke( Color.RED );
        gc.setFill( Color.BLUE );
        gc.fillRect( xStart, YMAX - 25 - data[i], barSize - 5, data[i] );
        gc.strokeRect( xStart, YMAX - 25 - key, barSize - 5, key );
      }
      xStart += barSize;
    }
  }

  public int findExactFrequencyCount( int key )
  {
    int currentCount = 0;
    for ( int i = 0; i <= currentIndex; i++ )
    {
        if ( data[i] == key )
            currentCount++;
    }

    return currentCount;
  }

  public void drawMinimum( GraphicsContext gc )
  {
    Font mediumFont = new Font( Dimensions.MEDIUM_SMALLER_FONT_SIZE );
    gc.setFont( mediumFont );
    gc.setFill( Color.BLUE );
  
    gc.clearRect( 5, YMAX / 3 - 20 - 15, Dimensions.APP_WIDTH, 20 );
    studentResult = ArrayPractice1Controller.getResult( currentIndex );
    gc.setStroke( Color.BLUE );

    gc.fillText( "Your current minimum: " + studentResult, 25, YMAX / 3 - 20 );
    exactMinimum = findSubMinimum( );
    gc.clearRect( 5, YMAX / 3 + 20 - 15, Dimensions.APP_WIDTH, 20 );
    gc.fillText( "Correct current minimum: " + exactMinimum, 25, YMAX / 3 + 20 );
    
    Font smallFont = new Font( Dimensions.SMALL_FONT_SIZE );
    gc.setFont( smallFont );

    xStart = 10;
    boolean first = true;
    for ( int i = 0; i <= currentIndex; i++ )
    {
      if ( data[i] == exactMinimum && first )
      {
        first = false;
        gc.setFill( Color.RED );
        gc.fillRect( xStart, YMAX - 25 - data[i], barSize - 5, data[i] );
        gc.setStroke( Color.RED );
        gc.clearRect( xStart, YMAX - 5 - 15, 20, 20 );
        gc.fillText( String.valueOf( data[i] ), xStart + barSize / 4, YMAX - 5 );
        gc.setFill( Color.BLUE );
      }
      else if ( i < currentIndex )
      {
        gc.clearRect( xStart, YMAX - 5 - 15, 20, 20 );
        gc.fillText( String.valueOf( data[i] ), xStart + barSize / 4, YMAX - 5 );
        gc.clearRect( xStart - 1, YMAX - 25 - data[i] - 1, barSize - 5 + 2, data[i] + 2 );
        gc.setFill( Color.BLUE );
        gc.fillRect( xStart, YMAX - 25 - data[i], barSize - 5, data[i] );
      }
      else
      {
        gc.clearRect( xStart, YMAX - 5 - 15, 20, 20 );
        gc.fillText( String.valueOf( data[i] ), xStart + barSize / 4, YMAX - 5 );
        gc.setStroke( Color.RED );
        gc.setFill( Color.BLUE );
        gc.fillRect( xStart, YMAX - 25 - data[i], barSize - 5, data[i] );
        gc.strokeRect( xStart, YMAX - 25 - data[i], barSize - 5, data[i] );
      }
      xStart += barSize;
    }
  }

  public int findSubMinimum( )
  {
    int minimum = data[0];
    for ( int i = 0; i <= currentIndex; i++ )
    {
        if ( minimum > data[i] )
            minimum = data[i];
    }
    return minimum;
  }
}
