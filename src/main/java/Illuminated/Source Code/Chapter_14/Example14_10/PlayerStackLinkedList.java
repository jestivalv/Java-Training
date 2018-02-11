/* The PlayerStackLinkedList class
   Anderson, Franceschi
*/

public class PlayerStackLinkedList extends ShellLinkedList
{
  // head and numberOfItems are inherited instance variables

  public PlayerStackLinkedList( )
  {
    super( );
  }

  /** push method
  *   @param    p   Player object to insert
  */
  public void push( Player p )
  {
    PlayerNode pn = new PlayerNode( p );
    pn.setNext( head );
    head = pn;
    numberOfItems++;
  }

  /** pop method
  *   @return   the Player object deleted
  */
  public Player pop( ) throws DataStructureException
  {
    if ( isEmpty( ) )
      throw new DataStructureException
                 ( "empty stack: cannot be popped" );
    else
    {
      Player deleted = head.getPlayer( );
      head = head.getNext( );
      numberOfItems--;
      return deleted;
    }
  }

  /** peek method
  *   @return   the Player object retrieved
  */
  public Player peek( ) throws DataStructureException
  {
    if ( isEmpty( ) )
      throw new DataStructureException
                ( "empty stack: cannot peek" );
    else
    {
      return head.getPlayer( );
    }
  }
}
