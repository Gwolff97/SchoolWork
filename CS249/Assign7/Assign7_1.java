// Author Gerald Wolff
import java.util.*;
public class Assign7_1 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		try{
			System.out.println("Enter a 2-number expression: ");
			String expression = keyboard.nextLine();
			
			System.out.println("INPUT: " + expression);
			System.out.println("Answer is " + Calculator.eval(expression));
		}
		catch(Exception ex){
			System.err.println(ex);
			ex.printStackTrace();
		}
	}

}
