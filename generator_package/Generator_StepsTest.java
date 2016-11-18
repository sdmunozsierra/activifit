package generator_package;

import static org.junit.Assert.*;

import org.junit.Test;

import user_package.User;
import chart_package.StepChart;
/**This is the Junit test cases
 * As many that are applicable
 * @author JSSP Engineers
 * @version 1.0
 */
public class Generator_StepsTest {
	final User usr = new User("Jeff", 39, 190, 171, 9, "Jeffy@gmail.com");
	final Generator_Steps genS = new Generator_Steps(usr);
	final int[] array1 = new int[3];
	
	@Test
	public void test() {
		array1[0] = 10;
		array1[1] = 10;
		array1[2] = 10;
		
		
		//height 171
		assertEquals(70, genS.strideLength());
		assertNotSame(12, genS.strideLength());
		
		//getMaxDistance()
		assertEquals(42, genS.getMaxDistance());
		assertNotSame(-1, genS.getMaxDistance());
		
		//getMinDistance()
		assertEquals(20, genS.getMinDistance());
		assertNotSame(76, genS.getMinDistance());

		
		//findAverage(int[] a)
		assertEquals(10, genS.findAverage(array1));
		assertNotSame(8, genS.findAverage(array1));
	}

}
