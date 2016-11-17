import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UserDatabase {

	// Database Variable
	private Set<User> database;
	protected Iterator<User> iter;
	private User currUser;
	/**
	 * Constructor. Creates a HashSet of type User called database.
	 */
	public UserDatabase() {
		this.database = new HashSet<User>();
		this.iter = this.database.iterator();
	}

	/**
	 * Add a User to Database
	 * 
	 * @param newUser
	 *            User to be added to the database.
	 */
	public void addUserToDatabase(User newUser) {
		if(verifyUser(newUser))
			this.database.add(newUser);
		else{
			System.out.println("USER ALREADY ON DATABASE");
		}
	}

	public User currUser(){
		if (database.isEmpty()) {
			User emptyUser = new User("EMPTY", "EMPTY", 0);
			return emptyUser;
		}
		else{
			return iter.next();
		}
	}
	
	public User nextUser(){
		if(iter.hasNext()){
			return iter.next();
		}
		else{
			User emptyUser = new User("EMPTY", "EMPTY", 0);
			return emptyUser;
		}
	}
	
	
	/**
	 * Get the current user by using an iterator.
	 * 
	 * @return User or Null if empty
	 */
	public User getCurrentUser() {
		if (database.isEmpty()) {
			User emptyUser = new User("EMPTY", "EMPTY", 0);
			return emptyUser;
		}
		else{
			Iterator<User> iter = database.iterator();
			return iter.next();
		}
		
	}
	
	public boolean verifyUser(User newUser){
		for(User usr: database){
			if(newUser.uniqueID == usr.uniqueID){
				return false; //user already on the system
			}
		}
		return true; 
	}
	
	public boolean verifyName(User newUser){
		for(User usr: database){
			if(newUser.getUserName() == usr.getUserName() ){
				return false; //user already on the system
			}
		}
		return true; 
	}
	
	/**
	 * Return an empty user
	 * @param db Database to check if empty
	 * */
	public User checkEmpty(UserDatabase db){
		// Check if database is not empty
		if (database.isEmpty()) {
			User emptyUser = new User("EMPTY", "EMPTY", 0);
			return emptyUser;
		}
		else {
			return getCurrentUser();
		}
	}
	/**
	 * Print a list will all the users in the database.
	 */
	public void printAll() {
		System.out.println("Users in this database:");
		int i = 0;
		for (User s : database) {
			System.out.println("User #" + i + " " + s.getName() + " at UserName: " + s.getUserName());
			i++;
		}
	}

}// end class
