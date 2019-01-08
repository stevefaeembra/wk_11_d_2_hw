import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestBook {

	private Book book;

	@Before
	public void setUp() {
		book = new Book("Pride and Prejudice", "Jane Austen", "Romance");
	}

	@Test
	public void checkBookName() {
		assertEquals("Pride and Prejudice", book.getName());
	}

	@Test
	public void checkAuthor() {
		assertEquals("Jane Austen", book.getAuthor());
	}


	@Test
	public void checkGenre() {
		assertEquals("Romance", book.getGenre());
	}

}
