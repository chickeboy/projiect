package iotek.biz;

import java.util.ArrayList;

import iotek.entity.Books;

//�鱾ҵ���߼��ӿ�
public interface BooksBiz {
	public boolean addBooks(Books books);
	public ArrayList<Books> findAll();
}
