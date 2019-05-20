//Author: Gerald Wolff
import java.util.Scanner;

public abstract class Monster implements Drawable, Loadable {
	private int x = 0;
	private int y = 0;
	private int health = 100;
	
	protected Monster () {}
	
	protected Monster (int newX, int newY, int newHealth) {
		x = newX;
		y = newY;
		health = newHealth;
	}
	
	public void setX (int newX) {
		x = newX;
	}
	
	public void setY (int newY) {
		y = newY;
	}
	
	public void setHealth (int newHealth ) {
		health = newHealth;
	}
	
	public int getX () {
		return x;
	}
	
	public int getY () {
		return y;
	}
	
	public int getHealth () {
		return health;
	}
	
	public void load (Scanner input)
	{
		x =  input.nextInt();
		y = input.nextInt();
		health = input.nextInt();
	
				
	}
	
	
}
