/* The PlayerLinkedList class
   Anderson, Franceschi
*/

public class PlayerLinkedList extends ShellLinkedList
{

  /** default constructor
  *   calls constructor of ShellLinkedList class
  */
  public PlayerLinkedList(  )
  {
    super( );
  }

  /** insert method
  *   @param    p   Player object to insert
  */
  public void insert( Player p )
  {
    // insert as head
    PlayerNode pn = new PlayerNode( p );
    pn.setNext( head );
    head = pn;
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
      previous = current;
      current = current.getNext( );
    }

    if ( current == null ) // not found
         throw new DataStructureException( searchID
                     + " not found: cannot be deleted" );
    else
    {
      if ( current == head )
        head = head.getNext( );  // delete head
      else
        previous.setNext( current.getNext( ) );

      numberOfItems--;
      return current.getPlayer( );
    }
  }

  /** peek method
  *   @param    searchID   id of Player to search for
  *   @return   the Player found
  */
  public Player peek( int searchID )
               throws DataStructureException
  {
    PlayerNode current = head;
    while ( current != null
            && current.getPlayer( ).getID( ) != searchID )
    {
      current = current.getNext( );
    }

    if ( current == null ) // not found
         throw new DataStructureException( searchID
                     + " not found: cannot peek" );
    else
    {
      return current.getPlayer( );
    }
  }
}
