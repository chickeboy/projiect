package iotek.view;

import java.util.Scanner;
import iotek.biz.UserBiz;
import iotek.biz.impl.UserBizImpl;
import iotek.entity.User;

//��ͼ��
public class UserMenu {
	private Scanner scanner = new Scanner(System.in);
	private String choice;
	private UserBiz ub = new UserBizImpl();

	// ���˵�
	public void mainMenu() {
		while (true) {
			System.out.println("1.ע��");
			System.out.println("2.��¼");
			System.out.println("3.�˳�");
			choice = scanner.next();
			switch (choice) {
			case "1":
				registMenu();
				break;
			case "2":
				loginMenu();
				break;
			case "3":
				return;
			default:
				break;
			}
		}
	}

	/*
	 * ע��˵� ����ֵ���� �������� ������ע�Ṧ��������
	 */
	public void registMenu() {
		while (true) {
			System.out.println("�˺�");
			String name = scanner.next();
			System.out.println("����");
			String passWord = scanner.next();
			// id����Ҫ�û����룬�Զ�����
			User user = new User(name, passWord);
			if (ub.regist(user)) {
				System.out.println("ע��ɹ�");
			} else {
				System.out.println("ע��ʧ��");
			}
			// д����һ��Menuд����ȥ��
		}
	}

	public void loginMenu() {
		while (true) {
			System.out.println("�˺�");
			String name = scanner.next();
			System.out.println("����");
			String passWord = scanner.next();
			User user = new User(name, passWord);
			int res = ub.login(user);
			if (res == 1) {
				System.out.println("���˺Ų�����");
			} else if (res == 2) {
				System.out.println("�������");
			} else {
				System.out.println("��¼�ɹ�");
			}
		}
	}
}
