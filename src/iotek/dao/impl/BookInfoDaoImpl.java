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
		// ��һ������
		if (al.size() == 0) {
			bookInfo.setId(1);
		} else {
			// ��������Ѿ������ˣ���ô���ȡ���һ���˵�idȻ��+1Ȼ�����
			BookInfo u = al.get(al.size() - 1);
			bookInfo.setId(u.getId() + 1);
		}
		al.add(bookInfo);
		write(al);// ����
	}

	@Override
	public ArrayList<BookInfo> findAll() {
		// TODO Auto-generated method stub
		return read();
	}

}
