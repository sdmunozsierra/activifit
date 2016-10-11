package user_package;

/* In this early stage it will be developed as a set
 * */
public class User {
	
	private String name;	
	private int age; 
	private int weight;
	private int height; 
	private int actId; 
	private String email; 
	
	//Constructor
	/* Variables are already sanitized at this point, so 
	 * the program will added them expecting no errors. */
	public User(String n, int a, int w, int h, int id, String e){
		this.name = n;
		this.age = a;
		this.weight = w;
		this.height = h;
		this.actId = id;
		this.email = e;
	}

	//Prints the name of the user
	/* Not to be confused with username */
	public void printUserName(){
		System.out.printf("User Name: %s", this.name);
	}

}
