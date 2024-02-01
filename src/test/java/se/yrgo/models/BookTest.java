package se.yrgo.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

	//G
	@Test
	public void test2EqualBooks() {
		Book book1 = new Book(1, "Cosmos", "Carl Sagan", "3045603456704", "gg", 456);
		Book book2 = new Book(1, "Cosmos", "Carl Sagan", "3045603456705", "gg", 456);
		assertEquals(true, book1.equals(book2));
	}


	//G
	@Test
	public void test2NonEqualBooks() {
		Book book2 = new Book(2, "Cosmos", "Carl Sagan", "3045603456705", "gg", 456);
		Book book3 = new Book(3, "Cosmos", "Carl Sagan", "3045603456705", "gg", 456);
		assertNotEquals(true, book2.equals(book3));
	}
}
