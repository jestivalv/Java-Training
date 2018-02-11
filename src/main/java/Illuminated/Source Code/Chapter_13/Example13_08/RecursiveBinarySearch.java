/* Searching a sorted array using recursion
   Anderson, Franceschi
*/

import java.util.Scanner;

public class RecursiveBinarySearch
{
  public static void main( String [] args )
  {
    // define an array sorted in ascending order
    int [] numbers = { 3, 6, 7, 8, 12, 15, 22, 36, 45,
                        48, 51, 53, 64, 69, 72, 89, 95 };

    Scanner scan = new Scanner( System.in );
    System.out.print( "Enter a value to search for > " );
    int value = scan.nextInt( );

    int index = recursiveBinarySearch
                  ( numbers, value, 0, numbers.length - 1 );
    if ( index != -1 )
      System.out.println( value + " found at index " + index );
    else
      System.out.println( value + " not found" );
  }

  /** recursiveBinarySearch method
  *   @param    arr   the array sorted in ascending order
  *   @param   key   the value to search for in the subarray
  *   @param    start the subarray's first index
  *   @param   end   the subarray's last index
  *   @return   the array index at which key was found,
  *    or -1 if key was not found
  */
  public static int recursiveBinarySearch
                      ( int [] arr, int key, int start, int end )
  {
    if ( start <= end )
    {
      // look at the middle element of the subarray
      int middle = ( start + end ) / 2;

      if ( arr[middle] == key )     // found key, base case
        return middle;
      else if ( arr[middle] > key ) // look lower
        return recursiveBinarySearch( arr, key, start, middle - 1 );
      else                          // look higher
        return recursiveBinarySearch( arr, key, middle + 1, end );
    }
    else                            // key not found, base case
      return -1;
  }
}
