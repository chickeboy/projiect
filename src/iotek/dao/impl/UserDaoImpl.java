package iotek.dao.impl;

import java.io.File;
import java.util.ArrayList;

import iotek.dao.UserDao;
import iotek.entity.User;

//���ݷ��ʲ��ʵ����
public class UserDaoImpl extends BaseDao implements UserDao {
	private ArrayList<User> al;

	public UserDaoImpl(File file) {
		super(file);
	}

	public UserDaoImpl() {
		this(new File("user.txt"));
	}

	// ��������ȥ�ļ��в��Ҷ�Ӧ��һ��������Ϣ
	@Override
	public User findByName(String name) {
		al = read();
		User user = null;
		for (int i = 0; i < al.size(); i++) {
			if (name.equals(al.get(i).getName())) {
				user = al.get(i);
				break;
			}
		}
		return user;
	}

	// ����һ���û���Ϣ
	@Override
	public void save(User user) {// user������ʱ��id����Ĭ��ֵ0
		al = read();
		// ��һ������
		if (al.size() == 0) {
			user.setId(1);
		} else {
			// ��������Ѿ������ˣ���ô���ȡ���һ���˵�idȻ��+1Ȼ�����
			User u = al.get(al.size() - 1);
			user.setId(u.getId() + 1);
		}
		al.add(user);
		write(al);// ����
	}

}
