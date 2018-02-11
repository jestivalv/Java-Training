/* The Player Class
   Anderson, Franceschi
*/

public class Player
{
 private int id;
 private String name;
 private String game;

 /** constructor
 * @param id    player's id
 * @param name  player's name
 * @param game  player's game
 */
 public Player( int id, String name, String game )
 {
    setID( id );
    setName( name );
    setGame( game );
 }

 /** accessor for id
 * @return   id
 */
 public int getID( )
 {
    return id;
 }

 /** accessor for name
 * @return name
 */
 public String getName( )
 {
    return name;
 }

 /** accessor for game
 * @return game
 */
 public String getGame( )
 {
    return game;
 }

 /** mutator for Id
 * @param id  new value for id
 * @return    a reference to this object
 */
 public Player setID( int id )
 {
   this.id = id;
   return this;
 }

 /** mutator for name
 * @param name  new value for name
 * @return      a reference to this object
 */
 public Player setName( String name )
 {
    this.name = name;
    return this;
 }

 /** mutator for game
 * @param game  new value for game
 * @return      a reference to this object
 */
 public Player setGame( String game )
 {
    this.game = game;
    return this;
 }

 /** equals method
 *  @param o reference to object to compare to this object
 *  @return  true of o is Player objectand id, name, 
 *   and game are equal in both objects; false otherwise
 */
 @Override
 public boolean equals( Object o )
 {
   if (  ! ( o instanceof  Player ) )
       return false;
   else
   {
       Player  objPlayer = ( Player ) o;
       return ( id == objPlayer.id && name.equals( objPlayer.name )
              && game.equals( objPlayer.game ) );
   }
 }

 /** toString method
 *  @return  String representation of Player object
 */
 @Override
 public String toString( )
 {
    return ( "id: " + id + "\tname: "
             + name + "\tgame: " + game );
 }
}