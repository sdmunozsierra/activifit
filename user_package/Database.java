package user_package;

import java.util.HashSet;
import java.util.Set;
/** Class that handles a database for users. This class follows the Singleton 
 * design pattern.
 * @author Sergio Sierra
 * @version 1.0
 */
public class Database {
	
	// Database Variable
	private static Set<User> database;
	//private static List<User> database;
	private User currUser;
	
	static private Database singleton = new Database();
	
	/** Constructor. Creates a HashSet of type User called database.
	 */
	private Database() {
		Database.database = new HashSet<User>();
		//Database.database = new ArrayList<User>();
	}
	
	/** Get the unique instance of a Database.
	 * @return singleton database */
	public static Database getInstance(){
		return singleton;
	}

	/** Get the current user.
	 * 
	 * @return Current user.
	 */
	public User getCurrentUser() {
		return currUser;
	}
	
	/** Verify if the user is already on the database.
	 * @param newUser User to be verified
	 * @return False if the user is not on the database */
	public boolean verifyEmail(User newUser){
		//This can be changed to private, but kept as protected for JUnit Testing
		for(User usr: Database.database){
			if(newUser.getEmail().equals(usr.getEmail())){
				return true; //user already on the system
			}
		}
		return false; 
	}
	
	/**
	 * Add a User to Database. The database checks only for repeating
	 * items, so there can be users that have the same name but
	 * different email.
	 * 
	 * @param newUser
	 *            User to be added to the database.
	 * @return True if addition was successful.
	 */
	public boolean addUserToDatabase(User newUser) {
		if(!verifyEmail(newUser)){
			Database.database.add(newUser);
			//Automatically select the added user as the current user
			this.currUser = newUser;
			return true; //insertion succeed
		}
		return false;
	}
	
	/** Search for a user in the database. This method is an example 
	 * encapsulation.
	 * @param findUser User looking for.
	 * @return True if found.
	 * */
	public boolean containsUser(User findUser){
		if (singleton.contains(findUser)){
			//System.out.println("FIND HASH: " + findUser.hashCode());
			return true; //user found
		}
		return false;
	}
	
	/** Search for the user in the database using the built-in
	 * HashSet. User must have the same name and email for
	 * the search to be valid. Private.
	 * @param findUser User looking for.
	 * @return True if the user was found.
	 * */
	private boolean contains(User findUser){
		for(User usr: database){
			if(findUser.getEmail() == usr.getEmail()
					&& findUser.getName() == usr.getName()){
				return true; //user already on the system
			}
		}
		return false; 
	}
	
	/** Selects a user in the database. Automatically checks if the
	 * User is valid.
	 * @param selectUser User to be used at the database.
	 * @return True if operation succeeded*/
	public boolean selectUser(User selectUser){
		if(containsUser(selectUser)){
			this.currUser = selectUser;
			return true;
		}
		return false;
	}
	
	public boolean selectUserFromEmail(String email){
		for(User usr: database){
			if(usr.getEmail().equals(email) ){
				this.currUser = usr; //login with email
				return true; 
			}
		}
		return false;
	}
	
	/** Removes a user in the database. This action only checks for the
	 * email.
	 *  @param delUser User to be removed from the database.
	 *  @return True if the operation was successful.
	 * */
	public boolean removeUser(User delUser){
		for(User usr: database){
			if(delUser.getEmail() == usr.getEmail()){
				database.remove(usr);
				return true; //user already on the system
			}
		}
		return false; 
	}
	
	/**
	 * Print a list will all the users in the database. [Debugging]
	 */
	public void printAll() {
		System.out.println("Users in this database:");
		int i = 0;
		for (User s : database) {
			System.out.println("User #" + i + " " + s.getName() + " at Email: " + s.getEmail());
			i++;
		}
	}
	
	/** Print all the users in the database with details in a nice
	 * format.*/
	public void printAllDetails(){
		//Prints the whole database with a nice format
		System.out.println(""); //Force empty line
		formatLine(25);
		System.out.println("DATABASE");
		formatLine(25);
		int number = 1;
		for (User s : database){
			System.out.printf("USER #%d\n",number);
			formatLine(25);
			System.out.printf("Name: %s\nEmail: %s\n\nPersonal Information:\n",s.getName(),s.getEmail());
			System.out.printf("Age: %d \nWeight %d lbs \nHeight: %d cm \nActive Id: %d \n",s.getAge(),s.getWeight(),s.getHeight(),s.getActId());
			formatLine(25);
			number++;
		}//end for
		System.out.println("END DATABASE");
		formatLine(25);
	}//end method

	/** Format for a dashed line.
	 * @param numberOfDashes Length of the dashed line.*/
	public void formatLine(int numberOfDashes){
		for (int i = 0; i < numberOfDashes ; i++) {
			System.out.print("-");
		}
		System.out.print("\n");
	}
}// end class
