/** NestedLayoutPracticeApplication class Ch 12 PA2
*   Anderson, Franceschi
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NestedLayoutPracticeApplication extends Application 
{  

  @Override
  public void start( Stage stage ) 
  {
    NestedLayoutPractice root = new NestedLayoutPractice( );

    Scene scene = new Scene( root, 375, 350 );
    stage.setTitle( "Practice Nested Layouts" );
    stage.setScene( scene ); 
    stage.show( );   
  }
 
  public static void main( String [] args ) 
  {
    launch( args );
  }
}