/* The IntegerNode class
   Anderson, Franceschi
*/

public class IntegerNode
{
  private int data;
  private IntegerNode next;

  /** default constructor
  *   sets data to 0, and next to null
  */
  public IntegerNode( )
  {
    data = 0;
    next = null;
  }

  /** overloaded constructor
  *   @param   data  data value
  */
  public IntegerNode( int  data )
  {
    setData( data );
    next = null;
  }

  /** accessor for data
  *   @return   the value of the node
  */
  public int getData( )
  {
    return data;
  }

  /** accessor for next
  *   @return   the reference to the next node
  */
  public IntegerNode getNext( )
  {
    return next;
  }

  /** mutator for data
  *   @param    data   the new value for the node
  *   @return  a reference to this object
  */
  public IntegerNode setData( int data )
  {
    this.data = data;
    return this;
  }

  /** mutator for next
  *   @param   next   the new value for next
  *   @return  a reference to this object
  */
  public IntegerNode setNext( IntegerNode  next )
  {
    this.next = next;
    return this;
  }
}
