package iotek.biz.impl;

import java.util.ArrayList;

import iotek.biz.BookInfoBiz;
import iotek.dao.BookInfoDao;
import iotek.dao.BooksDao;
import iotek.dao.impl.BookInfoDaoImpl;
import iotek.dao.impl.BooksDaoImpl;
import iotek.entity.AllInfo;
import iotek.entity.BookInfo;
import iotek.entity.Books;

public class BookInfoBizImpl implements BookInfoBiz {
	private BooksDao bd = new BooksDaoImpl();// 用来遍历书库的
	private BookInfoDao bid = new BookInfoDaoImpl();

	@Override
	public boolean addBookInfo(int id) {
		Books b = bd.findById(id);// 先去books表中找这个id是否存在
		if (b == null) {
			return false;// 书库里根本没有这本书
		}
		if (b.getCount() == 0) {
			return false;
		}
		bid.save(new BookInfo(id));// 这里传的是bid
		return true;
	}

	@Override
	public ArrayList<AllInfo> findAll() {
		ArrayList<BookInfo> al = bid.findAll();// 找到书本id相同的书
		ArrayList<AllInfo> a = new ArrayList<AllInfo>();
		for (int i = 0; i < al.size(); i++) {
			Books books = bd.findById(al.get(i).getBid());
			AllInfo allInfo = new AllInfo(books, al.get(i));
			a.add(allInfo);
		}
		return a;
	}

}
