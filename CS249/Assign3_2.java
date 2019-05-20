//Author: Gerald Wolff

import java.util.Scanner;

public class Assign3_2 {

	public static void main(String[] args) {
		double a,b,c,d,e,f,x,y;
		
		Scanner input = new Scanner (System.in);
		System.out.println("Enter the values for a,b,c,d,e and f accordingly: ");
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		d = input.nextDouble();
		e = input.nextDouble();
		f = input.nextDouble();
		
		x = computeCramerX (a,b,c,d,e,f);
		y = computeCramerY (a,b,c,d,e,f);
		
		System.out.println(x);
		System.out.println(y);
		
		input.close();		

	}
	
	public static double computeCramerX(double a, double b, double c,
			double d, double e, double f){
		double x = ((e*d)-(b*f))/((a*d-(b*c)));
		
		return x;
	
	}
	
	public static double computeCramerY(double a, double b, double c,
			double d, double e, double f){
		double y = ((a*f)-(e*c))/((a*d-(b*c)));
		
		return y;
	}



}
