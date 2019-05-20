
public class Food extends Item {
	private double heals = 0;
	
	public Food (){}
	
	public Food ( String Name, double Weight, double Heals){		
		heals = Heals;
	}
	
	public double getHeals(){
		return heals;
	}
	
	public String toString(){
		
		return super.toString() + System.lineSeparator() + "Healing Power:" + heals;
	
	}
	
	







}
