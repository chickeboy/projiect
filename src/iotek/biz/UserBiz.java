package iotek.biz;

import iotek.entity.User;

//�ӿ�
public interface UserBiz {
	public boolean regist(User user);// ���user view���
	// �������ֵҲ�Ǹ�viewʹ�õ�
	public int login(User user);
}
