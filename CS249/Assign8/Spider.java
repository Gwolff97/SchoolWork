//Author: Gerald Wolff
public class Spider extends Monster {

	public Spider () {
	}
	
	public Spider ( int newX, int newY, int newHealth) {
		super.setX(newX);
		super.setY(newY);
		super.setHealth(newHealth);
		}
	@Override	
	public void drawToMap (Map screen) {
		if (screen.equals(null))
		{
			return;
		}
		
		screen.mapData [super.getY()][super.getX()] = 'S';
	}
}	

