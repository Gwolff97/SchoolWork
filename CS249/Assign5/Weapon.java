//Author: Gerald Wolff

package Assignment5;
public class Weapon {

	private String Name = "";
	private int Damage = 0;
		
		public Weapon(){}
		
		public Weapon (String newName, int newDamage){
			Name = newName;
			Damage = newDamage;
		}
		
		public String getName(){
			return Name;
		}
		
		public int getDamage(){
			return Damage;
		}
		
		public  void setName( String name){
			Name = name;
		}
		
		public void setDamage( int damage){
			Damage = damage;
		}
		
		public static void printWeapon( Weapon weapon){
			if (weapon == null){
				System.out.println("No weapon");
			}
			
			else		
				System.out.println(weapon.getName());	
		}
		

}
