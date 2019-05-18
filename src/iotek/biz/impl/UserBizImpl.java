package iotek.biz.impl;

import iotek.biz.UserBiz;
import iotek.dao.UserDao;
import iotek.dao.impl.UserDaoImpl;
import iotek.entity.User;

//Biz接口的实现类
public class UserBizImpl implements UserBiz {
	private UserDao ud = new UserDaoImpl();

	// biz调用dao层
	@Override
	public boolean regist(User user) {
		// 考虑清楚你的注册需要哪几个功能
		// 先查，后增
		if (ud.findByName(user.getName()) == null) {
			ud.save(user);
			return true;
		}
		return false;
	}

	@Override
	public int login(User user) {
		// u代表的是这个账号名在文件中的完整信息
		User u = ud.findByName(user.getName());
		if (u == null) {
			return 1;// 账号输入错误
		}
		if (!u.getPassWord().equals(user.getPassWord())) {
			return 2;// 密码输入错误
		}
		return 3;
	}

}
