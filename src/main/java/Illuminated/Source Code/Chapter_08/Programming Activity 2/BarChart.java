/* BarChart Class
*  Anderson, Franceschi
*/

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.ArrayList;

public class BarChart
{
  public static int XMAX = Dimensions.APP_WIDTH;
  public static int YMAX = 400;

  private int [] oldData;
  private int [] data;
  private int barSize;
  private int xStart;
  private int studentResult;
  private int exactFrequencyCount;
  private int exactMinimum;
  private int key;
  
  private int currentIndex;
  
  private ArrayList<BubbleSortState> bsStates;

  public BarChart( int [] dArray )
  {
    bsStates = new ArrayList<BubbleSortState>( );
  
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
  
  public void addToBSStates( BubbleSortState bss )
  {
    bsStates.add( bss );
  }
  
  public void clearBSStates( )
  {
    bsStates.clear( );
  }
  
  public boolean checkIfArraySorted( int [] arr )
  {
    boolean sorted = true;
    for ( int i = 0; i < arr.length - 1; i++ )
    {
      if ( arr[i] > arr[i+1] )
        sorted = false;
    }
    return sorted;
  }
  
  public void selectionSort( int [] arr )
  {
    int temp, indexOfMax;
    for ( int i = 0; i < arr.length - 1; i++ )
    {
 	    // find index of largest value in the subarray
       indexOfMax = 0;
       for ( int j = 1; j < arr.length - i; j++ )
       {
		    if ( arr[j] > arr[indexOfMax] )
			   indexOfMax = j;
       }
		  
	    temp = arr[indexOfMax];
	    arr[indexOfMax] = arr[arr.length - i - 1];
	    arr[arr.length -i - 1] = temp;
    }
  } 
  
  public String checkIfSameArray( int [] arr )
  {
    String result = "";
    if ( arr.length != oldData.length )
      result = "ERROR: Your array no longer has the same length!";
    else
    {
      int [] arrCopy = new int[arr.length];
      for ( int i = 0; i < arr.length; i++ )
        arrCopy[i] = arr[i];
      selectionSort( arrCopy );
      // sort oldData
      selectionSort( oldData );
      // compare oldData and arr
      for ( int i = 0; i < arrCopy.length; i++ )
      { 
        if ( arrCopy[i] != oldData[i] )
          result = "ERROR: Your array has changed";
      }
    }
    System.out.println( );
    return result;
  }
  
  public void incrementCurrentIndex( )
  {
    currentIndex++;
  }

  public boolean checkCurrentIndexBubbleSort( )
  {
    return ( currentIndex >= 0 && currentIndex < bsStates.size( ) );
  }

  public boolean checkCurrentIndexSequentialSearch( )
  {
    return ( currentIndex >= 0 && currentIndex <= ArrayPractice2Controller.getMaxIndex( ) );
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
    gc.setFill( Color.NAVY );
    gc.setStroke( Color.NAVY );
    Font mediumFont = new Font( Dimensions.MEDIUM_SMALLER_FONT_SIZE );
    gc.setFont( mediumFont );
    gc.clearRect( xStart, YMAX - 5 - 15, Dimensions.APP_WIDTH, 20  );

    for ( int i = 0; i < data.length; i++ )
    {
      gc.clearRect( xStart - 1, YMAX - 25 - 2 * data[i] - 1, barSize - 5 + 2, 2 * data[i] + 2 );
      gc.clearRect( xStart - 1, YMAX - 25 - key - 1, barSize - 5 + 2, key + 2 );

      gc.fillRect( xStart, YMAX - 25 - 2 * data[i], barSize-5, 2 * data[i] );
      gc.fillText( String.valueOf( data[i]), xStart + barSize / 4, YMAX - 5 );
      xStart += barSize;
    }
  }
  
  public void clearMessages( GraphicsContext gc )
  {
    // clear messages
    gc.clearRect( 0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT );
    
    // redraw in blue
    drawArrayInBlue( gc );
  }

  public void drawSequentialSearch( int key, GraphicsContext gc )
  {
    gc.setFill( Color.NAVY );
    gc.clearRect( 25, 115 - 15, Dimensions.APP_WIDTH, 20 );
    studentResult = ArrayPractice2Controller.getResult( currentIndex );
    gc.setStroke( Color.NAVY );
    
    Font mediumFont = new Font( Dimensions.MEDIUM_FONT_SIZE );
    gc.setFont( mediumFont );
    gc.clearRect( 25, YMAX / 5 - 20, Dimensions.APP_WIDTH, 20 );
    gc.fillText( "Searching for " + key, 25, YMAX / 7 );
    
    String  message;
    int found = ArrayPractice2Controller.getFound( );
    if ( found != -1 )
      message = "You found " + key + " at index " + found;
    else
      message = "You did not find " + key;  

    if ( currentIndex == ArrayPractice2Controller.getMaxIndex( ) )
      gc.fillText( message, 25, YMAX / 4 );
      
    Font smallFont = new Font( Dimensions.SMALL_FONT_SIZE );
    gc.setFont( smallFont );

    xStart = 10;
    for ( int i = 0; i <= currentIndex; i++ )
    {
      if ( data[i] == key )
      {
        gc.setFill( Color.RED );
        gc.fillRect( xStart, YMAX - 25 - 2 * data[i], barSize-5, 2 * data[i] );
        gc.clearRect( xStart + barSize / 3 - 2, YMAX - 14, 2 * barSize / 3, 10 );
        Font mediumFont2 = new Font( Dimensions.MEDIUM_SMALLER_FONT_SIZE );
        gc.setFont( mediumFont2 );
        gc.fillText( String.valueOf( data[i] ), xStart + barSize / 4, YMAX - 5 );
      }
      else if ( i < currentIndex )
      {
        gc.clearRect( xStart -1, YMAX - 25 - 2 * key - 1, barSize - 5 + 2, 2 * key + 2 );
        gc.setFill( Color.NAVY );
        gc.fillRect( xStart, YMAX - 25 - 2 * data[i], barSize-5, 2 * data[i] );
      }
      else
      {
        gc.setStroke( Color.RED );
        gc.setFill( Color.NAVY );
        gc.fillRect( xStart, YMAX - 25 - 2 * data[i], barSize-5, 2 * data[i] );
        gc.strokeRect( xStart, YMAX - 25 - 2 * key, barSize - 5, 2 * key );
      }
      xStart += barSize;
    }
  }
  
  public void drawBubbleSort( GraphicsContext gc )
  {
    BubbleSortState bss = bsStates.get( currentIndex );
    int iIndex = bss.getI( ); // not used here
    int j = bss.getJ( );
    int [] currentData = bss.getArrayState( );
    
    gc.clearRect( 0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT );
    
    gc.setFill( Color.NAVY );
    gc.setStroke( Color.NAVY );
    
    Font mediumFont = new Font( Dimensions.MEDIUM_FONT_SIZE );
    gc.setFont( mediumFont );
    gc.fillText( "Sorting using Bubble Sort", 25, YMAX / 7 );
         
    Font mediumFont2 = new Font( Dimensions.MEDIUM_SMALLER_FONT_SIZE );
    gc.setFont( mediumFont2 );

    xStart = 10;
    for ( int i = 0; i < data.length; i++ )
    {
      if ( i == j || i == ( j + 1 ) ) // draw current array element
      {
        gc.setFill( Color.RED );
        gc.fillRect( xStart, YMAX - 25 - 2 * currentData[i], barSize-5, 2 * currentData[i] );
        gc.fillText( String.valueOf( currentData[i] ), xStart + barSize / 4, YMAX - 5 );
      }
      else  
      {
        gc.setFill( Color.NAVY );
        gc.fillRect( xStart, YMAX - 25 - 2 * currentData[i], barSize-5, 2 * currentData[i] );
        gc.fillText( String.valueOf( currentData[i] ), xStart + barSize / 4, YMAX - 5 );
      }

      xStart += barSize;
    }
    
    if ( currentIndex == bsStates.size( ) - 1 )
    {
      String message = "";
      boolean sorted = checkIfArraySorted( currentData );
      gc.setFont( mediumFont );
      
      if ( sorted )
      {
        gc.setFill( Color.GREEN );
        message = "The array is sorted";
      }
      else
      {
        gc.setFill( Color.RED );
        message = "The array is NOT sorted";
      }
      gc.fillText( message, 25, 2 * YMAX / 7 );
      
      String result = checkIfSameArray( currentData );
      if ( result.startsWith( "ERROR" ) )
        gc.setFill( Color.RED );
      else
        gc.setFill( Color.GREEN );
      gc.fillText( result, 25, 3 * YMAX / 7 );
      
      setArray( currentData );
    } 
  }
}
