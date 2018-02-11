/* The ArrayQueue class
   Anderson, Franceschi
*/

public class ArrayQueue
{
  private static final int QUEUE_SIZE = 8;
  private Player [ ] queue;
  private int front;
  private int back;
  private int numberOfItems;

  public ArrayQueue( )
  {
    queue = new Player[QUEUE_SIZE];
    front = 0;
    back = QUEUE_SIZE - 1;
    numberOfItems = 0;
  }

  public boolean isFull( )
  {
    return ( numberOfItems == QUEUE_SIZE );
  }

  public boolean isEmpty( )
  {
    return ( numberOfItems == 0 );
  }

  /** enqueue method
  *   @param    p   the Player to insert
  *   @return   true if list is not full, false otherwise
  */
  public boolean enqueue( Player p )
  {
    if ( !isFull( ) )
    {
      queue[( back + 1 ) % QUEUE_SIZE] = p;
      back = ( back + 1 ) % QUEUE_SIZE;
      numberOfItems++;
      return true;
    }
    else
      return false;
  }

  /** dequeue method
  *   @return    the Player deleted
  */
  public Player dequeue( ) throws DataStructureException
  {
    if ( !isEmpty( ) )
    {
      front = ( front + 1 ) % QUEUE_SIZE;
      numberOfItems--;
      return queue[( QUEUE_SIZE + front - 1 ) % QUEUE_SIZE];
    }
    else
      throw new DataStructureException
	               ( "Queue empty: cannot dequeue" );
  }

  /** toString method
  *   @return   a front-to-back String representation of the queue
  */
  @Override
  public String toString( )
  {
    String queueString = "";
    for ( int i = front; i < front + numberOfItems; i++ )
        queueString += queue[i % QUEUE_SIZE].toString( ) + "\n";
    return queueString;
  }
}