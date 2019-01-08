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

	public void addNewBook(Book book) {
		if (getStockLevels() < getCapacity()) {
			stock.add(book);
		}
	}

	public int getCapacity() {
		return capacity;
	}
}
