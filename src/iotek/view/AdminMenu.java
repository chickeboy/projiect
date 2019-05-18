package iotek.view;

import java.util.ArrayList;
import java.util.Scanner;

import iotek.biz.BookInfoBiz;
import iotek.biz.BooksBiz;
import iotek.biz.impl.BookInfoBizImpl;
import iotek.biz.impl.BooksBizImpl;
import iotek.entity.AllInfo;
import iotek.entity.BookInfo;
import iotek.entity.Books;
import iotek.util.Util;

public class AdminMenu {
	private Scanner scanner = new Scanner(System.in);
	private String choice;
	private BooksBiz bb = new BooksBizImpl();
	private BookInfoBiz bib = new BookInfoBizImpl();

	// 管理员登录界面
	public void mainMenu() {
		while (true) {
			System.out.println("账号");
			String name = scanner.next();
			System.out.println("密码");
			String passWord = scanner.next();
			if (name.equals("admin") && passWord.equals("111")) {
				System.out.println("登录成功");
				managerMainMenu();
			} else {
				System.out.println("登录失败");
			}
		}
	}

	// 管理员总功能菜单
	public void managerMainMenu() {
		while (true) {
			System.out.println("1.书本管理");
			System.out.println("2.书架管理");
			System.out.println("3.返回");
			choice = scanner.next();
			switch (choice) {
			case "1":
				booksMainMenu();
				break;
			case "2":
				bookInfoMainMenu();
				break;
			case "3":
				return;
			default:
				break;
			}
		}
	}

//		书本管理菜单
	public void booksMainMenu() {
		while (true) {
			System.out.println("1.添加书本");
			System.out.println("2.删除书本");
			System.out.println("3.修改书本");
			System.out.println("4.查看书本");
			System.out.println("5.返回上一级");
			choice = scanner.next();
			switch (choice) {
			case "1":
				addBooksMenu();
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				searchBooksMainMenu();
				break;
			case "5":
				return;
			default:
				break;
			}
		}
	}

	// 添加书本菜单
	public void addBooksMenu() {
		while (true) {
			System.out.println("name");
			String name = scanner.next();
			System.out.println("author");
			String author = scanner.next();
			System.out.println("count");
			int count = Util.input(1, 50);
			System.out.println("type");
			String type = scanner.next();
			Books books = new Books(name, author, type, count);
			if (bb.addBooks(books)) {
				System.out.println("添加成功");
			} else {
				System.out.println("添加失败");
			}
			if (Util.isGoOn("N")) {
				break;
			}
		}
	}

	// 查看书本主菜单
	public void searchBooksMainMenu() {
		while (true) {
			System.out.println("1.查看所有书本");
			System.out.println("2.根据某一个字段查询书本信息");
			System.out.println("3.返回上一级");
			choice = scanner.next();
			switch (choice) {
			case "1":
				searchAllBooksMenu();
				break;
			case "2":
				break;
			case "3":
				return;
			default:
				break;
			}
		}
	}

	// 查看所有书本信息
	public void searchAllBooksMenu() {
		ArrayList<Books> al = bb.findAll();
		Util.showArryList(al, "所有书本信息");
		if (Util.isGoOn("n")) {
			return;
		}
	}

	// 书架主菜单
	public void bookInfoMainMenu() {
		while (true) {
			System.out.println("1.上架书本");
			System.out.println("2.查看书架");
			System.out.println("3.返回上一级");
			choice = scanner.next();
			switch (choice) {
			case "1":
				addBookInfoMenu();
				break;
			case "2":
				searchBookInfoMenu();
				break;
			case "3":
				break;

			default:
				break;
			}
		}
	}

	public void addBookInfoMenu() {
		while (true) {
			searchAllBooksMenu();
			System.out.println("请选择要上架的书本id");
			int id = Util.input(1, 1000000);
			if (bib.addBookInfo(id)) {
				System.out.println("上架成功");
			} else {
				System.out.println("上架失败");
			}
			if (!Util.isGoOn("n")) {
				break;
			}
			// 这个id是bookinfo中的bid
		}
	}

	public void searchBookInfoMenu() {
		ArrayList<AllInfo> al = bib.findAll();
		Util.showArryList(al, "图书馆信息表");
	}
}
