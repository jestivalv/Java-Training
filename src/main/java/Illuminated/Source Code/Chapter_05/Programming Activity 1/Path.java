/* Path.java
*  Anderson, Franceschi
*/

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;

public class Path
{
 private final int PAR = 72;
 private int inputScore;        // the score
 private String codeResult;     // Over Par or Par or less
 private String correctness;    // correct or incorrect
 private String verb;           // is (correct) or was (incorrect)

 private int startX = 50;
 private int startY = 20;
 private int startXFace = 550; // 600
 private int startYFace = 30; // 125;

 private double c = 1.4;        // coefficient for the size of the happy/unhappy faces
 
 private int w = 220; 
 private int h = 60;
 private int top = 50; // top of top rectangle
 private int left = 100;
 private int hSpace = 40;// 80;

 private final Color GREEN = Color.GREEN;
 private Color leftSideColor;
 private Color rightSideColor;

 private Color overParColor;
 private Color parColor;
 private Color belowParColor;

 public Path( )
 {
    inputScore = -1;
    codeResult = "unknown";
    correctness = "unknown";
    verb = "unknown";
 }

 public void setInputScore( int is )
 {
      inputScore = is;
 }

 public void setCodeResult( String cr )
 {
    codeResult = cr;
 }

 public void setCorrectness( )
 {
   if (inputScore > PAR && codeResult.equalsIgnoreCase( "over par" ) )
   {
      correctness = "correct";
      verb = "is";
   }
   else if ( inputScore < PAR && codeResult.equalsIgnoreCase( "below par" ) )
   {
      correctness = "correct";
      verb = "is";
   }
   else if ( inputScore == PAR && codeResult.equalsIgnoreCase( "par" ) )
   {
      correctness = "correct";
      verb = "is";
   }
   else
   {
      correctness = "incorrect";
      verb = "was";
   }
 }

 public void setSideColors( )
 {
   if ( inputScore > PAR && correctness.equals( "correct" ) )
   {
         leftSideColor = GREEN;
         rightSideColor = Color.LIGHTGRAY;
   }
   else if ( inputScore <= PAR && correctness.equals( "correct" ) )
   {
         rightSideColor = GREEN;
         leftSideColor = Color.LIGHTGRAY;
   }
   else if ( inputScore > PAR && correctness.equals( "incorrect" ) )
   {
         leftSideColor = GREEN;
         rightSideColor = Color.LIGHTGRAY;
   }
   else
   {
         rightSideColor = GREEN;
         leftSideColor = Color.LIGHTGRAY;
   }
 }

 public void setSideCorrectColors( )
 {
   parColor = Color.LIGHTGRAY;
   overParColor = Color.LIGHTGRAY;
   belowParColor = Color.LIGHTGRAY;

   if ( inputScore > PAR )
   {
         overParColor = GREEN;
   }
   else if ( inputScore == PAR )
   {
         parColor = GREEN;
   }
   else
   {
         belowParColor = GREEN;
   }
 }

 public void draw( GraphicsContext gc )
 {
    // set correctness value
    setCorrectness( );
    // draw Face
    drawFace( gc );
    // draw right path (correct path according to input)
    drawCorrectPath( gc );
    // draw code inside rectangles
    drawCode2( gc );
    // draw a String representing the score entered
    drawScore( gc );
    // draw a String representing the result given by the code
    drawCodeResult( gc );
    // draw a String representing whether the result is correct or incorrect
    drawResultCorrectness( gc );
    // draw Headers
    drawHeaders( gc );
 }

