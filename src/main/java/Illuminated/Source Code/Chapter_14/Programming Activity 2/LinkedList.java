/* LinkedList
*  Anderson, Franceschi
*/

/**
 *
 * properties of this implementation are such that:
 *   - the list is singly linked
 *   - data contained in the nodes are limited to integers
 *   - nodes are sorted in ascending order of data
 *   - duplicate data is allowed
 */
import java.util.ArrayList;

public class LinkedList
{
  private Node head;

  /** default constructor
  *    sets head to null
  */
  public LinkedList( )
  {
    head = null;
  }

  /** insert method
  *  @param value number to insert
  */
  public void insert( int value )
  {
    // ***** Student writes the body of this method *****
    // code the insert method of a linked list of ints
    // the int to insert in the linked list is value
    //
    // Student code starts here
    //
    
    //
    // End of student code, part 1
    //

  }

  /** delete method
  *  @param  value  data value to delete
  *  @return true if delete was successful; otherwise, false
  */
  public boolean delete( int value )
  {
    // ***** Student writes the body of this method *****
    // code the delete method of a linked list of ints
    // the int to delete in the linked list is value
    // if deletion is successful, return true
    // otherwise, return false
    //
    // Student code starts here
    //
    
       return true; //  replace this return statement
    //
    // End of student code, part 2
    //
  }

  /** count method
  *  @return the number of nodes in the list
  */
  public int count( )
  {
    int n = 0;
    Node current = head;
    while ( current != null )
    {
      n++;
      current = current.getNext( );
    }
    return n;
  }
  
  /** toString
  * @return a list of the data items in the list
  */
  @Override
  public String toString( )
  {
    String result = "List: ";
    Node current = head;
    while ( current != null )
    {
      result += ( current.getData( ) + "  " );
      current = current.getNext( );
    }
    return result;
  }

  /** clear method
  *  deletes all data by setting head to null
  */
  public void clear( )
  {
    head = null;
  }
   
  /** toArrayList method
  *  @return an ArrayList containing the data in the list
  */ 
  public ArrayList<Integer> toArrayList( )
  {
    ArrayList<Integer> result = new ArrayList<Integer>( );
    Node current = head;
    while ( current != null )
    {
      result.add( current.getData( ) );
      current = current.getNext( );
    }
    return result;
  }

}