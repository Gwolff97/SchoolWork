// Author: Gerald Wolff
public class Calculator {
	public static double eval(String expr) throws InvalidExpressionException {
		try{
			int plusSymbol = expr.indexOf("+");
			int minusSymbol = expr.indexOf("-");
			
			double answer = 0;
			if(plusSymbol > -1 )	//if a + is found
			{
				String firstOperand = expr.substring(0,expr.indexOf("+"));
				String secondOperand = expr.substring(expr.indexOf("+")+1, expr.length());
				
				double firstOpDouble = Double.parseDouble(firstOperand);
				
				double secondOpDouble = Double.parseDouble(secondOperand);
				
				answer = firstOpDouble + secondOpDouble;
				return answer;
			}
			if(minusSymbol > -1)	
			{
				String firstOperand = expr.substring(0,expr.indexOf("-"));
				String secondOperand = expr.substring(expr.indexOf("-")+1, expr.length());
				
				double firstOpDouble = Double.parseDouble(firstOperand);
				
				double secondOpDouble = Double.parseDouble(secondOperand);
				
				
				answer = firstOpDouble - secondOpDouble;
				return answer;
			}
			else
			{
				String neitherExist = expr.substring(0,expr.indexOf("+"));
			}
			return answer;
			
			
		}			
		catch(Exception ex){
			throw new InvalidExpressionException("Invalid Expression", ex);
		}
	}
}
		


