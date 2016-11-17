	public static void main(String[] args) {
		
		//Create a database
		UserDatabase database = new UserDatabase();
		UserDatabase emptybase = new UserDatabase();
		//Create a couple of users
		User sarai = new User("sarafashion", "Sarai", 80489540);
		User sergio = new User("sdmunoz", "Sergio", 80500789);
		//Add users to database
		database.addUserToDatabase(sarai);
		database.addUserToDatabase(sergio);
		//Test 
		database.printAll();
		//Test iterator
		System.out.println(database.verifyUser(new User("a","b",00) ) );
		System.out.println(database.verifyUser(new User("a","b",80500789) ));
		System.out.println(database.verifyUser(new User("a","b",80489540) ));
		
		//Repeating Cases
		database.addUserToDatabase(new User("a","b",80500789)); //try to add repeated
		database.addUserToDatabase(new User("a","b",00) );  //try to add un-repeated
		
		database.printAll();
		
		//Verify names
		System.out.println(database.verifyName(new User("a","b",00) ) );
		System.out.println(database.verifyName(new User("sdmuno","b",80500789) ));
		System.out.println(database.verifyName(new User("henry","b",80489540) ));
		System.out.println(database.verifyName(new User("accepted?","b",80489540) ));
	}

}
