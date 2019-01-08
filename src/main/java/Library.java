import java.util.ArrayList;

public class Library {

	private ArrayList<Book> stock;

	public Library() {
		stock = new ArrayList<>();
	}


	public int getStockLevels() {
		return stock.size();
	}

	public void addNewBook(Book book) {
		stock.add(book);
	}
}
