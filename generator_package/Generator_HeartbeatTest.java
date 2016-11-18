package generator_package;

import static org.junit.Assert.*;

import org.junit.Test;

import user_package.User;

public class Generator_HeartbeatTest {
	final User usr = new User("Henry", 24, 70, 164, 5, "henry@hotmail.com");
	final Generator_Heartbeat genH = new Generator_Heartbeat(usr);
	final int[] array1 = new int[3];
	
	@Test
	public void test() {
		array1[0] = 10;
		array1[1] = 10;
		array1[2] = 10;
		
		//getMaxHR
		assertSame(123, genH.getMaxHR(100));
		assertNotSame(100, genH.getMaxHR(100));
		assertSame(20, genH.getMaxHR(203));
		assertNotSame(203, genH.getMaxHR(73));
		
		
		//getRestHeartStatus
		assertSame("BRADYCARDIA", genH.getRestHeartStatus(40));
		assertNotSame("BRADYCARDIA", genH.getRestHeartStatus(70));
		assertSame("TACHYCARDIA", genH.getRestHeartStatus(120));
		assertNotSame("TACHYCARDIA", genH.getRestHeartStatus(70));
		
		//findAverage(int[] a)
		assertEquals(10, genH.findAverage(array1));
		assertNotSame(8, genH.findAverage(array1));
	}

}
