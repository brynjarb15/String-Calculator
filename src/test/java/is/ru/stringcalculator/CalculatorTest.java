package is.ru.stringcalculator;
 
import static org.junit.Assert.assertEquals;
import org.junit.Test;
 
public class CalculatorTest {
	
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}
	
	@Test
	public void testOneString() {
		assertEquals(1, Calculator.add("1"));
	}
	
	@Test
	public void testTwoStrings() {
		assertEquals(3, Calculator.add("1,2"));
	}
	
	@Test
	public void testAnotherOneNumber(){
		assertEquals(4, Calculator.add("4"));
	}
	
	@Test
	public void testThreeNumbers(){
		assertEquals(10, Calculator.add("4,5,1"));
	}
	
	@Test
	public void testNewLineSplit(){
		assertEquals(6, Calculator.add("1\n2,3"));
	}
	
	@Test
	public void testOneNegativeNumber(){
		try{
			assertEquals("Negatives not allowd: -1", Calculator.add("-1,2"));
		}
		catch (Exception e) {
			assertEquals("Negatives not allowd: -1", e.getMessage() );
		}
	}
	
	@Test
	public void testManyNegativeNumber(){
		try{
			assertEquals("Negatives not allowd: -1,-5,-8", Calculator.add("-1,-5,-8,5"));
		}
		catch (Exception e) {
			assertEquals("Negatives not allowd: -1,-5,-8", e.getMessage() );
		}
	}
	
	@Test
	public void testBigNumber(){
		assertEquals(3, Calculator.add("1001,3"));
	}
	
	@Test
	public void testDelimiterNumber(){
		assertEquals(3, Calculator.add("//;\n1;2"));
	}
	
	@Test
	public void testAnotherDelimiter(){
		assertEquals(8, Calculator.add("//'\n1'2,5"));
	}
	
}