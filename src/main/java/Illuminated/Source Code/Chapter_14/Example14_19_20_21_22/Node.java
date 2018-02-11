/** The Node class
*   Anderson, Franceschi
*/

public class Node<T>
{
  private T data;
  private Node<T> next;

  /** default constructor
  *  sets data and next to null
  */
  public Node( )
  {
    data = null;
    next = null;
  }

  /**  constructor
  *   @param item reference to data item
  *  sets next to null
  */
  public Node( T data )
  {
    setData( data );
    next = null;
  }

  /**  accessor for data
  *   @return reference to data item
  */
  public T getData( )
  {
    return data;
  }

  /**  accessor for next
  *   @return next
  */
  public Node<T> getNext( )
  {
    return next;
  }

  /**  mutator for data
  *   @param data reference to new data item
  *   @return reference to this object
  */
  public Node setData( T data )
  {
    this.data = data;
    return next;
  }

  /**  mutator for next
  *   @param reference to next Node
  *   @return reference to this object
  */
  public Node setNext( Node<T> next )
  {
    this.next = next;
    return this;
  }
}
