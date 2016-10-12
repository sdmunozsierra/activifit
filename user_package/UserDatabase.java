package user_package;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UserDatabase {
	
	Set<User> database = new HashSet<User>();
	//User newUser;
	
	
	//Empty User Database
	public UserDatabase(){
		
	}
	
	//Add a user
	public void addUserToDatabase(User newUser){
			this.database.add(newUser);
	}
	
	//Print all users in database
	public void printAll(){
		for (User s : database) {
		    s.printUserName();
		    System.out.println();
		}
	}
	
	public User getCurrentUser(){
		//Missing check if database ! empty
		Iterator<User> iter = database.iterator();
		return iter.next();
	}
	//TO-DO
	//Avoid duplicate users 
	
	
}//end class
