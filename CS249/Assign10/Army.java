//Author: Gerald Wolff
import java.util.ArrayList;

public class Army <E extends Unit> {
	
	private ArrayList <E> soldiers  = new ArrayList ();
	private String name;
	
	public void Army(String name){
		
	}
	
	public String getName(){
		return name;
	}
	
	public void addSoldier (E x){}
	
	public void removeSoldier (E x) {}
	
	public E getSoldier (int index){
		return soldiers.get(index);
	}
	
	public int getSoldierCnt(){
		return soldiers.size();
	}
	
	public boolean isDefeated(){
		if (soldiers.isEmpty() == true){
			return true;
		}
		else
			return false;
	}
	
	public String toString(){
		String soldierList = name;
		
		for (int i = 0; i < soldiers.size(); i++){
			soldierList = soldierList + ": " + soldiers.get(i);
		}
		
		return soldierList;
	}
	
	public <T extends Unit> void attacks (Army<T> other){
		ArrayList <E> deathToll = new ArrayList();
	
		for (int i = 0; i < soldiers.size(); i++){
			if( other.isDefeated()){
				break;
			}
			
			Unit enemySoldier = other.getSoldier((int)Math.random() * other.getSoldierCnt()); 
			
			attack(enemySoldier);
			
			if (enemySoldier.getAlive() == false){
				other.removeSoldier(other.getSoldier(i));
			}
			else
				other.getSoldier(i).attack(other);
			
			if ( other.getAlive() == false ){
				deathToll.add(soldiers.get(i));
			}
						
		}
		
		soldiers.removeAll(deathToll);
		
		
		
		
		
	
	
	}

	
	
	
}
