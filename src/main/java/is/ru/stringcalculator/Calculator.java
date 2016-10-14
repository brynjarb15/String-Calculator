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
		return numbers.split("[\n,]");
	}
	
	private static int sum(String[] numbers){
		boolean isNegative = false;
		int totalSum = 0;
		String errorMessage ="Negatives not allowd: ";
		for(String number : numbers){
			if(number.contains("-")){
				if(!isNegative){
					errorMessage += number;
				}
				else{
					errorMessage += "," + number;
				}
				isNegative = true; 
			}
			if(toInt(number) > 1000){
				number = "0";
			}
			totalSum += toInt(number);
		}
		if(isNegative){
			throw new IllegalArgumentException(errorMessage);
		}
		return totalSum;
	}
}