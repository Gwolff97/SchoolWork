//Author: Gerald Wolff
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PlayerPane extends Pane{
	Player playerState;
	
	public PlayerPane (Player player){
		playerState = player;
		ImageView playerImage = new ImageView ("http://web.cs.sunyit.edu/~realemj/2017spring/cs249/files/char.png");
		
		playerImage.setFitWidth(MapPane.TILE_WIDTH);
		playerImage.setFitHeight(MapPane.TILE_HEIGHT);
		
		getChildren().add(playerImage);
		
		this.translateXProperty().bind(playerState.getXProperty().multiply(MapPane.TILE_WIDTH));
		this.translateYProperty().bind(playerState.getYProperty().multiply(MapPane.TILE_HEIGHT));

	}
}
