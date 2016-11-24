package user_package;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* SOON TO BE DELETED !! ! ! !!

/** Class that handles a database for users. This class follows the Singleton 
 * design pattern.
 * @author JSSP Engineers
 * @version 1.0
 */
public class UserDatabase {
	
	//Variables
	private static Set<User> database; //Static Database
	private User currUser;
	
	/**Constructor.
	 * Creates a HashSet of type User called database.
	 * */
	public UserDatabase(){
		this.database = new HashSet<User>();
	}
	/** Add a User to Database
	 * @param newUser User to be added to the database.
	 * */
	public void addUserToDatabase(User newUser){
			this.database.add(newUser);
	}
	/** Print a list will all the users in the database.
	 *  */
	public void printAll(){
		System.out.println("Users in this database:" );
		int i = 0;
		for (User s : database) {
			System.out.println("User #"+i+" "+s.getName()+" at "+s.getEmail());
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
	/** Get the current user by using an iterator.
	 * @return Current User
	 * */
	public User getCurrentUser(){
		//Missing check if database ! empty
		Iterator<User> iter = database.iterator();
		return iter.next();
	}
	/** Format for a dashed line.
	 * @param numberOfDashes Length of the dashed line.*/
	public void formatLine(int numberOfDashes){
		for (int i = 0; i < numberOfDashes ; i++) {
			System.out.print("-");
		}
		System.out.print("\n");
	}
	//TODO
		//Avoid duplicate users 
	
}//end class