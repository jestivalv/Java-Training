/* The RecursiveLinkedListTest class
   Anderson, Franceschi
*/

public class RecursiveLinkedListTest
{
  public static void main( String [ ] args )
  {
    Player p1 = new Player( 7,"Sarah","Mario" );
    Player p2 = new Player( 2,"Jin","Golf" );
    Player p3 = new Player( 5,"Ajay","Sonic" );

    RecursiveLinkedList<Player> players =
                new RecursiveLinkedList<Player>( );
    System.out.println( "The list is\n"
        + ( players.isEmpty( ) ? "empty\n" : players.toString( ) ) );

    players.insert( p1 );
    System.out.println( "Inserting " + p1 );
    System.out.println( "The list is\n"
        + ( players.isEmpty( ) ? "empty\n" : players.toString( ) ) );

    players.insert( p2 );
    System.out.println( "Inserting " + p2);
    System.out.println( "The list is\n"
        + ( players.isEmpty( ) ? "empty\n" : players.toString( ) ) );

    players.insert( p3 );
    System.out.println( "Inserting " + p3 );
    System.out.println( "The list is\n"
        + ( players.isEmpty( ) ? "empty\n" : players.toString( ) ) );

    if ( players.delete( p2 ) )  // delete in middle of list
        System.out.println( "Player deleted: " + p2 );
    System.out.println( "The list is\n"
        + ( players.isEmpty( ) ? "empty\n" : players.toString( ) ) );

    if ( players.delete( p1 ) )  // delete at end of the list
        System.out.println( "Player deleted: " + p1 );
    System.out.println( "The list is\n"
        + ( players.isEmpty( ) ? "empty\n" : players.toString( ) ) );

    if ( players.delete( p1 ) )  // attempt to delete will fail
        System.out.println( "Player deleted: " + p1 );
    System.out.println( "The list is\n"
        + ( players.isEmpty( ) ? "empty\n" : players.toString( ) ) );

    if ( players.delete( p3 ) )  // delete only Player In list
        System.out.println( "\nPlayer deleted: " + p3 );
    System.out.println( "The list is\n"
        + ( players.isEmpty( ) ? "empty\n" : players.toString( ) ) );

    if ( players.delete( p3 ) )  // try to delete from empty list
        System.out.println( "\nPlayer deleted: " + p3 );
    System.out.println( "The list is\n"
        + ( players.isEmpty( ) ? "empty\n" : players.toString( ) ) );
  }
}