 public void drawCorrectPath( GraphicsContext gc )
 {
    gc.setFill( GREEN );

    // entry line to "> 72 ?"
    gc.fillRect( startX + left + w / 2 - 1, startY + 30, 3, top - 30 );

    // "> 72 ?"
    gc.fillRoundRect( startX + left, startY + top, w, h, 10, 10 );

    // "continue"
    gc.fillRoundRect( startX + left, startY + top + 3 * h + 3 * hSpace, w, h, 10, 10 );

    // "continue" to out
    gc.fillRect( startX + left + w / 2 - 1, startY + top + 4 * h + 3 * hSpace, 3, 25 );

    ///////// over par path drawing //////////////////////////////////
    gc.setFill( overParColor );
    gc.setStroke( overParColor );

    // line to "over par" assignment
    gc.strokeLine( startX + left + w / 2, startY + top + h, startX + left - 2 * w / 3 + w / 2, startY + 50 + h + hSpace );
    gc.strokeLine( startX + left + w / 2 - 1, startY + top + h, startX + left - 2 * w / 3 + w / 2 - 1, startY + 50 + h + hSpace );
    gc.strokeLine( startX + left + w / 2 + 1, startY + top + h, startX + left - 2 * w / 3 + w / 2 + 1, startY + 50 + h + hSpace );

    // "over par" assignment
    gc.fillRoundRect( startX + left - 2 * w / 3, startY + top + h + hSpace, w, h, 10, 10 );

    // straight line from "over par" assignment
    gc.strokeLine( startX + left - 2 * w / 3 + w / 2, startY + top + 2 * h + hSpace, startX + left - 2 * w / 3 + w / 2, startY + 50 + 3 * h + 2 * hSpace );
    gc.strokeLine( startX + left - 2 * w / 3 + w / 2 - 1, startY + top + 2 * h + hSpace, startX + left - 2 * w / 3 + w / 2 - 1, startY + 50 + 3 * h + 2 * hSpace );
    gc.strokeLine( startX + left - 2 * w / 3 + w / 2 + 1, startY + top + 2 * h + hSpace, startX + left - 2 * w / 3 + w / 2 + 1, startY + 50 + 3 * h + 2 * hSpace );

    // left line to continue
    gc.strokeLine( startX + left - 2 * w / 3 + w / 2, startY + top + 3 * h + 2 * hSpace, startX + 100 + w / 2, startY + 50 + 3 * h + 3 * hSpace );
    gc.strokeLine( startX + left - 2 * w / 3 + w / 2 - 1, startY + top + 3 * h + 2 * hSpace, startX + 100 + w / 2 - 1, startY + 50 + 3 * h + 3 * hSpace );
    gc.strokeLine( startX + left - 2 * w / 3 + w / 2 + 1, startY + top + 3 * h + 2 * hSpace, startX + 100 + w / 2 + 1, startY + 50 + 3 * h + 3 * hSpace );

    ///////// par and below par path drawing /////////////////////////
    if ( inputScore <= PAR )
    {
        gc.setFill( GREEN );
        gc.setStroke( GREEN );
    }
    else
    {
        gc.setFill( Color.LIGHTGRAY );
        gc.setStroke( Color.LIGHTGRAY );
    }
    // line to test for == 72
    gc.strokeLine( startX + left + w / 2, startY + top + h, startX + left + w - w / 3 + w / 2, startY + top + h + hSpace );
    gc.strokeLine( startX + left + w / 2 - 1, startY + top + h, startX + left + w - w / 3 + w / 2 - 1, startY + top + h + hSpace );
    gc.strokeLine( startX + left + w / 2 + 1, startY + top + h, startX + left + w - w / 3 + w / 2 + 1, startY + top + h + hSpace );

    // test for == 72
    gc.fillRoundRect( startX + left + w - w / 3, startY + top + h + hSpace, w, h, 10, 10 );

    ///////// par path drawing ///////////////////////////////////////
    gc.setFill( parColor );
    gc.setStroke( parColor );

    // line to "par" assignment
    gc.strokeLine( startX + left + w - w / 3 + w / 2, startY + top + 2 * h + hSpace, startX + left + w / 2, startY + top + 2 * h + 2 * hSpace );
    gc.strokeLine( startX + left + w - w / 3 + w / 2 - 1, startY + top + 2 * h + hSpace, startX + left + w / 2 - 1, startY + top + 2 * h + 2 * hSpace );
    gc.strokeLine( startX + left + w - w / 3 + w / 2 + 1, startY + top + 2 * h + hSpace, startX + left + w / 2 + 1, startY + top + 2 * h + 2 * hSpace );

    // "par" assignment
    gc.fillRoundRect( startX + left, startY + top + 2 * h + 2 * hSpace, w, h, 10, 10 );

    // straight line from "par" assignment to continue
    gc.strokeLine( startX + left + w / 2, startY + top + 3 * h + 2 * hSpace, startX + left + w / 2, startY + top + 3 * h + 3 * hSpace );
    gc.strokeLine( startX + left + w / 2 - 1, startY + top + 3 * h + 2 * hSpace, startX + left + w / 2 - 1, startY + top + 3 * h + 3 * hSpace );
    gc.strokeLine( startX + left + w / 2 + 1, startY + top + 3 * h + 2 * hSpace, startX + left + w / 2 + 1, startY + top + 3 * h + 3 * hSpace );

    ///////// below par path drawing /////////////////////////////////
    gc.setFill( belowParColor );
    gc.setStroke( belowParColor );

    // line to "below par" assignment
    gc.strokeLine( startX + left + w - w / 3 + w / 2, startY + top + 2 * h + hSpace, startX + left + w + w / 3 + w / 2, startY + top + 2 * h + 2 * hSpace );
    gc.strokeLine( startX + left + w - w / 3 + w / 2 - 1, startY + top + 2 * h + hSpace, startX + left + w + w / 3 + w / 2 - 1, startY + top + 2 * h + 2 * hSpace );
    gc.strokeLine( startX + left + w - w / 3 + w / 2 + 1, startY + top + 2 * h + hSpace, startX + left + w + w / 3 + w / 2 + 1, startY + top + 2 * h + 2 * hSpace );

    // "below par" assignment
    gc.fillRoundRect( startX + left + w + w / 3, startY + top + 2 * h + 2 * hSpace, w, h, 10, 10 );

    // line from "below par" assignment to continue
    gc.strokeLine( startX + left + w + w / 3 + w / 2, startY + top + 3 * h + 2 * hSpace, startX + left + w / 2, startY + top + 3 * h + 3 * hSpace );
    gc.strokeLine( startX + left + w + w / 3 + w / 2 - 1, startY + top + 3 * h + 2 * hSpace, startX + left + w / 2 - 1, startY + top + 3 * h + 3 * hSpace );
    gc.strokeLine( startX + left + w + w / 3 + w / 2 + 1, startY + top + 3 * h + 2 * hSpace, startX + left + w / 2 + 1, startY + top + 3 * h + 3 * hSpace );
 }

