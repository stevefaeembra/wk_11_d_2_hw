import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestBorrower {

	private Borrower borrower;

	@Before
	public void setUp() {
		borrower = new Borrower("Steven");
	}

	@Test
	public void testNameSetCorrectly() {
		assertEquals("Steven", borrower.getName());
	}

	@Test
	public void startsWithEmptyLoanSet() {
		assertEquals(0, borrower.getLoanedBooks().size());
	}

}
