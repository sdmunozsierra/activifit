package user_package;

import static org.junit.Assert.*;

import org.junit.Test;
/** Class that tests the database class follows the Singleton.
 * @author Sergio Sierra
 * @version 1.0
 */
public class DatabaseTest {

	@Test
	/** Verifies how the database checks for users already in the system
	 * and how it handles additions
	 *	@Test
	*/
	public void verifyUserTest(){
		Database local = Database.getInstance();
		Database local2 = Database.getInstance();
		
		User user1 = new User("user1", 20, 20, 20, 7, "user1@email.com");
		User user2 = new User("user2", 20, 20, 20, 7, "user2@email.com");
		User repeated = new User("user3", 20, 20, 20, 7, "user1@email.com");
		User sameEmail = new User("email", 15, 15, 15, 5, "user2@email.com");
		
		
		assertFalse(local.verifyEmail(user1)); //The email is not on the database
		assertTrue(local.addUserToDatabase(user1)); //add user 1 to the database
		//local.printAll();
		
		//Check that the database cannot accept duplicates
		assertTrue(local.verifyEmail(user1)); //Email already taken!
		assertTrue(local.verifyEmail(repeated)); //Repeated Email already in database
		assertFalse(local.addUserToDatabase(user1)); //Cannot add a duplicate user
		assertFalse(local.addUserToDatabase(repeated)); //Cannot add duplicate email
		
		//Add one more user to the database
		assertTrue(local.addUserToDatabase(user2)); //add user 2 to the database
		//local.printAll();
		
		//Finally Verify one more user and try to add it
		assertTrue(local.verifyEmail(sameEmail)); //already in database
		assertFalse(local.addUserToDatabase(sameEmail)); //Email already in database
		
		//Test with "another" database
		assertFalse(local2.addUserToDatabase(repeated)); //Singleton in action
		//local2.printAll();
		
		
	}
	
	@Test
	public void containsUserTest() {
		//Because Database is a singleton some elements are already on the database
		Database local = Database.getInstance();
		
		//Add the following users
		User user1 = new User("user1", 20, 20, 20, 7, "user1@email.com");
		User user2 = new User("user2", 20, 20, 20, 7, "user2@email.com");
		User user3 = new User("user3", 20, 20, 20, 7, "user3@email.com");
		User user4 = new User("user4", 20, 20, 20, 7, "user4@email.com");
		User user5 = new User("user5", 20, 20, 20, 7, "user5@email.com");
		User user6 = new User("user6", 20, 20, 20, 7, "user6@email.com");
		User repeated = new User("user3", 20, 20, 20, 7, "user1@email.com");
		
		assertFalse(local.addUserToDatabase(user1)); //User 1 is already on base due to last test
		assertFalse(local.addUserToDatabase(user2)); //User 2 is already on base due to last test
		assertTrue(local.addUserToDatabase(user3)); //add user 3 to the database
		assertTrue(local.addUserToDatabase(user4)); //add user 4 to the database
		assertTrue(local.addUserToDatabase(user5)); //add user 5 to the database
		//local.printAll(); //Successfully added users -> 3,4,5
		
		//Find users inside the database
		assertTrue(local.containsUser(user1)); //user1 is on database
		assertTrue(local.containsUser(user5)); //user2 is on database
		
		//Search a user outside the database
		assertFalse(local.containsUser(new User("user7", 20, 20, 20, 7, "user7@email.com")));
		assertFalse(local.containsUser(user6));
		//Search a user that has a registered email but different name
		assertFalse(local.containsUser(repeated)); //This user is not on the database
		
	}
	
	@Test
	public void manipulatingUsersInDatabaseTest(){
		//Call in Database
		Database database = Database.getInstance();
		
		//Users
		User user1 = new User("user1", 20, 20, 20, 7, "user1@email.com");
		User user2 = new User("user2", 20, 20, 20, 7, "user2@email.com");
		User user3 = new User("user3", 20, 20, 20, 7, "user3@email.com");
		User user4 = new User("user4", 20, 20, 20, 7, "user4@email.com");
		User user6 = new User("user6", 20, 20, 20, 7, "user6@email.com");
		
		//Check which users are in the database
		//database.printAll(); //users -> 1,2,3,4,5 
		
		//Remove users from database
		assertTrue(database.containsUser(user1)); //user 1 is in database
		assertTrue(database.removeUser(user1)); //User 1 was deleted from database
		assertFalse(database.containsUser(user1)); //User 1 not found!
		assertFalse(database.removeUser(user6)); //cannot remove an inexistent user
		assertTrue(database.removeUser(user3)); //User 3 was deleted from database
		assertTrue(database.removeUser(user4)); //User 4 was deleted from database
		
		//database.printAll(); //users -> 2,5
		
		//Test select user
		assertFalse(database.selectUser(user1)); //user not in database
		assertTrue(database.selectUser(user2)); //user 2 selected in database
		assertEquals(user2, database.getCurrentUser()); //User 2 indeed selected
	}
	
	
}
