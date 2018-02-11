/* The LinkedListTest class
   Anderson, Franceschi
*/

public class LinkedListTest
{
  public static void main( String [ ] args )
  {
    Player p1 = new Player( 7,"Sarah","Mario" );
    Player p2 = new Player( 2,"Jin","Golf" );
    Player p3 = new Player( 5,"Ajay","Sonic" );

    // construct empty LinkedList of Player objects
    GenericLinkedList<Player> players = new GenericLinkedList<Player>( );
    System.out.println( "Number of items in the list: "
     + players.getNumberOfItems( ) + "\n" + players.toString( ) );

    players.insert( p1 );  // insert in empty list
    System.out.println( "Number of items in the list: "
     + players.getNumberOfItems( ) + "\n" + players.toString( ) );

    players.insert( p2 );  // insert in list of one item
    System.out.println( "Number of items in the list: "
     + players.getNumberOfItems( ) + "\n" + players.toString( ) );

    players.insert( p3 );  // insert in list of two items
    System.out.println( "Number of items in the list: "
     + players.getNumberOfItems( ) + "\n" + players.toString( ) );

    if ( players.delete(  p2 ) )     // delete in the middle
         System.out.println( "Player successfully deleted: "  );
    System.out.println( "Number of items in the list: "
     + players.getNumberOfItems( ) + "\n" + players.toString( ) );

    if ( players.delete(  p3 ) )     // delete at the beginning
      System.out.println( "Player successfully deleted: "  );
    System.out.println( "Number of items in the list: "
     + players.getNumberOfItems( ) + "\n" + players.toString( ) );
  }
}
