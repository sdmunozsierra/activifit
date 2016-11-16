package generator_package;

import user_package.User;
/** Class that creates Generator for the current user.
 * @author JSSP Engineers
 * @version 1.0
 */
public class Generator {
	
	protected User user;
	/** Constructor
	 * @param User. Current logged-in.
	 * */
	public Generator(User user){
		this.user = user;
	}
	/** Returns the current user.
	 * @return User 
	 * */
	public User getUser(){
		return user;
	}
	/** print Generator information [Debugging]
	 * */
	public void printGenerator(){
		System.out.println("Creating a Generator...");
		System.out.println("ACCESSING SUPER GENERATOR OF USER: "+user.getName());
	}
}//end class