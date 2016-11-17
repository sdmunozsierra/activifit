public class User {
	
	//Variables
	String userName;
	String name;
	int uniqueID;
	
	/** Main Constructor 
	 * @param un User Name
	 * @param n Name
	 * @param id Unique ID (To check repeating) 
	 * */
	public User(String un, String n, int id){
		this.userName = un;
		this.name = n;
		this.uniqueID = id;
	}
	
	/** Print basic information about the user */
	public void printInfo(){
		System.out.println("User Name: "+this.userName);
		System.out.println("Name: "+this.name);
		System.out.println("Unique ID: "+this.uniqueID);
	}

	public String getUserName() {
		return userName;
	}

	public String getName() {
		return name;
	}

	public int getUniqueID() {
		return uniqueID;
	}
	
}//end class
