/* The ShellLinkedList class
   Anderson, Franceschi
*/

public abstract class ShellLinkedList<T>
{
  protected Node<T> head;
  protected int numberOfItems;

  /**  constructor
  *   sets head to null and numberOfItems to 0
  */
  public ShellLinkedList( )
  {
    head = null;
    numberOfItems = 0;
  }

  /**  accessor for numberOfItems
  *   @return  numberOfItems
  */
  public int getNumberOfItems( )
  {
    return numberOfItems;
  }

  /**  isEmpty method
  *   @return  true if no items in list; false otherwise
  */
  public boolean isEmpty( )
  {
    return ( numberOfItems == 0 );
  }

  /**  toString method
  *   @return  all items in the list
  */
  @Override
  public String toString( )
  {
    String listString = "";
    Node<T> current = head;
    for ( int i = 0; i < numberOfItems; i++ )
    {
      listString += current.getData( ).toString( ) + "\n";
      current = current.getNext( );
    }
    return listString;
  }
}
