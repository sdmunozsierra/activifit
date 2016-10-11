package user_package;

import java.util.HashSet;
import java.util.Set;

public class UserDatabase {
	
	Set<User> database = new HashSet<User>();
	User newUser;
	
	
	//Empty User Database
	public UserDatabase(){
	}
	
	//Add a user
	public void addToDatabase(User newUser){
		this.database.add(newUser);
	}
	
	//Print all users in database
	public void printAll(){
		for (User s : database) {
		    s.printUserName();
		}
	}
	
}//end class
