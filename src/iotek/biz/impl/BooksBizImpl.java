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
		// ��򵥵ķ����������ݣ�ҲҪͨ��ҵ���߼���
	}

}
