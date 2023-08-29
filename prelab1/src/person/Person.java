package person;


public class Person {

	//Fields for a Person
	private String name;
	private int maxBooks;
	
	//Constructors
	public Person() {
		name = "unknown";
		maxBooks = 2;
	}
	
	public Person(String aName, int maxBooks) {
		name = aName;
		this.maxBooks = maxBooks; 
	}
	
	public Person(String aName){
		this(aName, 0);
	}
	
	//getters and setters
	public String getName(){
		return name;
	}
	
	public void setName(String aName){
		name = aName;
	}
	
	public int getMaxBooks() {
		return maxBooks;
	}
	public void setMaxBooks(int maxBooks){
		this.maxBooks = maxBooks;
	}
        
         public void display()
    	{
    		System.out.println("Hi! You have successfully completed the PreLab!");
    	}		


	
}
