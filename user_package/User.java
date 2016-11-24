package user_package;
/**This is the Users information
 * @author JSSP Engineers
 * @version 1.0
 */
public class User {
	
	//private fields
	private String name;	
	private int age; 
	private int weight;
	private int height; 
	private int actId; 
	private String email;
	
	
	/**Constructor for user
	 * 
	 * @param n name
	 * @param a age
	 * @param w weight
	 * @param h height
	 * @param id active id
	 * @param e email
	 */
	public User(String n, int a, int w, int h, int id, String e){
		this.name = n;
		this.age = a;
		this.weight = w;
		this.height = h;
		this.actId = id;
		this.email = e;
	}
    /**Getter for name
     * 
     * @return name
     */
	public String getName() {
		return this.name;
	}
    /**Getter for age
     * 
     * @return age
     */
	public int getAge() {
		return this.age;
	}
    /**Getter for weight
     * 
     * @return weight
     */
	public int getWeight() {
		return this.weight;
	}
    /**Getter for height
     * 
     * @return height
     */
	public int getHeight() {
		return this.height;
	}
	/**Getter for activation ID
     * 
     * @return ID
     */
	public int getActId() {
		return this.actId;
	}
	/**Getter for email
     * 
     * @return email 
     */
	public String getEmail() {
		return email;
	}


	/**Quick print (mainly for debugging)
	 * 
	 */
	public void printUser(){
		System.out.println("Name: "+this.name+
				"Age: "+this.age+
				"Weight: "+this.weight+
				"Height: "+this.height+
				"Active ID: "+this.actId+
				"Email: "+this.email);
	}
	
}//end User class
