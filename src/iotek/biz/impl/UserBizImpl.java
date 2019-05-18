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

}
