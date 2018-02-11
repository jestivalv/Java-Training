/* MethodState
*  Anderson, Franceschi
*/

public class MethodState
{
 private int i, j, value;
 private int [][] array;
 
 public MethodState( int i, int j, int value, int [][] array )
 {
  this.i = i;
  this.j = j;
  this.value = value;
  this.array = array;
 }

 public int getI( )
 {
  return i;
 }
 
 public int getJ( )
 {
  return j;
 }
 
 public int getValue( )
 {
  return value;
 }
 
 public int getData( int i, int j )
 {
  return array[i][j];
 }
 
 public String toString( )
 {
  String result = "" + i + "; " + j + "; value: " + value; 
  return result;
 }

}
