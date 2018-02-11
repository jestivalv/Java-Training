/* AutoState class
*  Anderson, Franceschi
*/
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.text.DecimalFormat;
import javafx.scene.text.Font;

public class AutoState
{
 private int value;
 private Auto auto;

 public AutoState( Auto auto, int value )
 {
  this.auto = auto;
  this.value = value;;
 }

 public int getValue( )
 {
  return value;
 }
 
 public Auto getAuto( )
 {
  return auto;
 }
 
 @Override
 public String toString( )
 {
  String result = "";
  result += auto + "; " + value; 
  return result;
 }

}