 public void drawFace( GraphicsContext gc )
 {
   if ( correctness.equals( "correct" ) )
        drawHappyFace( gc );
   else
        drawUnHappyFace( gc );
 }

 public void drawHappyFace( GraphicsContext gc )
 {
   // draw happy face
   // ep xface sub 125,expression yface add 175

   gc.setFill( Color.YELLOW );
   gc.fillOval( startXFace, startYFace, (int) ( c * 150 ), (int) ( c * 150 ) );

   // draw eyes
   gc.setFill( Color.BLACK );
   gc.setStroke( Color.BLACK );
   gc.strokeLine( (int) ( startXFace + 35 * c ), (int) ( startYFace + 50 * c ),
              (int) ( startXFace + 35 * c + c * 25 ), (int) ( startYFace + 50 * c ) );
   gc.strokeLine( (int) ( startXFace + 85 * c ), (int) ( startYFace + 50 * c ),
              (int) (startXFace + 85 * c + c * 25 ), (int) ( startYFace + 50 * c ) );

   // draw nose
   gc.strokeLine( (int) ( startXFace + 72 * c ), (int) ( startYFace + 70 * c ),
              (int) ( startXFace + 72 * c ), (int) ( startYFace + 70 * c + 20 * c ) );

   // draw mouth
   gc.strokeArc( (int) ( startXFace + 35 * c ), (int) ( startYFace + 50 * c ),
             (int) ( 75 * c ), (int) ( 75 * c ), 0, -180, ArcType.OPEN );
 }

 public void drawUnHappyFace( GraphicsContext gc )
 {
   // draw unhappy face

   gc.setFill( Color.YELLOW );
   gc.fillOval( startXFace, startYFace, (int) (150*c), (int) (150*c));

   // draw eyes
   gc.setFill( Color.BLACK );
   gc.setStroke( Color.BLACK );
   gc.strokeLine( (int) (startXFace + 35*c), (int) (startYFace + 25*c), (int) (startXFace + 60*c), (int) (startYFace + 25*c) );
   gc.strokeLine( (int) (startXFace + 85*c), (int) (startYFace + 25*c), (int) (startXFace + 110*c), (int) (startYFace + 25*c) );

   // draw nose
   gc.strokeLine( (int) (startXFace + 72*c), (int) (startYFace + 45*c), (int) (startXFace + 72*c), (int) (startYFace + 65*c) );

   // draw mouth
   gc.strokeArc( (int) (startXFace + 35*c), (int) (startYFace + 75*c), (int) (75*c), (int) (50*c), 0, 180, ArcType.OPEN );

   // draw tear

   //  center to right - down
   gc.strokeArc( (int) (startXFace + 48*c), (int) (startYFace + 23*c), (int) (10*c), (int) (20*c), -90, -105, ArcType.OPEN );

   // center to left - down
   gc.strokeArc( (int) (startXFace + 33*c), (int) (startYFace + 20*c), (int) (15*c), (int) (25*c), 0, -45, ArcType.OPEN );

   // circle
   gc.strokeArc( (int) (startXFace + 43*c), (int) (startYFace + 40*c), (int) (10*c), (int) (10*c), 30, -270, ArcType.OPEN );
 }

