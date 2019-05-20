//Author: Gerald Wolff
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.Scanner;
import java.net.*;

public class Assign9 extends Application{
	
	public void start (Stage primaryStage){
		try{
			
			Scanner input = new Scanner (new URL ("http://web.cs.sunyit.edu/~realemj/2017spring/cs249/files/Map01.txt").openStream());
			Map map = new Map();
			map.load(input);
			
			MapPane newPane = new MapPane (map);
			
			Pane displayPane = new Pane ();
			displayPane.getChildren().add(newPane);
			
			Player player = new Player (5,5);
			
			PlayerPane playerPane = new PlayerPane (player);
			
			displayPane.getChildren().add(playerPane);
			
			Scene scene = new Scene (displayPane);
			
			scene.setOnKeyPressed(e -> {
				IntegerProperty xCheck = player.getXProperty();
				IntegerProperty yCheck = player.getYProperty();
				
				switch (e.getCode()){
				
				case A:
					xCheck.setValue(xCheck.intValue()-1);
					if (map.canMoveTo(xCheck.intValue(), yCheck.intValue())){
						player.setX(xCheck.intValue());
						player.setY(yCheck.intValue());
					}
					else{
					xCheck.setValue(xCheck.intValue()+1);
					}
					break;
				
				case D:
					xCheck.setValue(xCheck.intValue()+1);
					if (map.canMoveTo(xCheck.intValue(), yCheck.intValue())){
						player.setX(xCheck.intValue());
						player.setY(yCheck.intValue());
					}
					else{
					xCheck.setValue(xCheck.intValue()-1);
					}
					break;
				
				case W:
					yCheck.setValue(yCheck.intValue()-1);
					if (map.canMoveTo(xCheck.intValue(), yCheck.intValue())){
						player.setX(xCheck.intValue());
						player.setY(yCheck.intValue());
					}
					else{
					yCheck.setValue(yCheck.intValue()+1);
					}
					break;
					
				case S:
					yCheck.setValue(yCheck.intValue()+1);
					if (map.canMoveTo(xCheck.intValue(), yCheck.intValue())){
						player.setX(xCheck.intValue());
						player.setY(yCheck.intValue());
					}
					else{
					yCheck.setValue(yCheck.intValue()-1);
					}
					break;
					
					default:
						break;
				}
			});
			
			primaryStage.setTitle("NewHack");
			primaryStage.setScene(scene);
			primaryStage.show();
		
		
		}
		catch (Exception e){
			e.printStackTrace();
			Platform.exit();
		}
	}
	public static void main (String[] args){
		launch (args);
	}

}
