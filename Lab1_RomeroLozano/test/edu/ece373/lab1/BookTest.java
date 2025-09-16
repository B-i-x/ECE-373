package edu.ece373.lab1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTest {

    @Test
    final void testDefaultConstructor() {
        Book book = new Book();
        assertEquals("empty", book.getTitle());
        assertEquals("empty", book.getAuthor());

        Person person = new Person();
        book.setPerson(person);
        assertEquals(person, book.getPerson()); 
    }

    @Test
    final void testGetTitle() {
        Book book = new Book();
        book.setTitle("Alex's Random Title");
        assertEquals("Alex's Random Title", book.getTitle());
    }

    @Test
    final void testSetTile() {
        Book book = new Book();
        book.setTitle("Another Alex's Random Title");
        assertEquals("Another Alex's Random Title", book.getTitle());
    }

    @Test
    final void testGetAuthor() {
        Book book = new Book();
        book.setAuthor("Alex's Random Author");
        assertEquals("Alex's Random Author", book.getAuthor());
    }

    @Test
    final void testSetAuthor() {
        Book book = new Book();
        book.setAuthor("Another Alex's Random Author");
        assertEquals("Another Alex's Random Author", book.getAuthor());
    }

    @Test
    final void testGetPerson() {
        Book book = new Book();
        Person person = new Person(); 
        person.setName("Alex Romero");  
        book.setPerson(person);
        assertEquals(person, book.getPerson()); 
    }

    @Test
    final void testSetPerson() {
        Book book = new Book();
        Person person = new Person();
        person.setName("Alex Lozano"); 
        book.setPerson(person);
        assertEquals(person, book.getPerson()); 
    }
}

