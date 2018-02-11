/* The IntegerLinkedList class
   Anderson, Franceschi
*/

public class IntegerLinkedList
{
  private IntegerNode head;
  private int numberOfItems;

  /** default constructor
  *   constructors an empty list
  */
  public IntegerLinkedList( )
  {
    head = null;
    numberOfItems = 0;
  }

  /** accessor for numberOfItems
  *   @return   numberOfItmes
  */
  public int getNumberOfItems( )
  {
    return numberOfItems;
  }

  /** insert method
  *   @param    value  data to  insert
  *    inserts node at head
  */
  public void insert( int value )
  {
    IntegerNode nd = new IntegerNode( value );
    nd.setNext( head );
    head = nd;
    numberOfItems++;
  }

  /** delete method
  *   @param    value   the value to delete
  *   @return   true if value was deleted, false otherwise
  */
  public boolean delete( int value )
  {
    IntegerNode current = head;
    IntegerNode previous = null;
    while ( current != null
            && current.getData( ) != value )
    {
      previous = current;
      current = current.getNext( );
    }

    if ( current == null ) // not found
      return false;
    else
    {
      if ( current == head )
        head = head.getNext( );  // delete head
      else
        previous.setNext( current.getNext( ) );

      numberOfItems--;
      return  true;
    }
  }

  /** toString
  *   @return    values in list separated by a space
  */
  @Override
  public String toString( )
  {
    String listString = "";
    IntegerNode current = head;
    for ( int i = 0; i < numberOfItems; i++ )
    {
      listString += current.getData( ) + " ";
      current = current.getNext( );
    }
    return listString;
  }
}
