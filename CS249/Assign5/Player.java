//Author: Gerald Wolff

package Assignment5;
public class Player {
	
	private int [] position  = new int [2];
	private int health = 100;
	private Weapon CurrentWeapon;
	
	public Player (){}
	
	public Player ( int PositionX, int PositionY){
		position [0] = PositionX;
		position [1] = PositionY;
	}
	
	public int getX(){
		return position[0];
	}
	
	public int getY (){
		return position[1];
	}
	
	public int getHealth (){
		return health;
	}
	
	public Weapon getCurrentWeapon(){
			return CurrentWeapon;
		
	}
	
	public void setX( int newX){
		position[0] = newX;
	}

	public void setY(int newY){
		position [1] = newY;
	}
	
	public void setHealth (int newHealth){
		health = newHealth;
	}
	
	public void setCurrentWeapon( Weapon newWeapon){
		CurrentWeapon = newWeapon;
		
	}
	
}
