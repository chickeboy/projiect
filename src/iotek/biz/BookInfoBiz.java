package iotek.biz;

import java.util.ArrayList;

import iotek.entity.AllInfo;
import iotek.entity.BookInfo;

public interface BookInfoBiz {
	public boolean addBookInfo(int id);

	public ArrayList<AllInfo> findAll();
}
