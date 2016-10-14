package is.ru.stringcalculator;
 

 
public class Calculator {
	
	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")){
			String[] numbers = splitNumbers(text);
			return sum(numbers);
		}
		else{
			return toInt(text);
		}
	}
	
	private static int toInt(String number){
		return Integer.parseInt(number);
	}
	
	private static String[] splitNumbers(String numbers){
	    return numbers.split(",");
	}
	
	private static int sum(String[] numbers){
			int totalSum = 0;
			for(String number : numbers){
				totalSum += toInt(number);
			}
			return totalSum;
	}

}