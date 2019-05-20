//Author: Gerald Wolff
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class MapPane extends Pane{
	
	public final static int TILE_WIDTH = 32;
	public final static int TILE_HEIGHT = 32;
	private Map currentMap;
	
	MapPane (Map map){
		currentMap = map;
		
		for (int i = 0; i < currentMap.getRows(); i ++ )
		{
			for (int j = 0; j < currentMap.getColumns(); j ++){
				Tile tile = new Tile (j*TILE_WIDTH, i*TILE_HEIGHT, currentMap.getMapLocation(j, i));
				getChildren().add(tile);
			}
		}
	}
	
	private class Tile extends Rectangle{
		private Tile (double x, double y, char type){
			super (x,y, TILE_WIDTH, TILE_HEIGHT);
			
			if (type == ' '){
				setFill(Color.BLACK);
			}
			
			if (type == '#'){
				setFill (Color.GREY);
			}
			
			if (type == '.'){
				setFill (Color.LIGHTGREY);
			}
		}
	}
	
	
	
}
