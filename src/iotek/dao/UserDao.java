package iotek.dao;

import iotek.entity.User;

//数据访问接口
public interface UserDao {
	public User findByName(String name);
	public void save(User user);
}
