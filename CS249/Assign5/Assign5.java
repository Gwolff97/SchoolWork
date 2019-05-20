//Author: Gerald Wolff

package Assignment5;
public class Assign5 extends Player{
	
	public static void main(String[] args) {
		Weapon sword = new Weapon("Common Sword", 50);
		
		Weapon coolSword = new Weapon ("Glamdring, the Foe-Hammer", 1500);
		
		Player player = new Player (100,100);
	
		Weapon.printWeapon(player.getCurrentWeapon());
		
		player.setCurrentWeapon(sword);
		
		Weapon.printWeapon(player.getCurrentWeapon());
		
		player.setCurrentWeapon(coolSword);
		
		Weapon.printWeapon(player.getCurrentWeapon());
		
	}

}
