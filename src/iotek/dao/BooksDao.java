package iotek.dao;

import java.util.ArrayList;

import iotek.entity.Books;

public interface BooksDao {
	public ArrayList<Books> findByName(String name);

	public ArrayList<Books> findByType(String type);

	public ArrayList<Books> findByAuthor(String author);
	public Books findById(int id);
	public Books findByAuthorNameType(Books books);

	public void save(Books books);

	public ArrayList<Books> findAll();
}
