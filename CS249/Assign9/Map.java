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
		
		 for(int i=0;i<mapRows;i++)
	        {
	            String inputs = input.nextLine();
	            if (inputs != null)
	            {
	                for (int j = 0; j < inputs.length(); j++)
	                {
	                    mapData[i][j] = inputs.charAt(j);
	                }
	            }

	        }
			
	}
	
	public char getMapLocation (int x, int y){
		if (x >= mapRows || x < 0 || y >= mapCols || y < 0 ) {
			return ' ';
		}
		else
			return mapData[y][x];
	}
	
	public boolean canMoveTo (int x, int y){
		if (x >= mapRows || x < 0 || y >= mapCols || y < 0 ) {
			return false;
		}
		
		else if ( mapData[y][x] == '.') {
			return true;
		}
		
		else
			return false;
	}
	

}
	
