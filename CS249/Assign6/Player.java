//Author: Gerald Wolff
import java.util.*;

public class Player {
	
	private int [] position  = new int [2];
	private int health = 100;
	private Weapon CurrentWeapon;
	private ArrayList <Item> inventory = new ArrayList<Item>(); 
	
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
	
	public void addItem (Item item) {
		inventory.add(item);
	}
	
	
	public boolean useItem (int index){
		if (index <= inventory.size() && inventory.get(index) instanceof Food){
			Food healing_power = (Food) inventory.get(index);
			health = health + (int)healing_power.getHeals();
			inventory.remove(index);
			return true;
		}
	
		else
			return false;
	}
	
	public void printInvetory(){
		System.out.println("Inventory:");
		for (int i = 0; i < inventory.size(); i++){
			System.out.println("Item " + i);
			System.out.println(inventory.get(i).toString() + System.lineSeparator());
			
			
		}
		
		
	}
	
	
	
}
