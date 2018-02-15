package Illuminated.Chapter4;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class ShellGraphicsApplication extends Application{
	
	@Override
	public void start(Stage stage) {
		final int HEIGHT = 400;
		final int WIDTH = 700;
		GraphicsContext gc = JIGraphicsUtility.setupGraphics(stage, "Titulo", WIDTH, HEIGHT);
		gc.strokeLine(100, 125, 100, 300);
		gc.setStroke(Color.RED);
		gc.setLineWidth(5);
		gc.strokeLine(300, 75, 550, 75);
		
		gc.setFill( Color.CYAN ); 
		gc.setStroke( Color.ORANGE );
		gc.strokeRect( 100, 50, 80, 200 );
		gc.fillRect( 275, 75, 160, 160 );
		
		gc.fillOval( 100, 50, 80, 200 ); 
		gc.strokeOval( 100, 275, 200, 80 );
		
		gc.setFill( Color.MEDIUMSEAGREEN );
		int centerX = 550, centerY = 275; 
		int radius = 75; 
		gc.fillOval( centerX-radius, centerY-radius, radius * 2, radius * 2 );
		
		
		Random rand = new Random();
		int red = rand.nextInt(0xFF);
		int green = rand.nextInt(0xFF);
		int blue = rand.nextInt(0xFF);
		
		Color randomColor = Color.rgb(red, green, blue);
		gc.setStroke(randomColor);
		gc.strokeLine(0, 0, WIDTH - 1, HEIGHT -1);
		
		
		String message = "Programming is not a spectator sport!";
		gc.setFill( Color.RED ); 
		gc.fillText( message, 100, 100 ); 
		Font largeFont = new Font( 28 ); 
		gc.setFont( largeFont ); 
		gc.setStroke( Color.RED );
		gc.strokeText( message, 100, 250 );
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Metodo de Application.
		launch (args);

	}

}
