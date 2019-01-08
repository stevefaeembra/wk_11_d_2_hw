import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TestLibrary {

	private Library library;
	private Book pride;

	@Before
	public void setUp() {
		library = new Library();
		pride = new Book("Pride and Prejudice", "Jane Austen", "Romance");
	}

	@Test
	public void hasBookCollection() {
		assertEquals(0,library.getStockLevels());
	}

	@Test
	public void canAddBook() {
		library.addNewBook(pride);
		assertEquals(1, library.getStockLevels());
	}
}
