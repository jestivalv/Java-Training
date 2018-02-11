/* MultiPath
* Anderson, Franceschi
*/

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;

public class MultiPath
{
 private int w = 150; // width of rectangles
 private int h = 40; // height of rectangles
 private int vSpace = 30; // vertical space between rectangles
 private int hSpace = 80; // horizontal space between rectangles

 private final Color GREEN = Color.SPRINGGREEN;
 // array path keeps track of the path
 private boolean [] path = { false, false, false, false, false, false };

 // count counts how many times the method animate was called
 // therefore deducting when the code hits the first break statement
 private int count = 0;

 // current is the value of test in MultiPathClient
 private int current;

 // makes sure we only draw once
 private boolean control = true;

 // 2 seconds of pause between the 2 images
 private static int animationPause = 2;

 public MultiPath( )
 {
 }

 public MultiPath( boolean [] p, int c1, int c2 )
 {
  setPath( p );
  count = c1;
  current = c2;
 }

 public void resetPath( )
 {
  for ( int i = 0; i < path.length; i++ )
  {
    path[i] = false;
  }
 }

 public void setPath( boolean [] p )
 {
  for ( int i = 0; i < path.length; i++ )
  {
    path[i] = p[i];
  }
 }

 public void setPath( int i, boolean b )
 {
  // reset path
  for ( int j = 0; j < path.length; j++ )
    path[j] = false;

  if ( i >= 0 && i < path.length )
        path[i] = true;
  else
        path[path.length - 1] = true;
 }

 public void setCount( int c )
 {
  count = c;
 }

 public int getCount( )
 {
  return count;
 }

 public void setCurrent( int c )
 {
  current = c;
  // System.out.println( "current = " + current );
 }

 public void setControl( boolean b )
 {
  control = b;
 }

 public void addToCount( )
 {
  count++;
 }

 public int firstIndexTrue( )
 {
  int temp = -1;
  for ( int i = 0; i < path.length; i++ )
  {
     if ( path[i] )
     {
      return i;
     }
  }
  return temp;
 }

 public int lastIndexTrue( )
 {
  return ( firstIndexTrue( ) + count - 1 );
 }

 public void displayCountAndIndexes( )
 {
  int firstIndex = firstIndexTrue( );
  System.out.print( "count = " + count );
  System.out.print( "\tfirstIndex = " + firstIndex );
  System.out.println( "\tlastIndex true = " + ( firstIndex + count - 1 ) );
 }

 public void draw( GraphicsContext gc )
 {
  // displayCountAndIndexes( );
  if ( control )
    drawPath( gc );
 }

