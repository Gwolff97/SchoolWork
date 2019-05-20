//Author: Gerald Wolff
import java.util.Scanner;

public class Assign10 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		System.out.println("Enter the number of Human and Orc Troops:");
		
		Army Gondor = new Army ();
		Army Mordor = new Army ();
		for (int i = 1; i <= input.nextInt(); i++){
			Gondor.addSoldier(Human);
		
		}
		
		for (int i = 1; i <= input.nextInt(); i++){
			Mordor.addSoldier(Orc);
		}
		
		int battleCnt = 0;
		
		while (Gondor.isDefeated() != true && Mordor.isDefeated() != true){
			System.out.println ("BATTLE" + battleCnt);
			Gondor.attacks(Mordor);
			Mordor.attacks(Gondor);
			Gondor.toString();
			Mordor.toString();
			battleCnt++;
			
		}
		
		System.out.println(battleCnt + "BATTLES FOUGHT");
		if (Gondor.isDefeated() == false){
			System.out.println(Gondor.getName() + "is victorious!");
		}
		else if (Mordor.isDefeated() == false){
			System.out.println(Mordor.getName() + "is victorious!");
		}
		else
			System.out.println ("Both sides lost!");
	 

	}

}
