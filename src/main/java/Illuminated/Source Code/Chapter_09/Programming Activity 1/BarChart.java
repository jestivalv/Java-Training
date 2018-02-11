/* BarChart
*  Anderson, Franceschi
*/

import java.awt.Image;
import java.awt.image.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.ArrayList;

public class BarChart
{
 public static final int XMAX = 400;
 public static final int XSTART = 60;
 public static final int [] YMAX = { 120, 220, 320, 420 };

 private ArrayList<MethodState> methodStates;
 private int currentIndex = 0;

 // array of 4 colors for bar charts
 private Color [] colors = { Color.NAVY, Color.rgb( 150, 150, 0 ), 
                              Color.DARKGRAY, Color.MAGENTA };
 private int [][] data;

 private int barSize;
 private int xStart;
 private int activity = 5;
 private int count = 0;
 private int studentResult;
 private int resultValue;
 private int exactFrequencyCount;
 private int exactMinimum;
 private int key;
 private int rowSelected;
 private boolean checkNewValues;

 public BarChart( )
 { }

 public BarChart( int [][] dArray )
 {
   methodStates = new ArrayList<MethodState>( );
   
   data = new int[dArray.length][dArray[0].length];
   for ( int i = 0; i < dArray.length; i++ )
   {
    for ( int j = 0; j < dArray[i].length; j++ )
    {
      data[i][j] = dArray[i][j];
    }
   }
   barSize = ( XMAX - 20 ) / data[0].length;
   studentResult = -1;
   exactFrequencyCount = -1;
   exactMinimum = -1;
   key = -1;
   checkNewValues = true;
 }

 public void setData (int [][] newData )
 {
   data = newData;
 }

 public void setKey( int key )
 {
   this.key = key;
 }
 
 public void setRowSelected( int rowSelected )
 {
   this.rowSelected = rowSelected;
 }
 
 public void setResultValue( int resultValue )
 {
   this.resultValue = resultValue;
 }

 public void draw( GraphicsContext gc )
 {
   // Draws the original array in 4 colors
   for ( int i = 0; i < data.length; i++ )
   {
     xStart = XSTART;
     gc.setFill( colors[i] );

     gc.fillText( "Row " + i, xStart - 50, YMAX[i] );

     for ( int j = 0; j < data[i].length; j++ )
     {
       gc.fillRect( xStart, YMAX[i]-data[i][j], barSize-5, data[i][j] );
       gc.fillText( "" + data[i][j], xStart, YMAX[i] + 15 );
       xStart += barSize;
     }
   }
 }

 public void drawArray( GraphicsContext gc )
 {
   // called to "print out the array"
   gc.clearRect( 0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT );
   MethodState ms = methodStates.get( currentIndex );
   int indexI = ms.getI( );
   int indexJ = ms.getJ( );
   
   gc.setFill( Color.NAVY );

   for ( int i = 0; i < data.length; i++ )
   {
     xStart = XSTART;
     gc.setFill( colors[i] );

     gc.fillText( "Row " + i, xStart - 50, YMAX[i] );
     for ( int j = 0; j < data[i].length; j++ )
     {
       if ( i == indexI && j == indexJ )
         gc.setFill( Color.RED );
       gc.fillRect( xStart, YMAX[i]-data[i][j], barSize-5, data[i][j] );
       gc.fillText( "" + data[i][j], xStart, YMAX[i] + 15 );
       xStart += barSize;
       gc.setFill( colors[i] );
     }
   }
 }
 
 public void drawNewArray( GraphicsContext gc )
 {
   // called to "print out the array"
   gc.clearRect( 0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT );
   MethodState ms = methodStates.get( currentIndex );
   int indexI = ms.getI( );
   int indexJ = ms.getJ( );
   
   gc.setFill( Color.NAVY );

   for ( int i = 0; i < data.length; i++ )
   {
     xStart = XSTART;
     gc.setFill( colors[i] );

     gc.fillText( "Row " + i, xStart - 50, YMAX[i] );
     for ( int j = 0; j < data[i].length; j++ )
     {
       int storedData = ms.getData( i, j );
     
       if ( i == indexI && j == indexJ )
         gc.setFill( Color.RED );
              
       gc.fillRect( xStart, YMAX[i]-storedData, barSize-5, storedData );
       gc.fillText( "" + storedData, xStart, YMAX[i] + 15 );

       xStart += barSize;
       gc.setFill( Color.NAVY );
       gc.setFill( colors[i] );
     }
   }
 }

