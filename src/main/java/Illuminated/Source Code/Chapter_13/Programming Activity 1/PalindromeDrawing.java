/* PalindromeDrawing Class
*  Anderson, Franceschi
*/

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.ArrayList;

public class PalindromeDrawing
{
 // upper left cordinates of start of animation
 private static final int X_START = 100;
 private static final int Y_START = 50;
 private static final int Y_SPACING = 25;
 private static final int FONT_COEFF = 13;

 // String representing the String
 private String pal;
 // boolean representing the exact result
 private boolean exactResult;
 // boolean representing the computed computed by the student
 private boolean result;
 // String array representing the various Strings
 // as they are called by the recursive method
 private ArrayList<String> listPal;
 // current index of listPal
 private int index;
 private int studentIndex;

 // animation started or not
 private boolean started = false;
 // exact result already computed or not
 private boolean resultSet = false;
                    
 public PalindromeDrawing( String s )
 {
  pal = s;
  listPal = new ArrayList<String>( );
  index = -1;
  studentIndex = -1;
  exactResult = calcExactResult( pal );
  result = false;
 }

 public PalindromeDrawing( )
 {
  pal = "";
  listPal = new ArrayList<String>( );
  index = -1;
  studentIndex = -1;
  exactResult = false;
  result = false;
 }
 
 public boolean recursivePalindrome( String pal )
 {
   // ***** Student writes the body of this method *****

   // Using recursion, determine if a String representing
   // a word or a sentence is a palindrome
   // If it is, return true, otherwise return false

   // We call the method animate inside the body of this method
   // The call to animate is already coded below

   animate( pal );

   //
   // Student code starts here
   //
   
     return true; // replace this dummy return statement
   //
   // End of student code
   //
 }
 
 public void animate( String pal )
 {
   listPal.add( pal );
   studentIndex++;
 }
 
 public void setResult( boolean r )
 {
  result = r;
 }

 public void setPalString( String s )
 {
  listPal.clear( );
  pal = s;
  index = -1;
  resultSet = false;
  exactResult = calcExactResult( pal );
 }

 public String getPalString( )
 {
  return pal;
 }

 public void setStarted( boolean s )
 {
  started = s;
 }

 public boolean calcExactResult( String s )
 {
    int leftIndex = 0;
    int rightIndex = s.length( ) - 1;
    String sCopy = s.toLowerCase( );
    while ( leftIndex < rightIndex 
            && sCopy.charAt( leftIndex ) == sCopy.charAt( rightIndex ) )
    {
      leftIndex++;
      rightIndex--;
    }
 
    if ( leftIndex < rightIndex )
      return false;
    else 
      return true;
 }

 public boolean getExactResult( )
 {
  return exactResult;
 }

 public String convertResult( boolean finalResult )
 {
  if ( finalResult )
    return "is a palindrome";
  else
    return "is not a palindrome";
 }

 public void draw( GraphicsContext gc )
 {
  index++;
  if ( index == studentIndex )
    resultSet = true;
  String temp = "";
     
  gc.setFont( Font.font( "Courier New", Dimensions.LARGE_FONT_SIZE ) );
  gc.setFill( Color.NAVY );

  for ( int i = 0; i <= index; i++ )
    gc.fillText( ( String ) listPal.get( i ), X_START + FONT_COEFF * i, Y_START + i * Y_SPACING );
   
  if ( resultSet )
  {
    gc.setFont( new Font( Dimensions.MEDIUM_FONT_SIZE ) );
    gc.setFill( Color.DARKRED );
    gc.fillText( "Your result: \"" + pal + "\" " + convertResult( result ), X_START / 4, Y_START + ( index + 2 ) * Y_SPACING );
    gc.setFill( Color.DARKGREEN );
    gc.fillText( "The correct result: \"" + pal + "\" " + convertResult( exactResult ), X_START / 4, Y_START + ( index + 4 ) * Y_SPACING );
  }
 }
  
 public void reset( )
 {
   studentIndex = -1;
 }
  
 public boolean done( )
 {
   return index >= studentIndex;
 } 
}