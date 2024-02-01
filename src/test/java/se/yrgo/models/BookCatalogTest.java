package se.yrgo.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookCatalogTest {

    private BookCatalog bc;
    private Book book1;

    public BookCatalogTest() {
        bc = new BookCatalog();
        Book book1 = new Book(1, "Learning Java", "", "", "", 0);
        bc.addBook(book1);
    }

    //G
    @Test
    public void testAddABook() {
        Book book2 = new Book(3, "Old man and the sea", "Hemmingway", "233436364563", "gg", 237);
        bc.addBook(book2);
        assertNotEquals(book2, bc.getBookArray()[0]);
        assertEquals(book2, bc.getBookArray()[1]);
    }

    //G
    @Test
    public void testFindBook() throws BookNotFoundException {
        Book book2 = new Book(3, "Old man and the sea", "Hemmingway", "233436364563", "gg", 237);
        bc.addBook(book2);
        assertEquals(book2, bc.findBook("Old man and the sea"));
        assertNotEquals(book1, bc.findBook("Old man and the sea"));
    }

    //G
    @Test
    public void testFindBookIgnoringCase() throws BookNotFoundException {
        Book book2 = new Book(3, "Old man and the sea", "Hemmingway", "233436364563", "gg", 237);
        bc.addBook(book2);
        assertEquals(book2, bc.findBook("Old MAN and tHe sea"));
        assertNotEquals(book1, bc.findBook("OLD man and the SEA"));
    }

    //G
    @Test
    public void testFindBookWithExtraSpaces() throws BookNotFoundException {
        Book book2 = new Book(3, "Old man and the sea", "Hemmingway", "233436364563", "gg", 237);
        bc.addBook(book2);
        assertEquals(book2, bc.findBook("Old      man   and the sea".replaceAll("\\s+", " ")));
        assertThrows(BookNotFoundException.class, () ->  bc.findBook("Old      man   and the sea"));
    }

    //VG
    // This test should throw BookNotFoundException in order to pass.
    @Test
    public void testFindBookThatDoesntExist() throws BookNotFoundException {
        Book book2 = new Book(3, "Old man and the sea", "Hemmingway", "233436364563", "gg", 237);
        bc.addBook(book2);
        assertThrows(BookNotFoundException.class, () ->  bc.findBook("Cosmos"));
        assertDoesNotThrow(() -> bc.findBook("Old man and the sea"));
    }

}
