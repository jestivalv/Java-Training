/* BubbleSortState
*  Anderson, Franceschi
*/
import java.awt.Graphics;
import java.awt.Color;

public class BubbleSortState
{
 private int i, j;
 private int [] arrayState;

 public BubbleSortState( int i, int j, int [] array )
 {
  this.i = i;
  this.j = j;
  arrayState = new int[array.length];
  for ( int k = 0; k < array.length; k++ )
    arrayState[k ] = array[k];
 }

 public int getI( )
 {
  return i;
 }
 
 public int getJ( )
 {
  return j;
 }
 
 public int [] getArrayState( )
 {
  return arrayState;
 }
 
 public String toString( )
 {
  String result = "" + i + "; " + j + "array: "; 
  for ( int k = 0; k < arrayState.length; k++ )
    result += arrayState[k] + " ";
  return result;
 }

}
