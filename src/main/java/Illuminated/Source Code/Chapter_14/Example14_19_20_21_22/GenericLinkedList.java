/* The GenericLinkedList class
   Anderson, Franceschi
*/

public class GenericLinkedList<T> extends ShellLinkedList<T>
{
  // head and numberOfItems are inherited instance variables

  /**  constructor
  *   calls constructor of ShellLinkedList
  */
  public GenericLinkedList(  )
  {
    super( );
  }

  /** insert method
  *   @param    item   T object to insert
  */
  public void insert( T item )
  {
    // insert as head
    Node<T> nd = new Node<T>( item );
    nd.setNext( head );
    head = nd;
    numberOfItems++;
  }

  /** delete method
  *   @param    item   T object to delete
  *   @return   true if the deletion was successful, false otherwise
  */
  public boolean delete( T item )
  {
    Node<T> current = head;
    Node<T> previous = null;
    while ( current != null
            && ! ( item.equals( current.getData( ) ) ) )
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
      return true;
    }
  }
}
