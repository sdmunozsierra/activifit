package user_package;

//The main purpose of this class is to generate the information of the user that is
//currently logged-in.
public class Generator {
	
	protected User user;
	
	//User Constructor
	public Generator(User user){
		this.user = user;
	}
	
	//Get user
	public User getUser(){
		return user;
	}

	//Some quick info [Mainly Debugging]
	public void printGenerator(){
		System.out.println("ACCESSING SUPER GENERATOR OF USER: "+user.getName());
	}

}//end class
