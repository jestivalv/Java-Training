/* The PlayerNode class
   Anderson, Franceschi
*/

public class PlayerNode
{
  private Player player;
  private PlayerNode next;
  /** default constructor
  *  initializes player and next references to null
  */
  public PlayerNode( )
  {
    player = null;
    next = null;
  }

  /**  overloaded constructor
  *  @param  player reference to Player object
  *  initializes player reference to player
  */
  public PlayerNode( Player player )
  {
    setPlayer( player );
    next = null;
  }

  /**  accessor for player
  *  @return player
  */
  public Player getPlayer( )
  {
    return player;
  }

  /**  accessor for next
  *  @return next
  */
  public PlayerNode getNext( )
  {
    return next;
  }

  /**  mutator for player
  *  @param player  new Player reference
  *  @return        a reference to this object
  */
  public PlayerNode setPlayer( Player player )
  {
    this.player = player;
    return this;
  }

  /**  mutator for next
  *  @param next  new reference to next PlayerNode
  *  @return     a reference to this object
  */
  public PlayerNode setNext( PlayerNode next )
  {
    this.next = next;
    return this;
  }
}
