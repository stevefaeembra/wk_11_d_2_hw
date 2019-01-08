import java.util.ArrayList;


public class Borrower {

	private String name;
	private ArrayList<Book> loanedBooks;

	public Borrower(String name) {
		this.name = name;
		loanedBooks = new ArrayList<Book>();
	}


	public String getName() {
		return name;
	}

	public ArrayList<Book> getLoanedBooks() {
		return loanedBooks;
	}

}
