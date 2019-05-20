
public class Item {
	
	private String name = " ";
	private double weight = 0.0;
	
	public Item(){}
	
	public Item ( String Name, double Weight){
		name =Name;
		weight = Weight;
	}
	
	public String getName(){
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setName(String Name){
		name = Name;
	}
	public void setWeight(double Weight){
		weight = Weight;
	}
		
	public String toString () {
		String newString = "Name: " + name +System.lineSeparator() + "Weight: " + weight;
		return newString;
	}
	
}
