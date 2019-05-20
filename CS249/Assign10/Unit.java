//Author: Gerald Wolff
import java.util.Random;

public abstract class Unit {
	
	private int attack;
	private int health;
	private boolean alive;
	private String name;
	
	public Unit (){}
		
	public Unit ( String name, int atack, int health){
		alive = true;
	}
	
	public int getAttack(){
		return attack;
	}
	
	public void setAttack (int newAttack){
		attack = newAttack;
	}
	
	public int getHealth(){
		return health;
	}
	
	public void setHealth (int newHealth){
		health = newHealth;
	}
	
	public boolean getAlive(){
		return alive;
	}
	
	public void setAlive (boolean newAlive){
		alive = newAlive;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String newName){
		name = newName;
	}
	
	public String toString(){
		return name+":"+health;
	}
	
	public int attack (Unit other)
	{
		if ( alive==true && other.getAlive()==true){
			Random random = new Random ();
			int damageDone = random.nextInt(attack - 1) + 1;
			other.setHealth(other.getHealth()-damageDone);
			if (other.getHealth() <= 0){
				other.setHealth(0);
				other.setAlive(false);
			}
							
			return damageDone;
		}
		else
			return 0;
	}
	
	
	
	
	
	
}
