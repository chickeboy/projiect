package iotek.dao;

import iotek.entity.User;

//���ݷ��ʽӿ�
public interface UserDao {
	public User findByName(String name);
	public void save(User user);
}
