package iotek.biz;

import java.util.ArrayList;

import iotek.entity.Books;

//书本业务逻辑接口
public interface BooksBiz {
	public boolean addBooks(Books books);
	public ArrayList<Books> findAll();
}
