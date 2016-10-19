package user_package;

public class User {
	
	//private fields
	private String name;	
	private int age; 
	private int weight;
	private int height; 
	private int actId; 
	private String email;
	
	//Constructor
	/* Variables are already sanitized at this point, so 
	 * the User will be added expecting no errors. */
	public User(String n, int a, int w, int h, int id, String e){
		this.name = n;
		this.age = a;
		this.weight = w;
		this.height = h;
		this.actId = id;
		this.email = e;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public int getWeight() {
		return this.weight;
	}

	public int getHeight() {
		return this.height;
	}

	public int getActId() {
		return this.actId;
	}

	public String getEmail() {
		return email;
	}
	
	//Quick print (mainly for debugging)
	public void printUser(){
		System.out.println("Name: "+this.name+
				"Age: "+this.age+
				"Weight: "+this.weight+
				"Height: "+this.height+
				"Active ID: "+this.actId+
				"Email: "+this.email);
	}
	
}//end User class
