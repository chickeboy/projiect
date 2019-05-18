package iotek.biz;

import iotek.entity.User;

//接口
public interface UserBiz {
	public boolean regist(User user);// 这个user view层给
	// 这个返回值也是给view使用的
	public int login(User user);
}
