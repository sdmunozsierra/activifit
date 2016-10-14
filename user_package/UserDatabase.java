package user_package;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UserDatabase {
	
	//Variables
	private Set<User> database;
	
	
	//Empty User Database
	public UserDatabase(){
		this.database = new HashSet<User>();
	}
	
	//Add a user
	public void addUserToDatabase(User newUser){
			this.database.add(newUser);
	}
	
	//Print all users in database
	public void printAll(){
		System.out.println("Users in this database:" );
		int i = 0;
		for (User s : database) {
			System.out.println("User #"+i+" "+s.getName()+" at "+s.getEmail());
			i++;
		}
	}
	
	/* Print All with Details */
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
	
	public User getCurrentUser(){
		//Missing check if database ! empty
		Iterator<User> iter = database.iterator();
		return iter.next();
	}
	
	/* Format for a dashed line */
	public void formatLine(int numberOfDashes){
		for (int i = 0; i < numberOfDashes ; i++) {
			System.out.print("-");
		}
		System.out.print("\n");
	}
	
	//TO-DO
		//Avoid duplicate users 
	
}//end class
