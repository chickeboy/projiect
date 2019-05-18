package iotek.view;

import java.util.Scanner;

public class Menu {
	private UserMenu userMenu = new UserMenu();
	private AdminMenu adminMenu = new AdminMenu();

	public void mainMenu() {
		while (true) {
			System.out.println("1.管理员");
			System.out.println("2.用户");
			System.out.println("3.退出");
			Scanner scanner = new Scanner(System.in);
			String choice = scanner.next();
			switch (choice) {
			case "1":
				adminMenu.mainMenu();
				break;
			case "2":
				userMenu.mainMenu();
				break;
			case "3":
				System.exit(0);
				;
			default:
				break;
			}
		}
	}
}
