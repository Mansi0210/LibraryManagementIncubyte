import com.libmgmt.model.Book;
import com.libmgmt.service.Library;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    Library library = new Library();

    //Add Book Success
    @Test
    public void testAddBook(){
        Book book = new Book("1234","Harry Potter","Mansi",2003);
        assertEquals(true, library.addBook(book));
    }
    //Add Book Failure
    @Test
    public void testAddBookFailure(){
        Book book1 = new Book("5678","Reach-Dad-Poor-Dad","Dhruv",2005);
        Book book2 = new Book("5678","Reach-Dad-Poor-Dad","Dhruv",2005);
        assertEquals(true,library.addBook(book1));
        assertEquals(false,library.addBook(book2));
    }

    //Borrow Book Success
    @Test
    public void testBorrowBook(){
        Book book = new Book("7890","RichMan","Rishva",2007);
        assertEquals(true,library.addBook(book));
        try {
            assertEquals(true, library.borrowBook("7890"));
        } catch (Exception e) {
            // throw new RuntimeException(e);
            e.printStackTrace();
        }
    }

    //Borrow Book Failure
    @Test
    public void testBorrowBookFailure(){
        Book book = new Book("1234","RichMan","Rishva",2007);
        assertEquals(true,library.addBook(book));
        try{
            assertEquals(true,library.borrowBook("1234"));
            assertEquals(false, library.borrowBook("1234"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Return Book Success
    @Test
    public void testReturnBook(){
        Book book = new Book("1234","Harry Potter","Mansi Thakkar",2003);
        assertEquals(true,library.addBook(book));
        try{
            assertEquals(true,library.borrowBook("1234"));
            assertEquals(true, library.returnBook("1234"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
