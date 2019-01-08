public class Book {

	private String name;
	private String author;
	private String genre;

	public Book(String name, String author, String genre) {
		this.name = name;
		this.author = author;
		this.genre = genre;
	}


	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public String getGenre() {
		return genre;
	}

}
