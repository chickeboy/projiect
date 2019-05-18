package iotek.dao;

import java.util.ArrayList;

import iotek.entity.BookInfo;

public interface BookInfoDao {
	public void save(BookInfo bookInfo);
	public ArrayList<BookInfo> findAll();
}
