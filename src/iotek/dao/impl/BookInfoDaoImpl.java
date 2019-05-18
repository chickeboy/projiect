package iotek.dao.impl;

import java.io.File;
import java.util.ArrayList;

import iotek.dao.BookInfoDao;
import iotek.entity.BookInfo;
import iotek.entity.Books;

public class BookInfoDaoImpl extends BaseDao implements BookInfoDao {
	private ArrayList<BookInfo> al;

	public BookInfoDaoImpl() {
		super(new File("bookinfo.txt"));
	}

	@Override
	public void save(BookInfo bookInfo) {

		al = read();
		// 第一条数据
		if (al.size() == 0) {
			bookInfo.setId(1);
		} else {
			// 如果里面已经有人了，那么请获取最后一个人的id然后+1然后存入
			BookInfo u = al.get(al.size() - 1);
			bookInfo.setId(u.getId() + 1);
		}
		al.add(bookInfo);
		write(al);// 覆盖
	}

	@Override
	public ArrayList<BookInfo> findAll() {
		// TODO Auto-generated method stub
		return read();
	}

}
