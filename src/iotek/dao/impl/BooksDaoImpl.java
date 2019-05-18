package iotek.dao.impl;

import java.io.File;
import java.util.ArrayList;

import iotek.dao.BooksDao;
import iotek.entity.Books;
import iotek.entity.User;

public class BooksDaoImpl extends BaseDao implements BooksDao {
	private ArrayList<Books> al;

	public BooksDaoImpl() {
		super(new File("books.txt"));
	}

	// �������ֻ�ȡ�鱾��Ϣ(������)
	@Override
	public ArrayList<Books> findByName(String name) {
		al = read();
		ArrayList<Books> a = new ArrayList<Books>();
		for (int i = 0; i < al.size(); i++) {
			if (name.equals(al.get(i).getName())) {
				a.add(al.get(i));
			}
		}
		return a;
	}

	@Override
	public ArrayList<Books> findByType(String type) {
		al = read();
		ArrayList<Books> a = new ArrayList<Books>();
		for (int i = 0; i < al.size(); i++) {
			if (type.equals(al.get(i).getType())) {
				a.add(al.get(i));
			}
		}
		return a;
	}

	@Override
	public ArrayList<Books> findByAuthor(String author) {
		al = read();
		ArrayList<Books> a = new ArrayList<Books>();
		for (int i = 0; i < al.size(); i++) {
			if (author.equals(al.get(i).getAuthor())) {
				a.add(al.get(i));
			}
		}
		return a;
	}

	// �������������ж��鱾�Ƿ����
	@Override
	public Books findByAuthorNameType(Books books) {
		al = read();
		Books b = null;
		for (int i = 0; i < al.size(); i++) {
			if (books.getName().equals(al.get(i).getName()) && books.getType().equals(al.get(i).getType())
					&& books.getAuthor().equals(al.get(i).getAuthor())) {
				b = al.get(i);
				break;
			}
		}
		return b;
	}

	@Override
	public void save(Books books) {
		al = read();
		// ��һ������
		if (al.size() == 0) {
			books.setId(1);
		} else {
			// ��������Ѿ������ˣ���ô���ȡ���һ���˵�idȻ��+1Ȼ�����
			Books u = al.get(al.size() - 1);
			books.setId(u.getId() + 1);
		}
		al.add(books);
		write(al);// ����

	}

	@Override
	public ArrayList<Books> findAll() {
		// TODO Auto-generated method stub
		return read();
	}

	@Override
	public Books findById(int id) {
		al = read();
		int index = al.indexOf(new Books(id));

		return index == -1 ? null : al.get(index);
	}

}
