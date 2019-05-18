package iotek.biz.impl;

import java.util.ArrayList;

import iotek.biz.BooksBiz;
import iotek.dao.BooksDao;
import iotek.dao.impl.BooksDaoImpl;
import iotek.entity.Books;

public class BooksBizImpl implements BooksBiz {
	private BooksDao bd = new BooksDaoImpl();

	@Override
	public boolean addBooks(Books books) {
		if (bd.findByAuthorNameType(books) == null) {
			bd.save(books);
			return true;
		}
		return false;
	}

	public ArrayList<Books> findAll() {
		System.out.println(bd.findAll());
		return bd.findAll();
		// 最简单的返回所有数据，也要通过业务逻辑层
	}

}
