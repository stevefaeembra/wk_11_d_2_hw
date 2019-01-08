import java.lang.reflect.Array;
import java.util.ArrayList;

public class Library {

	private ArrayList<Book> stock;
	private int capacity;

	public Library(int capacity) {
		stock = new ArrayList<>();
		this.capacity = capacity;
	}

	public int getStockLevels() {
		return stock.size();
	}

	public ArrayList<Book> getStock() {
		return stock;
	}

	public void addNewBook(Book book) {
		if (getStockLevels() < getCapacity()) {
			stock.add(book);
		}
	}

	public int getCapacity() {
		return capacity;
	}

	public void lendBook(Book book, Borrower customer) {
		if (stock.remove(book)) {
			customer.addBook(book);
		}
	}

}
