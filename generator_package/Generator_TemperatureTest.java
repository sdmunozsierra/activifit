package generator_package;

import static org.junit.Assert.*;

import org.junit.Test;

import user_package.User;


public class Generator_TemperatureTest {
	final User usr = new User("Henry", 24, 70, 164, 5, "henry@hotmail.com");
	final Generator_Temperature gen = new Generator_Temperature(usr);
	final int[] array1 = new int[3];

	@Test
	public void test() {
		
	}
	
	/**
	 *  Method for testing getTempStatus(double celcius)
	 *  */
	@Test
	public void getTempStatusTest(){
		/*	
		 * 	Temperature States 
		 *	HYPOTHERMIA <=35.0 C
		 *  Normal Cold between 35.1 and 36.49
		 *  NORMAL between 36.5 and 37.5 C
		 *	FEVER = 37.5 between 37.5 C and 38.3 C
		 *	HYPERPYREXIA >  38.3 C
		 * 
		 * */
		//Hypothermia
		assertSame("Hypothermia" , gen.getTempStatus(-1000)) ; //Test negative lower bound
		assertSame("Hypothermia" , gen.getTempStatus(-1)) ; //Test negative
		assertSame("Hypothermia" , gen.getTempStatus(0)) ; //Test zero
		assertSame("Hypothermia" , gen.getTempStatus(1)) ; //Test positive
		assertSame("Hypothermia" , gen.getTempStatus(35)) ; //Test positive upper bound
		assertNotSame("Hypothermia" , gen.getTempStatus(35.0001)) ; //Exceed upper bound
		
		//Normal Cold
		assertNotSame("Normal Cold" , gen.getTempStatus(-1)) ; //Test negative
		assertNotSame("Normal Cold" , gen.getTempStatus(100)) ; //Test positive
		assertSame("Normal Cold" , gen.getTempStatus(35.00001)) ; //Test lower bound
		assertSame("Normal Cold" , gen.getTempStatus(36.49999)) ; //Test upper bound
		assertNotSame("Normal Cold" , gen.getTempStatus(36.5)) ; //Exceed upper bound
				
		//Normal 
		assertNotSame("Normal" , gen.getTempStatus(-1)) ; //Test negative
		assertNotSame("Normal" , gen.getTempStatus(100)) ; //Test positive
		assertSame("Normal" , gen.getTempStatus(36.5)) ; //Test lower bound
		assertSame("Normal" , gen.getTempStatus(37.49)) ; //Test upper bound
		assertNotSame("Normal" , gen.getTempStatus(37.5)) ; //Exceed upper bound
		
		//Fever 
		assertNotSame("Fever" , gen.getTempStatus(-1)) ; //Test negative
		assertNotSame("Fever" , gen.getTempStatus(100)) ; //Test positive
		assertSame("Fever" , gen.getTempStatus(37.5)) ; //Test lower bound
		assertSame("Fever" , gen.getTempStatus(38.29)) ; //Test upper bound
		assertNotSame("Fever" , gen.getTempStatus(38.3)) ; //Exceed upper bound
		
		//Hyperpyrexia 
		assertNotSame("Hyperpyrexia" , gen.getTempStatus(-1)) ; //Test negative
		assertNotSame("Hyperpyrexia" , gen.getTempStatus(30)) ; //Test positive
		assertSame("Hyperpyrexia" , gen.getTempStatus(38.3)) ; //Test lower bound
		assertSame("Hyperpyrexia" , gen.getTempStatus(40)) ; //Test upper bound
		assertSame("Hyperpyrexia" , gen.getTempStatus(1000000)) ; //Cannot Exceed upper bound
		
	}

}
