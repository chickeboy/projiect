package iotek.entity;

public class AllInfo {
	private Books books;
	private BookInfo bookInfo;

	public AllInfo(Books books, BookInfo bookInfo) {
		super();
		this.books = books;
		this.bookInfo = bookInfo;
	}

	@Override
	public String toString() {
		return books.toStringFoBookInfo() + "\n" + bookInfo.toStringFoBookInfo();
	}

}
