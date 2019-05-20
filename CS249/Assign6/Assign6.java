//Author: Gerald Wolff
import java.util.Scanner;

public class Assign6 extends Player{

	public static void main (String[] args){
		
		Scanner scan = new Scanner (System.in);
		
		Player player = new Player (3,3);
		boolean stop_check = true;
		
		while ( stop_check != false){

			System.out.println ("Enter item name and weight: ");
			String item_name = scan.next();
			if (item_name.equals("None")){
				stop_check = false;
				break;
			}
			double item_weight = scan.nextDouble();
			
			
			System.out.println("Is this a food item? [Y/N}");
			String isFood =scan.next();
			
			if (isFood.equals("Y" ) || isFood.equals("y")){
				System.out.println("Enter healing power: ");
				double item_healing =  scan.nextDouble();
				Food new_item = new Food ( item_name, item_weight, item_healing);
				new_item.setName (item_name);
				new_item.setWeight(item_weight);
				player.addItem(new_item);
			}
			
			else if (isFood.equals("N" ) || isFood.equals("n")){
				Item new_item = new Item (item_name, item_weight);
				player.addItem (new_item);
			}
				
		}
		
		player.printInvetory();
		
		System.out.println("Which Item do you wish to use?");
		int item_number = scan.nextInt();
		player.useItem(item_number);
		if ( player.useItem(item_number) == true){
			System.out.println("Current health: " + player.getHealth());
		}
		else
			System.out.println("Cannot use this item.");
			
	}	
}

