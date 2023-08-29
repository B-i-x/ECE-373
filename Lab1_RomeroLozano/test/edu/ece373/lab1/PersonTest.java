package edu.ece373.lab1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	final void testPerson() {
		Person p1 = new Person();
		assertEquals("unknown", p1.getName());
		assertEquals(2, p1.getMaxBooks());
	}

	@Test
	final void testPersonStringInt() {
		Person p2 = new Person("Joey", 500);
		assertEquals("Joey", p2.getName());
		assertEquals(500, p2.getMaxBooks());
	}

	@Test
	final void testPersonString() {
		Person p3 = new Person("Griselda Hoyer");
		assertEquals("Griselda Hoyer", p3.getName());
		assertEquals(0, p3.getMaxBooks());
	}

	@Test
	final void testSetName() {
		Person p1 = new Person();
		assertEquals("unknown", p1.getName());
		
		p1.setName("Roy");
		assertEquals("Roy", p1.getName());

	}

	@Test
	final void testSetMaxBooks() {
		Person p1 = new Person();
		assertEquals(2, p1.getMaxBooks());
		
		p1.setMaxBooks(16777216);
		assertEquals(16777216, p1.getMaxBooks());
	}

}