import java.util.Scanner;

public class Assign3_1 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		String userInput = "default";
		
		while (!userInput.isEmpty())
		{
			System.out.println ("Enter a message: ");
			userInput = input.nextLine();
			
			String[] Output = new String [userInput.length()];
			
			for (int i = 0; i < userInput.length(); i++){
				
				Character output = userInput.charAt(i);
				
				if (output.isDigit(output)){
					Output [i] = "_";
				}
				else{
					Output [i] = userInput.substring(i, i + 1);
				}
				
			}
			for (int i = 0; i < Output.length; i++){
				System.out.print(Output[i]);
				}
			System.out.println("");

		}
			
		input.close();	
	}

}
