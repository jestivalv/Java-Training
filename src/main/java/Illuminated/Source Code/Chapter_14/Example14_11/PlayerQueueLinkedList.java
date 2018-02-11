/* The PlayerQueueLinkedList class
   Anderson, Franceschi
*/

public class PlayerQueueLinkedList extends ShellLinkedList
{
  // head and numberOfItems are inherited instance variables
  private PlayerNode tail;  // last node

  public PlayerQueueLinkedList( )
  {
    super( );
    tail = null;
  }

  /** enqueue method
  *   @param    p   Player object to insert
  */
  public void enqueue( Player p )
  {
    // insert as tail
    PlayerNode pn = new PlayerNode( p );
    if ( numberOfItems == 0 )
    {
      tail = pn;
      head = pn;
    }
    else
    {
      tail.setNext( pn );
      tail = pn;
    }
    numberOfItems++;
  }

  /** dequeue method
  *   @return    a reference to the Player object deleted
  */
  public Player dequeue( ) throws DataStructureException
  {
    if ( isEmpty( ) )
      throw new DataStructureException
		     ( "empty queue: cannot dequeue" );
    else
    {
      Player deleted = head.getPlayer( );
      head = head.getNext( );
      if ( --numberOfItems == 0 )
		  tail = null;
      return deleted;
    }
  }

  /** peek method
  *   @return    a reference to the Player object retrieved
  */
  public Player peek( ) throws DataStructureException
  {
    if ( isEmpty( ) )
      throw new DataStructureException
           ( "empty queue: cannot peek" );
    else
    {
      return head.getPlayer( );
    }
  }
}
