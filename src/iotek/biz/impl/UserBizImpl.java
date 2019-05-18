package iotek.biz.impl;

import iotek.biz.UserBiz;
import iotek.dao.UserDao;
import iotek.dao.impl.UserDaoImpl;
import iotek.entity.User;

//Biz�ӿڵ�ʵ����
public class UserBizImpl implements UserBiz {
	private UserDao ud = new UserDaoImpl();

	// biz����dao��
	@Override
	public boolean regist(User user) {
		// ����������ע����Ҫ�ļ�������
		// �Ȳ飬����
		if (ud.findByName(user.getName()) == null) {
			ud.save(user);
			return true;
		}
		return false;
	}

	@Override
	public int login(User user) {
		// u�����������˺������ļ��е�������Ϣ
		User u = ud.findByName(user.getName());
		if (u == null) {
			return 1;// �˺��������
		}
		if (!u.getPassWord().equals(user.getPassWord())) {
			return 2;// �����������
		}
		return 3;
	}

}
