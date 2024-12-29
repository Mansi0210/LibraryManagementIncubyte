import com.libmgmt.model.Book;
import org.junit.Test;


import static org.junit.Assert.assertEquals;


public class BookTest {

    @Test
    public void testBookCreation() {
        Book book = new Book("1234", "Harry Potter", "Mansi Thakkar", 2024);
        assertEquals("1234", book.getIsbn());
        assertEquals("Harry Potter", book.getTitle());
        assertEquals("Mansi Thakkar", book.getAuthor());
        assertEquals(2024, book.getPublishYear());
        assertEquals(true,book.isAvailable()); // Initially, the book should be available
    }
}