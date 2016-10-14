package is.ru.stringcalculator;
 

 
public class Calculator {
	
	public static int add(String text){
		char delimiter = ',';
		if(text.startsWith("//")){
			delimiter = text.charAt(2);
			text = text.substring(4);
		}
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",") || (text.contains(String.valueOf(delimiter)))){
			String[] numbers = splitNumbers(text, delimiter);
			return sum(numbers);
		}
		else{
			return toInt(text);
		}
	}
	
	private static int toInt(String number){
		return Integer.parseInt(number);
	}
	
	private static String[] splitNumbers(String numbers, char delimiter){
		String delimiters = "[\n,]";
		if (delimiter != ','){
			delimiters = "[\n," + delimiter + "]";
		}
		return numbers.split(delimiters);
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