 public void drawPath( GraphicsContext gc )
 {
  Font largeFont = new Font( Dimensions.LARGE_FONT_SIZE );
  gc.setFont( largeFont );

  int startX = 100, startY = 25;
  gc.setFill( GREEN );
  // vertical entry line (1st line)
  gc.fillRect( startX - 2, startY, 5, 25 );
  // entry rectangle (1st rectangle)
  gc.fillRoundRect( startX - w / 2, startY + 25, w, h, 10, 10 );
  // 2nd vertical line
  gc.fillRect( startX - 2, startY + 25 + h, 5, vSpace );
  // 2nd rectangle
  gc.fillRoundRect( startX - w / 2, startY + 25 + vSpace + h, w, h, 10, 10);
  // 8th right line
  // last rectangle
  gc.fillRoundRect( startX + w + 2 * hSpace, startY + 25 + 7 * ( vSpace + h ), w, h, 10, 10 );
  // last line
  gc.fillRect( startX + w + w / 2 + 2 * hSpace - 2, startY + 25 + 7 * ( vSpace + h ) + h, 5, 25 );
  //////////////////////////////////////////
  // NOW select drawing color depending on objects to draw and path

  // displayCountAndIndexes( );

  // left rectangles
  gc.setFill( Color.LIGHTGRAY );
  for ( int i = 1; i < path.length; i++ )
  {
   if ( i <= firstIndexTrue( ) )
        gc.setFill( GREEN );
   else
        gc.setFill( Color.LIGHTGRAY );
   gc.fillRoundRect(startX - w / 2, startY + 25 + ( vSpace + h ) * ( i + 1 ), w, h, 10, 10 );
  }

  // left vertical lines
  gc.setFill( Color.LIGHTGRAY );
  for ( int i = 0; i < path.length -  1; i++ )
  {
   if ( i < firstIndexTrue( ) )
        gc.setFill( GREEN );
   else
        gc.setFill( Color.LIGHTGRAY );
   gc.fillRect( startX - 2, startY + 25 + h + ( vSpace + h ) * ( i + 1 ), 5, vSpace );
  }

  // middle vertical lines
  gc.setFill( Color.LIGHTGRAY );
  for ( int i = 0; i < path.length -  1; i++ )
  {
   if ( i >= firstIndexTrue( ) && i < lastIndexTrue( ) )
        gc.setFill( GREEN );
   else
        gc.setFill(Color.LIGHTGRAY);
   gc.fillRect( startX + w + hSpace - 2, startY + 25 +  h + ( vSpace + h ) * ( i + 1 ), 5, vSpace);
  }

  // right vertical lines
  gc.setFill(Color.LIGHTGRAY);
  for ( int i = 0; i < path.length; i++ )
  {
   if ( i >= lastIndexTrue( ) )
        gc.setFill( GREEN );
   else
        gc.setFill( Color.LIGHTGRAY );
   gc.fillRect( startX + w + 2 * hSpace + w / 2 - 2, startY + 25 + h + + h / 2 + vSpace + ( vSpace + h ) * i, 5, vSpace + h );
  }
  
  gc.setFill(Color.BLUE);
  gc.setFill(Color.LIGHTGRAY);

  // left horizontal lines
  gc.setFill( Color.LIGHTGRAY );
  for ( int i = 0; i < path.length; i++ )
  {
   if ( i == firstIndexTrue( ) )
        gc.setFill( GREEN );
   else
        gc.setFill( Color.LIGHTGRAY );
   gc.fillRect( startX + w / 2, startY + h + 25 + vSpace + h / 2 + ( vSpace + h ) * i, hSpace, 5 );
  }

  // 2nd right rectangles
  gc.setFill(Color.LIGHTGRAY);
  for ( int i = 0; i < path.length; i++ )
  {
   if ( i >= firstIndexTrue( ) && i <= lastIndexTrue( ) )
        gc.setFill( GREEN );
   else
        gc.setFill( Color.LIGHTGRAY );
   gc.fillRoundRect( startX + w / 2 + hSpace, startY + 25 + ( vSpace + h ) * ( i + 1 ), w, h, 10, 10 );
  }

  // right horizontal lines
  gc.setFill( Color.LIGHTGRAY );
  for ( int i = 0; i < path.length; i++ )
  {
   if ( i == lastIndexTrue( ) )
        gc.setFill( GREEN );
   else
        gc.setFill( Color.LIGHTGRAY );
   gc.fillRect( startX + w / 2 + hSpace + w, startY + h + 25 + vSpace + h / 2 + ( vSpace + h ) * i, hSpace,5 );
  }

  gc.setFill( Color.BLACK );
  gc.fillText( "switch(value)", startX - w / 3, startY + 25 + 3 * h / 5 );
  gc.fillText( "case 0: ?", startX - w / 5, startY + 25 + 3 * h / 5 + h + vSpace );
  gc.fillText( "case 1: ?", startX - w / 5, startY + 25 + 3 * h / 5 + 2 * ( h + vSpace ) );
  gc.fillText( "case 2: ?", startX - w / 5, startY + 25 + 3 * h / 5 + 3 * ( h + vSpace ) );
  gc.fillText( "case 3: ?", startX - w / 5, startY + 25 + 3 * h / 5 + 4 * ( h + vSpace ) );
  gc.fillText( "case 4: ?", startX - w / 5, startY + 25 + 3 * h / 5 + 5 * ( h + vSpace ) );
  gc.fillText( "default:", startX - w / 5, startY + 25 + 3 * h / 5 + 6 * ( h + vSpace ) );

  gc.fillText( "Value is 0", startX + w / 2 + hSpace + w / 4, startY + 25 + vSpace + h + 3 * h / 5  );
  gc.fillText( "Value is 1", startX + w / 2 + hSpace + w / 4, startY + 25 + 2 * vSpace + 2 * h + 3 * h / 5  );
  gc.fillText( "Value is 2", startX + w / 2 + hSpace + w / 4, startY + 25 + 3 * vSpace + 3 * h + 3 * h / 5 );
  gc.fillText( "Value is 3", startX + w / 2 + hSpace + w / 4, startY + 25 + 4 * vSpace + 4 * h + 3 * h / 5 );
  gc.fillText( "Value is 4", startX + w / 2 + hSpace + w / 4, startY + 25 + 5 * vSpace + 5 * h + 3 * h / 5 );
  gc.fillText( "Value not valid", startX + w / 2 + hSpace + w / 20, startY + 25 + 6 * vSpace + 6 * h + 3 * h / 5 );

  gc.fillText( "Continue", startX - w / 2 + 2 * w + 2 * hSpace - w / 4, startY + 25 + 7 * vSpace + 7 * h + 3 * h / 5 );
  
  gc.setFill( Color.RED );
  gc.fillText( "Value is " + current, startX + w / 2 + hSpace + w / 4, startY + 25 + h / 2 );

 }
}
