/* The PlayerLinkedListTest class
   Anderson, Franceschi
*/

public class PlayerLinkedListTest
{
  public static void main( String [ ] args )
  {
    Player p1 = new Player( 7,"Sarah","Mario" );
    Player p2 = new Player( 2,"Jin","Golf" );
    Player p3 = new Player( 5,"Ajay","Sonic" );

    // construct empty PlayerLinkedList
    PlayerLinkedList players = new PlayerLinkedList( );
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

    Player temp;     // will be assigned the deleted item

    try
    {
      temp = players.delete( 8 );      // unsuccessful
      System.out.println( "Player deleted: " + temp );
    }
    catch ( DataStructureException dse1 )
    {
      System.out.println( dse1.getMessage( ) + "\n" );
    }

    try
    {
      temp = players.peek( 2 );        // test peek
      System.out.println( "Player retrieved: " + temp );
      System.out.println( "Number of items in the list: "
       + players.getNumberOfItems( ) + "\n" + players.toString( ) );

      temp = players.delete( 2 );      // delete in the middle
      System.out.println( "Player deleted: " + temp );
      System.out.println( "Number of items in the list: "
       + players.getNumberOfItems( ) + "\n" + players.toString( ) );

      temp = players.delete( 7 );      // delete the last item
      System.out.println( "Player deleted: " + temp );
      System.out.println( "Number of items in the list: "
       + players.getNumberOfItems( ) + "\n" + players.toString( ) );

      temp = players.delete( 5 );      // delete the first item
      System.out.println( "Player deleted: " + temp );
      System.out.println( "Number of items in the list: "
       + players.getNumberOfItems( ) + "\n" + players.toString( ) );

      temp = players.delete( 7 );      // delete from empty list
      System.out.println( "Player deleted: " + temp );
      System.out.println( "Number of items in the list: "
       + players.getNumberOfItems( ) + "\n" + players.toString( ) );
    }
    catch ( DataStructureException dse2 )
    {
      System.out.println( dse2.getMessage( ) );
    }
  }
}
