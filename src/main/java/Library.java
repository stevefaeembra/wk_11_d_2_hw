import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Library {

	private ArrayList<Book> stock;
	private int capacity;
	private HashMap<String,Integer> countsByGenre;

	public Library(int capacity) {
		stock = new ArrayList<>();
		this.capacity = capacity;
		this.countsByGenre = new HashMap<>();
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
			String genre = book.getGenre();
			if (countsByGenre.containsKey(genre)) {
				countsByGenre.put(genre, countsByGenre.get(genre)+1);
			} else {
				countsByGenre.put(genre, 1);
			}
		}
	}

	public int getCapacity() {
		return capacity;
	}

	public void lendBook(Book book, Borrower customer) {
		if (stock.remove(book)) {
			customer.addBook(book);
			String genre = book.getGenre();
			countsByGenre.put(genre, countsByGenre.get(genre)-1);
		}
	}

	public int getQuantityOfGenre(String genreName) {
		if (countsByGenre.containsKey(genreName)) {
			return countsByGenre.get(genreName);
		} else {
			return 0;
		}
	}

}
