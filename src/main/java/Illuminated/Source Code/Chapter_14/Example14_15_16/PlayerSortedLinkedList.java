/* The PlayerSortedLinkedList class
   Anderson, Franceschi
*/

public class PlayerSortedLinkedList extends ShellLinkedList
{
  // head and numberOfItems are inherited instance variables

  public PlayerSortedLinkedList( )
  {
    super( );
  }

  /** insert method
  *   @param    p   Player object to insert
  */
  public void insert( Player p )
  {
    PlayerNode pn = new PlayerNode( p );

    // we will insert after previous and before current
    PlayerNode current = head;
    PlayerNode previous = null;
    while ( current != null
         && ( current.getPlayer( ) ).getID( ) < p.getID( ) )
    {
      previous = current;
      current = current.getNext( );
    }

    if ( previous == null ) // insert as head
    {
      pn.setNext( head );
      head = pn;
    }
    else
    {
      pn.setNext( current );
      previous.setNext( pn );
    }
    numberOfItems++;
  }

  /** delete method
  *   @param    searchID   id of Player to delete
  *   @return   the Player deleted
  */
  public Player delete( int searchID )
                       throws DataStructureException
  {
    PlayerNode current = head;
    PlayerNode previous = null;
    while ( current != null
            && current.getPlayer( ).getID( ) != searchID )
    {
      if ( ( current.getPlayer( ) ).getID( ) > searchID )
           throw new DataStructureException
               ( searchID + " not found: cannot be deleted" );
      previous = current;
      current = current.getNext( );
    }

    if ( current == null ) // not found
           throw new DataStructureException
               ( searchID + " not found: cannot be deleted" );
    else        // searchID found at Player at node current
    {
      if ( current == head )
           head = head.getNext( );  // delete head
      else
           previous.setNext( current.getNext( ) );

      numberOfItems--;
      return current.getPlayer( );
    }
  }
}
