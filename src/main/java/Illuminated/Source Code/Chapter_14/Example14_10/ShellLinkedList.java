/* The ShellLinkedList class
   Anderson, Franceschi
*/

public abstract class ShellLinkedList
{
  protected PlayerNode head;
  protected int numberOfItems;

  /**  constructor
  *  sets head to null and numberOfItems to 0
  */
  public ShellLinkedList( )
  {
    head = null;
    numberOfItems = 0;
  }

  /**  accessor for numberOfItems
  *  @return    numberOfitems
  */
  public int getNumberOfItems( )
  {
    return numberOfItems;
  }

  /**  isEmpty method
  *  @return    true if no items in list; false otherwise
  */
  public boolean isEmpty( )
  {
    return ( numberOfItems == 0 );
  }

  /**  toString
  *  @return the contents of the list
  */
  @Override
  public String toString( )
  {
    String listString = "";
    PlayerNode current = head;
    while ( current != null )
	 {
      listString += current.getPlayer( ).toString( ) + "\n";
      current = current.getNext( );
    }
    return listString;
  }
}
