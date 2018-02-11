/* AutoDrawing Class
*  Anderson, Franceschi
*/

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class AutoDrawing
{
 // ArrayList representing the various AutoState objects
   private ArrayList<AutoState> autoStates;
   AutoState currentAutoState;
   private String searchModel;
   private ArrayList<Auto> carList;
 
   private int X_START = 100;
   private int X_END = 300;
   private int Y_START = 100;

   private int x = X_START;
   private int y = Y_START;
 
 // current index of autoStates
   private int index;
   private int result;
                    
   public AutoDrawing( ArrayList<Auto> carList )
   {
      autoStates = new ArrayList<AutoState>( );
      this.carList = carList;
      index = 0;
   }

   public void addAutoState( AutoState as )
   {
      autoStates.add( as );
   }
  
   public void resetIndex( )
   {
      index = 0;
   }
  
   public void incrementIndex( )
   {
      index++;
   }
  
   public int getIndex( )
   {
      return index;
   }
  
   public boolean doneAll( )
   {
      return index >= autoStates.size( );
   } 
  
   public boolean done( )
   {
      return x >= 500;
   } 

   public void resetX( )
   {
      x = X_START;
   } 
  
   public void resetY( )
   {
      y = Y_START;
   } 

   public void addToX( int deltaX )
   {
      x += deltaX;
   }
  
   public void addToY( int deltaY )
   {
      y += deltaY;
   }
  
   public AutoState getCurrentAutoState( int index )
   {
      return autoStates.get( index );
   }
  
   public void setSearchModel( String searchModel )
   {
      this.searchModel = searchModel;
   }
  
   @Override
   public String toString( )
   {
      String result = "List: ";
      for ( AutoState current : autoStates )
      {
         result += current.toString( ) + " ";
      }
      return result;
   }
  
   public void clearAutoStates( )
   {
      autoStates.clear( );
   }

   public boolean isEmpty( )
   {
      return autoStates.size( ) == 0;
   }
  
   public void setResult( int result )
   {
      this.result = result;
   }
  
   public void displayCars( GraphicsContext gc )
   {
      Font mediumFont = new Font( Dimensions.MEDIUM_SMALLER_FONT_SIZE );
      gc.setFont( mediumFont );
    
      // display Autos
      gc.clearRect( 0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT );
    
      for ( int i = 0; i <= index; i++ )
      {
         AutoState carState = autoStates.get( i );
      
         Auto car = carState.getAuto( );
      
         if ( car.getModel( ).equals( "BMW" ) )
            gc.setFill( Color.NAVY );
         else if ( car.getModel( ).equals( "Jeep" ) )
            gc.setFill( Color.BLACK );
         else if ( car.getModel( ).equals( "Ferrari" ) )
            gc.setFill( Color.RED );
         else
            gc.setFill( Color.GREEN );
      
         gc.fillText( car.toString( ) , X_START, Y_START + 35 * ( i - 1 ) );
      }
      Font smallFont = new Font( Dimensions.SMALL_FONT_SIZE );
      gc.setFont( smallFont );
   
   }
  
   public void drawCar( GraphicsContext gc )
   {
      gc.clearRect( 0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT );
      Auto car = autoStates.get( index ).getAuto( );
      if ( car.getModel( ).equals( "BMW" ) )
         drawBMW( gc ); 
      else if ( car.getModel( ).equals( "Ferrari" ) )
         drawFerrari( gc );
      else if ( car.getModel( ).equals( "Jeep" ) )
         drawJeep( gc ); 
      else
         drawOtherCar( gc ); 
      drawData( gc );
   }
  
   public void drawData( GraphicsContext gc )
   {
      Font mediumFont = new Font( Dimensions.MEDIUM_SMALLER_FONT_SIZE );
      gc.setFont( mediumFont );
   
      // draw miles and gallons
      int milesDriven = autoStates.get( index ).getAuto( ).getMilesDriven( );
      gc.fillText( "Miles = " + milesDriven, 200, y + 50 );
      double gallonsOfGas = autoStates.get( index ).getAuto( ).getGallonsOfGas( );
      gc.fillText( "Gallons = " + gallonsOfGas, 200, y + 100 );
    
      Font smallFont = new Font( Dimensions.SMALL_FONT_SIZE );
      gc.setFont( smallFont );
   }
  
   public void drawResultForSet( GraphicsContext gc )
   {
      Font mediumFont = new Font( Dimensions.MEDIUM_SMALLER_FONT_SIZE );
      gc.setFont( mediumFont );
   
      // draw miles and gallons
      String result = "incorrectly";
      if ( checkSetModel( ) )
         result = "correctly";
      gc.setFill( Color.BLACK );
      gc.fillText( "To this point, the models have been set " + result, 200, y + 200 );
    
      Font smallFont = new Font( Dimensions.SMALL_FONT_SIZE );
      gc.setFont( smallFont );
   }
  
   public void drawResultForMaximum( GraphicsContext gc )
   {
      Font mediumFont = new Font( Dimensions.MEDIUM_SMALLER_FONT_SIZE );
      gc.setFont( mediumFont );
   
      // draw miles and gallons
      int correctMaximum = maxMiles( );
      int studentMaximum = autoStates.get( index ).getValue( );
    
      // change student maximum to returned value if last index
      String status = "current";
      if ( index == autoStates.size( ) - 1 )
      {
         studentMaximum = result;
         status = "final";  
      }
      gc.setFill( Color.BLACK );
      gc.fillText( "Student's " + status + " maximum is " + studentMaximum, 200, y + 150 );
      gc.fillText( "Correct " + status + " maximum is " + correctMaximum, 200, y + 200 );
    
      Font smallFont = new Font( Dimensions.SMALL_FONT_SIZE );
      gc.setFont( smallFont );
   }
  
   public void drawResultForCount( GraphicsContext gc )
   {
      Font mediumFont = new Font( Dimensions.MEDIUM_SMALLER_FONT_SIZE );
      gc.setFont( mediumFont );
   
      // draw miles and gallons
      int correctCount = countModel( );
      int studentCount = autoStates.get( index ).getValue( );
    
      // change student count to returned value if last index   
      String status = "current";
      if ( index == autoStates.size( ) - 1 )
      {
         studentCount = result;
         status = "final";
      }
    
      gc.setFill( Color.BLACK );
      gc.fillText( "Student's " + status + " count is " + studentCount, 200, y + 150 );
      gc.fillText( "Correct " + status + " count is " + correctCount, 200, y + 200 );
    
      Font smallFont = new Font( Dimensions.SMALL_FONT_SIZE );
      gc.setFont( smallFont );
   }
  
   public void drawBMW( GraphicsContext gc ) 
   {
      int wx1 = 0;
      int wy1 = 0;
      int wx2 = 0;
      int wy2 = 0;
    
      // draw the BMW
      gc.setStroke( Color.NAVY );
      // Bottom
      gc.strokeLine( x, y, x + 100, y );
      // Back
      gc.strokeLine( x, y, x, y - 20 );
      // Trunk
      gc.strokeLine( x, y - 20, x + 20, y - 20 );
      // Back Windshield
      gc.strokeLine( x + 20, y - 20, x + 20, y - 40 );
      // Roof
      gc.strokeLine( x + 20, y - 40, x + 60, y - 40 );
      // Windshield
      gc.strokeLine( x + 60, y - 40, x + 70, y - 20 );
      // Hood
      gc.strokeLine( x + 70, y - 20, x + 100, y - 20 );
      // Front
      gc.strokeLine( x + 100, y - 20, x + 100, y ); 
      
      // Back wheel
      gc.strokeOval( x + 15, y, 14, 14 );
      // Make backwheel animate
      wx1 = x + 22 - ( (int) ( 3 * Math.cos( 3 * x ) ) );
      wy1 = y + 7 - ( (int) ( 3 * Math.sin( -3 * x ) ) );
      wx2 = x + 22 + ( (int) ( 3 * Math.cos( 3 * x ) ) );
      wy2 = y + 7 + ( (int) ( 3 * Math.sin( -3 * x ) ) );
      gc.strokeLine( wx1, wy1, wx2, wy2 );
   
      // Front wheel
      gc.strokeOval( x + 70, y, 14, 14 );
      // Make frontwheel animate
      wx1 = x + 77 - ( (int) ( 3 * Math.cos( 3 * x ) ) );
      wy1 = y + 7 - ( (int) ( 3 * Math.sin( -3 * x ) ) );
      wx2 = x + 77 + ( (int) ( 3 * Math.cos( 3 * x ) ) );
      wy2 = y + 7 + ( (int) ( 3 * Math.sin( -3 * x ) ) );
      gc.strokeLine( wx1, wy1, wx2, wy2 );
   
      // draw BMW name
      gc.setFill( Color.NAVY );
      gc.fillText("BMW", x + 30, y - 20 ); 
   
   }

   public void drawFerrari( GraphicsContext gc )
   {
      int wx1 = 0;
      int wy1 = 0;
      int wx2 = 0;
      int wy2 = 0;
      // draw the Ferrari
      gc.setStroke ( Color.RED );
      // Bottom
      gc.strokeLine( x, y, x + 100, y );
      // Back
      gc.strokeLine( x, y, x, y - 10 );
      // Trunk
      gc.strokeLine( x, y - 10, x + 10, y - 15 );
      // Back Windshield
      gc.strokeLine( x + 10, y - 15, x + 20, y - 30 );
      // Roof
      gc.strokeLine( x + 20, y - 30, x + 50, y - 30 );
      // Windshield
      gc.strokeLine( x + 50, y - 30, x + 80, y - 15 );
      // Hood
      gc.strokeLine( x + 80, y - 15, x + 100, y - 10 );
      // Front
      gc.strokeLine( x + 100, y - 10, x + 100, y );
   
      // Back wheel
      gc.strokeOval( x + 15, y, 14, 14 );
      // Make backwheel animate
      wx1 = x + 22 - ( (int) ( 3 * Math.cos( 3 * x ) ) );
      wy1 = y + 7 - ( (int) ( 3 * Math.sin( -3 * x ) ) );
      wx2 = x + 22 + ( (int) ( 3 * Math.cos( 3 * x ) ) );
      wy2 = y + 7 + ( (int) ( 3 * Math.sin( -3 * x ) ) );
      gc.strokeLine( wx1, wy1, wx2, wy2 );
   
      // Front wheel
      gc.strokeOval( x + 70, y, 14, 14 );
      // Make frontwheel animate
      wx1 = x + 77 - ( (int) ( 3 * Math.cos( 3 * x ) ) );
      wy1 = y + 7 - ( (int) ( 3 * Math.sin( -3 * x ) ) );
      wx2 = x + 77 + ( (int) ( 3 * Math.cos( 3 * x ) ) );
      wy2 = y + 7 + ( (int) ( 3 * Math.sin( -3 * x ) ) );
      gc.strokeLine( wx1, wy1, wx2, wy2 );
   
      // draw Ferrari name
      gc.setFill( Color.RED );
      gc.fillText("Ferrari", x + 25, y - 10 );  
   }

   public void drawJeep( GraphicsContext gc )
   {
      int wx1 = 0;
      int wy1 = 0;
      int wx2 = 0;
      int wy2 = 0;
      // draw the Jeep
      gc.setStroke ( Color.BLACK );
      // Bottom
      gc.strokeLine( x, y, x + 100, y );
      // Back
      gc.strokeLine( x, y, x, y - 60 );
      // Roof
      gc.strokeLine( x, y - 60, x + 60, y - 60 );
      // Windshield
      gc.strokeLine( x + 60, y - 60, x + 70, y - 20 );
      // Hood
      gc.strokeLine( x + 70, y - 20, x + 100, y - 20 );
      // Front
      gc.strokeLine( x + 100, y - 20, x + 100, y );
      // Back wheel
      gc.strokeOval( x + 15, y, 15, 15 );
   
      // Make backwheel animate
      wx1 = x + 22 - ( (int) ( 3 * Math.cos( 3 * x ) ) );
      wy1 = y + 7 - ( (int) ( 3 * Math.sin( -3 * x ) ) );
      wx2 = x + 22 + ( (int) ( 3 * Math.cos( 3 * x ) ) );
      wy2 = y + 7 + ( (int) ( 3 * Math.sin( -3 * x ) ) );
      gc.strokeLine( wx1, wy1, wx2, wy2 );
   
      // Front wheel
      gc.strokeOval( x + 70, y, 15, 15 );
      // Make frontwheel animate
      wx1 = x + 77 - ( (int) ( 3 * Math.cos( 3 * x ) ) );
      wy1 = y + 7 - ( (int) ( 3 * Math.sin( -3 * x ) ) );
      wx2 = x + 77 + ( (int) ( 3 * Math.cos( 3 * x ) ) );
      wy2 = y + 7 + ( (int) ( 3 * Math.sin( -3 * x ) ) );
      gc.strokeLine( wx1, wy1, wx2, wy2 );
   
      // draw Jeep name
      gc.setFill( Color.BLACK );
      gc.fillText( "Jeep", x + 20, y - 30 );  
   }

   public void drawOtherCar( GraphicsContext gc )
   {
      int wx1 = 0;
      int wy1 = 0;
      int wx2 = 0;
      int wy2 = 0;
   
   // draw the other car
      gc.setStroke ( Color.rgb( 20, 200, 110 ) );
   // Bottom
      gc.strokeLine( x, y, x + 100, y );
   // Back
      gc.strokeLine( x, y, x, y - 20 );
   // trunk
      gc.strokeLine( x, y - 20, x + 20, y - 20 );
   // back windshield
      gc.strokeLine( x + 20, y - 20, x + 20, y - 40 );
   // Roof
      gc.strokeLine( x + 20, y - 40, x + 60, y - 40 );
   // Windshield
      gc.strokeLine( x + 60, y - 40, x + 70, y - 20 );
   // Hood
      gc.strokeLine( x + 70, y - 20, x + 100, y - 20 );
   // Front
      gc.strokeLine( x + 100, y - 20, x + 100, y );
   // Back wheel
      gc.strokeOval( x + 15, y, 14, 14 );
   // Make backwheel animate
      wx1 = x + 22 - ( (int) ( 3 * Math.cos( 3 * x ) ) );
      wy1 = y + 7 - ( (int) ( 3 * Math.sin( -3 * x ) ) );
      wx2 = x + 22 + ( (int) ( 3 * Math.cos( 3 * x ) ) );
      wy2 = y + 7 + ( (int) ( 3 * Math.sin( -3 * x ) ) );
      gc.strokeLine( wx1, wy1, wx2, wy2 );
   
   // Front wheel
      gc.strokeOval( x + 70, y, 14, 14 );
   // Make frontwheel animate
      wx1 = x + 77 - ( (int) ( 3 * Math.cos( 3 * x ) ) );
      wy1 = y + 7 - ( (int) ( 3 * Math.sin( -3 * x ) ) );
      wx2 = x + 77 + ( (int) ( 3 * Math.cos( 3 * x ) ) );
      wy2 = y + 7 + ( (int) ( 3 * Math.sin( -3 * x ) ) );
      gc.strokeLine( wx1, wy1, wx2, wy2 );
   
   // draw Auto name
      gc.setFill( Color.rgb( 20, 200, 110 ) );
      String autoName = autoStates.get( index ).getAuto( ).getModel( );
      if ( autoName.length( ) > 5 )
         autoName = autoName.substring( 0, 3 ) + "..";
      gc.fillText( autoName, x + 30, y - 20 ); 
   }
 
   public int maxMiles( )
   {
      int result = 0;
      for ( int i = 0; i <= index; i++ )
      {
         Auto car = carList.get( i );
         if ( car.getMilesDriven( ) > result )
            result = car.getMilesDriven( );
      }
      return result;
   }
 
   public int countModel( )
   {
      int result = 0;
      for ( int i = 0; i <= index; i++ )
      {
         Auto car = carList.get( i );
         if ( car.getModel( ).equals( searchModel ) )
            result++;
      }
      return result;
   }

   public boolean checkSetModel( )
   {
      boolean result = true;
      for ( int i = 0; i <= index; i++ )
      {
         Auto car = carList.get( i );
         if ( ! ( car.getModel( ).equals( searchModel ) ) )
            result = false;
      }
      return result;
   }
 
}