/* The RecursiveLinkedList class
   Anderson, Franceschi
*/

public class RecursiveLinkedList<T>
{
  private T first;
  private RecursiveLinkedList<T> rest;

  public RecursiveLinkedList( )
  {
    first = null;
    rest = null;
  }

  /** insert method
  *   @param    item   object to insert at beginning of list
  */
  public void insert( T item )
  {
    if ( isEmpty( ) )    // is list empty?
      first = item;
    else
    {
      RecursiveLinkedList<T> tempList =
                new RecursiveLinkedList<T>( );
      tempList.first = first;
      tempList.rest = rest;
      first = item;
      rest = tempList;
    }
  }

  /** delete method
  *   @param    item   the T object to delete
  *   @return   true   if item is deleted, false otherwise
  */
  public boolean delete( T item )
  {
    if ( isEmpty( ) )                   // is list empty?
      return false;
    else if ( first.equals( item ) )  // found it
    {
      T temp = first;
      if ( rest == null )
        first = null;
      else       // rest not null
      {
        first = rest.first;
        rest = rest.rest;
      }
      return true;
    }
    else if ( rest == null )
      return false;
    else                                  // try to delete in rest
      return rest.delete( item );
  }

  /** isEmpty  method
  *  @return  true if the list has no elements; 
  *           false, otherwise
  */
  public boolean isEmpty( )
  {
    return ( first == null );
  }

  /** toString method
  *  @return a String listing the elements in the list
  */
  @Override
  public String toString( )
  {
    String listString = "";
    if ( first != null )
    {
      listString = first.toString( ) + "\n";
      if ( rest != null )
        listString += rest.toString( );
    }
    return listString;
  }
}
