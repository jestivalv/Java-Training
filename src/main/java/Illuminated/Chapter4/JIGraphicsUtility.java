/** Se empeiza con un stage en el que se añaden una o más escenas 
 Después de añaden canvas a la escena y luego formas al canvas */

package Illuminated.Chapter4;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class JIGraphicsUtility {
	public static GraphicsContext setupGraphics (Stage stage, String title, int width, int height) {
		stage.setTitle(title);
		Canvas canvas = new Canvas ( width, height);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Group root = new Group (canvas);
		stage.setScene(new Scene (root));
		stage.show();	
		return gc;
		
	}
	
}
