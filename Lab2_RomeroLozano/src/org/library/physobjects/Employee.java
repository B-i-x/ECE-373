package org.library.physobjects;

public abstract class Employee extends Person {
    
    // Private field for Employee ID
    private int id;
    
    // Constructor
    public Employee() {
        super();  // Calls the constructor of the parent class, Person
        this.id = 0;  // Initializes id to 0 as instructed
    }
    
    // Getter for id
    public int getiD() {
        return id;
    }
    
    // Setter for id
    public void setiD(int id) {
        this.id = id;
    }
    
    // Overriding borrowBook method from Person
    @Override
    public void borrowBook(Book b1) {
        boolean flag = false;
        
        if(b1.getPerson() == null) {
            flag = checkBookLimit();
            
            if (flag) {
                getBookList().add(b1);  // Modified as per instructions
                b1.setPerson(this);
            } else {  
                System.out.println(b1.getTitle() + " cannot be lent to " + this.getName() + ". Max limit of books is " + getMaxBooks());
            }
        } else {
            System.out.println(b1.getTitle() + " cannot be lent to " + this.getName() + ". Already lent to " + b1.getPerson().getName());
        }
    }
    
    // Overriding returnBook method from Person
    @Override
    public void returnBook(Book b1) {
        boolean flag = false;
        
        for (Book aBook : this.getBookList()) {
            if(aBook.getTitle().equals(b1.getTitle()) && aBook.getAuthor().equals(b1.getAuthor())){  // Used equals for string comparison
                flag = true;
            }
        }
        
        if(flag){
            b1.setPerson(null);
            getBookList().remove(b1);  // Modified as per instructions
        }
    }

    abstract void increaseMaxLimit(int limit);
    
}
