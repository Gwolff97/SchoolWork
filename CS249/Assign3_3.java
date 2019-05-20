//Author: Gerald Wolff

import java.util.Scanner;

public class Assign3_3 {
	
	public static void main(String[] args) {
	
		Scanner input = new Scanner (System.in);
	
		int sides;
		double sideLength, area;
	
		System.out.println ("Enter the number of sides: ");
		sides = input.nextInt();
	
		System.out.println("Enter side length: ");
		sideLength = input.nextDouble();
	
		if (sides >= 3){
			area = computeArea (sides, sideLength);	
			System.out.println ("Area: " + area );
		}
	
		else
			System.out.println ("Number of sides must be >= 3!");
	
	input.close();	
	}
	
	public static double computeArea(int n, double s){
		
		double area = (n * Math.pow(s, 2)) / (4 * Math.tan( Math.PI / n));
	
		return area;
	}

}
