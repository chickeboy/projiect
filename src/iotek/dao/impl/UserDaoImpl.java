package iotek.dao.impl;

import java.io.File;
import java.util.ArrayList;

import iotek.dao.UserDao;
import iotek.entity.User;

//数据访问层的实现类
public class UserDaoImpl extends BaseDao implements UserDao {
	private ArrayList<User> al;

	public UserDaoImpl(File file) {
		super(file);
	}

	public UserDaoImpl() {
		this(new File("user.txt"));
	}

	// 根据名字去文件中查找对应的一条完整信息
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

	// 保存一条用户信息
	@Override
	public void save(User user) {// user进来的时候id都是默认值0
		al = read();
		// 第一条数据
		if (al.size() == 0) {
			user.setId(1);
		} else {
			// 如果里面已经有人了，那么请获取最后一个人的id然后+1然后存入
			User u = al.get(al.size() - 1);
			user.setId(u.getId() + 1);
		}
		al.add(user);
		write(al);// 覆盖
	}

}
