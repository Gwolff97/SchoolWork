//Author: Gerald Wolff
import java.util.Scanner;


public class Assign4_1 {
	public static final int MAPROW = 10;
	public static final int MAPCOLUMN = 20;
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		char [][] map = new char [MAPROW][MAPCOLUMN];
		char [][] buffer = new char [MAPROW][MAPCOLUMN];
		
		for (int i = 0; i < MAPROW; i++){
			for (int j = 0; j < MAPCOLUMN; j++){
				map [i][j] = '.';
			}
		}
	
		int [] cords = new int [2];
		cords [0] = 0;
		cords [1] = 0;
		
		char move = 'a';
		do {	
				for (int i = 0; i < MAPROW; i++){
					for (int j = 0; j < MAPCOLUMN; j++){
						buffer [i][j] = map [i][j];
					}
				}	
				buffer [cords[1]][cords[0]] = '@';
				
				for (int i = 0; i <MAPROW; i++){
						for (int j = 0; j < MAPCOLUMN; j++){
							System.out.print(buffer[i][j]);	
						}
						System.out.println();
					}
				
				buffer [cords[1]][cords[0]] = '@';
			
				System.out.println("Enter action: ");
					String movement = input.nextLine();
				
				move = movement.charAt(0);
				
				switch (move){
					case 'w':
						if (cords [1] != 0){
							cords[1]--;
						}
						break;
					case 'a':
						if (cords [0] != 0){
							cords [0]--;
						}
						break;
					case 's':
						if (cords[1] != 9){
							cords [1]++;
						}
						break;
					case 'd':
						if (cords[0] != 19){
							cords [0]++;
						}
						break;
				}
						
			} while ( move != 'q');
	
		input.close();
	}
	

}



