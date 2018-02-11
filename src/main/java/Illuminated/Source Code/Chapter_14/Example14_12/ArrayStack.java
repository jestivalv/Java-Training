/* The ArrayStack class
   Anderson, Franceschi
*/

public class ArrayStack
{
  private static final int STACK_SIZE = 100; // maximum array size
  private Player [] stack;             // array of Player objects
  private int top;            // last used index; top of the stack

  public ArrayStack( )
  {
    stack = new Player[STACK_SIZE];
    top = -1; // stack is empty
  }

  /** push method
  *   @param    p   Player object to insert
  *   @return   true if insertion was successful false otherwise
  */
  public boolean push( Player p )
  {
    if ( !isFull( ) ) // is there room to insert?
    {
      stack[++top] = p;
      return true;
    }
    else
      return false;
  }

  /** pop method
  *   @return   the Player deleted
  */
  public Player pop( ) throws DataStructureException
  {
    if ( !isEmpty( ) ) // is there an item to delete?
      return stack[top--];
    else
      throw new DataStructureException
                  ( "Stack empty: cannot pop" );
  }

  /** peek method
  *   @return   the Player at the top of the stack
  */
  public Player peek( ) throws DataStructureException
  {
    if ( !isEmpty( ) ) // stack is not empty
      return stack[top];
    else
      throw new DataStructureException
                  ( "Stack empty: cannot peek" );
  }

  /** isEmpty method
  *   @return   true if stack is empty, false otherwise
  */
  public boolean isEmpty( )
  {
    return ( top == -1 );
  }

  /** isFull method
  *   @return   true if stack is full, false otherwise
  */
  public boolean isFull( )
  {
    return ( top == ( STACK_SIZE - 1 ) );
  }

  /** toString method
  * @return the stack elements starting at top
  */
  @Override
  public String toString( )
  {
    String stackString = "";
    for ( int i = top; i >= 0; i-- )
      stackString += ( i + ": " + stack[i] + "\n" );
    return stackString;
  }
}
