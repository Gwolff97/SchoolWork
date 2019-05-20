//Author: Gerald Wolff
import java.util.Scanner;

public class Map implements Loadable {
	private int mapRows;
	private int mapCols;
	char[][]mapData;
	
	public Map (){
		mapRows = 0;
		mapCols = 0;
		mapData = new char [0][0];
	}
	
	public Map(int newMapRows, int newMapCols)
	{
		mapData = new char[mapRows][mapCols];
		for(int i = 0; i < mapRows; i++)
		{
			for(int j = 0; j < mapCols; j++)
			{
				mapData[i][j] = '.';
			}
		}
	}
	
	
	public int getRows (){
		return mapRows;
	}
	
	public int getColumns (){
		return mapCols;
	}
	
	
	public void draw()
	{
		
		for(int i = 0; i < mapRows; i++)
		{
			System.out.println(""); //Spacer
			for(int j = 0; j < mapCols; j++)
			{
				System.out.print(mapData[i][j]);
			}
		}
	}
	public boolean setMapLocation(int x, int y, char c)
	{
		if(x<= mapRows && y <= mapCols && x >= 0 && y >= 0)
		{
			mapData[y][x] = c;
			return true;
		}
		else
		return false;
	}
	
	
	public void load(Scanner input)
	{
		mapRows = 0;
		mapCols = 0;
		mapData = new char [0][0];
		
		mapRows = Integer.parseInt(input.nextLine());
		
		mapCols = Integer.parseInt(input.nextLine());
		
		mapData = new char[mapRows][mapCols];
		
		
		
		for (int col = 0; col < mapCols; col++){
			for (int row = 0; row < mapRows; row++) {
				String car = input.nextLine();
				char carr =  car.charAt(col);
				mapData [row][col] = carr;
				
			}
		}
			
	}

}
	