 public void drawScore( GraphicsContext gc )
 {
   Font largeFont = new Font( Dimensions.LARGE_FONT_SIZE );
   gc.setFont( largeFont );  
   gc.setFill( Color.BLACK );
   gc.fillText( "The score was " + inputScore, startX, startY + top + 4 * h + 4 * hSpace );
 }

 public void drawCodeResult( GraphicsContext gc )
 {
   // "continue" to out
   // gc.fillRect( startX + left + w / 2, startY + top + 4 * h + 3 * hSpace, 3, 25 );
 
   Font largeFont = new Font( Dimensions.LARGE_FONT_SIZE );
   gc.setFont( largeFont );  
   gc.setFill( Color.BLACK );
   gc.fillText( "The result given by your code is ", startX, startY + top + 4 * h + 4 * hSpace + 40 );
   gc.setFill( Color.BLUE );
   gc.fillText( codeResult, startX + 400, startY + top + 4 * h + 4 * hSpace + 40 );
   gc.setFill( Color.BLACK );
 }

 public void drawResultCorrectness( GraphicsContext gc )
 {
   Font largeFont = new Font( Dimensions.LARGE_FONT_SIZE );
   gc.setFont( largeFont );  
   gc.setFill( Color.BLACK );
   gc.fillText( "The result given by your code is ", startX, startY + top + 4 * h + 4 * hSpace + 40 + 40 );
   if (correctness.equals( "correct" ) )
        gc.setFill( Color.GREEN );
   else
        gc.setFill( Color.RED );
   gc.fillText( correctness.toUpperCase( ), startX + 400, startY + top + 4 * h + 4 * hSpace + 40 + 40 );
   gc.setFill( Color.BLACK );
 }

 public void drawHeaders( GraphicsContext gc )
 {
   gc.setFill( Color.RED );
   Font largeFont = new Font( Dimensions.LARGE_FONT_SIZE );
   gc.setFont( largeFont );  
   gc.fillText( "The correct path " + verb, startX + 20, startY );
 }

 public void drawCode2( GraphicsContext gc )
 {
   int left = 100;
   int top = 50;
   int h = 60;
   gc.setFill( Color.RED );
   Font largeFont = new Font( Dimensions.LARGE_FONT_SIZE );
   gc.setFont( largeFont );
   // startX + 100, startY + top
   gc.setFill( Color.BLACK );
   gc.fillText( "    score > 72 ?", startX + left + 10, startY + top + h / 3 );
   gc.fillText( "true: left   false: right", startX + left + 10, startY + top + 3 * h / 4 );

   gc.fillText( "true:", startX + left - 2 * w / 3 + w / 3, startY + top + h + hSpace + h / 3 );
   gc.fillText( "result = over par", startX + left - 2 * w / 3 + w / 10, startY + top + h + hSpace + 3 * h / 4 );

   gc.fillText( "false: score == " + PAR + " ?", startX + left + w - w / 3 + w / 10, startY + top + h + hSpace + h / 3 );
   gc.fillText( "true: left false: right", startX + left + w - w / 3 + w / 10, startY + top + h + hSpace + 3 * h / 4 );


   gc.fillText( "true:", startX + left + w / 3 + w / 20, startY + top + 2 * h + 2 * hSpace + h / 3 );
   gc.fillText( "result = par", startX + left + w / 5, startY + top + 2 * h + 2 * hSpace + 3 * h / 4 );

   gc.fillText( "false:", startX + left + w + w / 3 + w / 3, startY + top + 2 * h + 2 * hSpace + h / 3 );
   gc.fillText( "result = below par", startX + left + w + w / 3 + w / 20, startY + top + 2 * h + 2 * hSpace + 3 * h / 4 );

   gc.fillText( "Continue", startX + left + w / 4, startY + top + 3 * h + 3 * hSpace + 2 * h / 3 );
 }
}
