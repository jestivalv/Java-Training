/* CashierDrawing Class
*  Anderson, Franceschi
*/

import java.util.ArrayList;

public class CashierDrawing
{
 // ArrayList representing the various Items and subtotals
 // as they are used by the loop
 private ArrayList<SubTotal> subTotals;
 SubTotal currentSubTotal;
 Item currentItem;
 // current index of subTotals
 private int index;

 private Cart cart;
                    
 public CashierDrawing( )
 {
   subTotals = new ArrayList<SubTotal>( );
   index = 0;
   cart = new Cart( );
 }

 public void checkout( )
 {
   /* ***** Student writes the body of this method ***** */
   //
   //  Using a while loop, calculate the total price
   //  of the groceries
   //
   // The getNext method (in this CashierDrawing class) returns the
   // next item on the conveyor belt, which is an Item object
   // (we do not know which item and we do not know how many items
   // are in the cart - this is randomly generated).
   // getNext does not take any arguments. Its API is:
   //       Item getNext( )
   //
   // Right after you update the current subtotal,
   // you should call the animate method.
   // The animate method takes one argument: a double,
   // which is your current subtotal.
   // For example, if the name of your variable representing
   // the current subtotal is total, your call to the animate
   // method should be:
   //    animate( total );
   //
   // The instance method getPrice of the Item class
   // returns the price of the Item object.
   // The method getPrice does not take any arguments.
   // Its API is:
   //         double getPrice( )
   //
   // The cart is empty when the getNext method returns
   // the divider Item.
   // You detect the divider item because its price
   // is -0.99. So an Item with a price of -0.99
   // is the sentinel value for the loop.
   //
 
   //
   //  End of student code
   //
  }

  public Item getNext( )
  {
   // get next item
   // if the first item is the divider, that is ok - the cart is empty
   int number = ( (int) ( Math.random( ) * cart.getItemSize( ) ) );
   cart.setCurrentItem( number );
      
   Item item = ( cart.getItems( ) )[cart.getCurrentItem( )];
   // update subTotal
   currentItem = item;
   currentSubTotal = new SubTotal( item, 0 );
   return item;
 }
 
  public void animate( double total )
  {
   // update subTotals
   currentSubTotal.setSubTotal( total );
   // put subtotal in ArrayList
   subTotals.add( currentSubTotal );
  }
  
  public void reset( )
  {
   index = 0;
  }
  
  public void incrementIndex( )
  {
   index++;
  }
  
  public int getIndex( )
  {
   return index;
  }
  
  public boolean done( )
  {
    return index >= subTotals.size( );
  } 
  
  public SubTotal getSubTotal( int index )
  {
    return subTotals.get( index );
  }
  
  public String toString( )
  {
    String result = "List: ";
    for( SubTotal current : subTotals )
    {
      result += current.toString( ) + " ";
    }
    return result;
  }
  
  public void addDivider( )
  {
    double finalTotal = 0;
    if ( subTotals.size( ) >= 1 )
      finalTotal = subTotals.get( subTotals.size( ) - 1 ).getSubTotal( );
    SubTotal last = new SubTotal( new Divider( -0.99 ), finalTotal );
    subTotals.add( last );
  }
}