 public void drawNewValue( GraphicsContext gc )
 {
   gc.clearRect( 0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT );
   MethodState ms = methodStates.get( currentIndex );
   int indexI = ms.getI( );
   int indexJ = ms.getJ( );
   
   gc.setFill( Color.NAVY );

   for ( int i = 0; i < data.length; i++ )
   {
     xStart = XSTART;
     gc.setFill( colors[i] );

     gc.fillText( "Row " + i, xStart - 50, YMAX[i] );
     for ( int j = 0; j < data[i].length; j++ )
     {
       int storedData = ms.getData( i, j );
     
       if ( i == indexI && j == indexJ )
         gc.setFill( Color.RED );
              
       gc.fillRect( xStart, YMAX[i]-storedData, barSize-5, storedData );
       gc.fillText( "" + storedData, xStart, YMAX[i] + 15 );

       xStart += barSize;
       gc.setFill( Color.NAVY );
       gc.setFill( colors[i] );
     }
   }
 }
 
 public void drawCountValue( GraphicsContext gc )
 {
   gc.clearRect( 0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT );
   MethodState ms = methodStates.get( currentIndex );
   int indexI = ms.getI( );
   int indexJ = ms.getJ( );
   int count = ms.getValue( ); 
   
   // if last value, change to returned value
   String status = "current";
   if ( currentIndex == methodStates.size( ) - 1 )
   {
     count = resultValue;
     status = "final";
   }
     
   Font mediumFont = new Font( Dimensions.MEDIUM_SMALLER_FONT_SIZE );
   gc.setFont( mediumFont );
   gc.setFill( Color.NAVY );
   gc.fillText( "Your " + status + " frequency count for " + key + ": " + count, 25, YMAX[0] / 4 );
   Font smallFont = new Font( Dimensions.SMALL_FONT_SIZE );
   gc.setFont( smallFont );

   int runningIndex = -1;
   gc.setStroke( Color.RED );
   for ( int i = 0; i < data.length; i++ )
   {
     xStart = XSTART;
     gc.setFill( colors[i] );

     gc.fillText( "Row " + i, xStart - 50, YMAX[i] );
     for ( int j = 0; j < data[i].length; j++ )
     {
       runningIndex++;
       int storedData = ms.getData( i, j );
     
       if ( ( key == storedData ) && ( currentIndex >= runningIndex ) )
       {
         gc.setFill( Color.RED );
         gc.fillRect( xStart, YMAX[i]-storedData, barSize-5, storedData );
       }
       else       
         gc.fillRect( xStart, YMAX[i]-storedData, barSize-5, storedData );
       if ( i == indexI && j == indexJ )
         gc.strokeRect( xStart, YMAX[i]-storedData, barSize-5, storedData );
       gc.fillText( "" + storedData, xStart, YMAX[i] + 15 );

       xStart += barSize;
       gc.setFill( colors[i] );
     }
   }
 }

 public void drawMinimum( GraphicsContext gc )
 {
   gc.clearRect( 0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT );
   MethodState ms = methodStates.get( currentIndex );
   int indexI = ms.getI( );
   int indexJ = ms.getJ( );
   int min = ms.getValue( );
   
   // if last value, change to returned value
   String status = "current";
   if ( currentIndex == methodStates.size( ) - 1 )
   {
     min = resultValue;
     status = "final";  
   }

   Font mediumFont = new Font( Dimensions.MEDIUM_SMALLER_FONT_SIZE );
   gc.setFont( mediumFont );
   gc.setFill( Color.NAVY );
   gc.fillText( "Your " + status + " minimum in column " + key + ": " + min, 25, YMAX[0] / 4 );
   Font smallFont = new Font( Dimensions.SMALL_FONT_SIZE );
   gc.setFont( smallFont );

   for ( int i = 0; i < data.length; i++ )
   {
     xStart = XSTART;
     gc.setFill( colors[i] );

     gc.fillText( "Row " + i, xStart - 50, YMAX[i] );
     for ( int j = 0; j < data[i].length; j++ )
     {
       int storedData = ms.getData( i, j );
       gc.fillRect( xStart, YMAX[i] - storedData, barSize - 5, storedData );
       gc.fillText( "" + storedData, xStart, YMAX[i] + 15 );
       if ( i == indexI && j == key ) 
       {
         gc.setStroke( Color.RED );
         gc.strokeRect( xStart, YMAX[i] - storedData, barSize - 5, storedData );
         gc.fillText( "" + storedData, xStart, YMAX[i] + 15 );

       }
       if( data[i][j] == min && j == key && i <= indexI  )
       {
         gc.setFill( Color.RED );
         gc.fillRect( xStart, YMAX[i] - storedData, barSize - 5, storedData );
         gc.fillText( "" + storedData, xStart, YMAX[i] + 15 );
       }

       xStart += barSize;
       gc.setFill( colors[i] );
     }
   }
  
 }
 
 public void addMethodState( MethodState ms )
 {
   methodStates.add( ms );
 }
 
 public void incrementCurrentIndex( )
 {
   currentIndex++;
 }
 
 public boolean checkCurrentIndex( )
 {
   return currentIndex < methodStates.size( );
 }
 
 public void resetCurrentIndex( )
 {
   currentIndex = 0;
 }

 public void clearMS( )
 {
   methodStates.clear( );
 }

}
