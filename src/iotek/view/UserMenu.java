package iotek.view;

import java.util.Scanner;
import iotek.biz.UserBiz;
import iotek.biz.impl.UserBizImpl;
import iotek.entity.User;

//视图层
public class UserMenu {
	private Scanner scanner = new Scanner(System.in);
	private String choice;
	private UserBiz ub = new UserBizImpl();

	// 主菜单
	public void mainMenu() {
		while (true) {
			System.out.println("1.注册");
			System.out.println("2.登录");
			System.out.println("3.退出");
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
	 * 注册菜单 返回值：无 参数：无 负责用注册功能主界面
	 */
	public void registMenu() {
		while (true) {
			System.out.println("账号");
			String name = scanner.next();
			System.out.println("密码");
			String passWord = scanner.next();
			// id不需要用户输入，自动增长
			User user = new User(name, passWord);
			if (ub.regist(user)) {
				System.out.println("注册成功");
			} else {
				System.out.println("注册失败");
			}
			// 写到这一步Menu写不下去了
		}
	}

	public void loginMenu() {
		while (true) {
			System.out.println("账号");
			String name = scanner.next();
			System.out.println("密码");
			String passWord = scanner.next();
			User user = new User(name, passWord);
			int res = ub.login(user);
			if (res == 1) {
				System.out.println("该账号不存在");
			} else if (res == 2) {
				System.out.println("密码错误");
			} else {
				System.out.println("登录成功");
			}
		}
	}
}
