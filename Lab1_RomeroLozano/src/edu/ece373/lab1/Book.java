package edu.ece373.lab1;


public class Book {
    private String title;
    private String author;
    private Person Person;

    public Book() {
        this.title = "empty";
        this.author = "empty";
        this.Person = new Person();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Person getPerson() {
        return Person;
    }

    public void setPerson(Person per) {
        Person = per;
    }

}
