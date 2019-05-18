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

	// ����Ա��¼����
	public void mainMenu() {
		while (true) {
			System.out.println("�˺�");
			String name = scanner.next();
			System.out.println("����");
			String passWord = scanner.next();
			if (name.equals("admin") && passWord.equals("111")) {
				System.out.println("��¼�ɹ�");
				managerMainMenu();
			} else {
				System.out.println("��¼ʧ��");
			}
		}
	}

	// ����Ա�ܹ��ܲ˵�
	public void managerMainMenu() {
		while (true) {
			System.out.println("1.�鱾����");
			System.out.println("2.��ܹ���");
			System.out.println("3.����");
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

//		�鱾����˵�
	public void booksMainMenu() {
		while (true) {
			System.out.println("1.����鱾");
			System.out.println("2.ɾ���鱾");
			System.out.println("3.�޸��鱾");
			System.out.println("4.�鿴�鱾");
			System.out.println("5.������һ��");
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

	// ����鱾�˵�
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
				System.out.println("��ӳɹ�");
			} else {
				System.out.println("���ʧ��");
			}
			if (Util.isGoOn("N")) {
				break;
			}
		}
	}

	// �鿴�鱾���˵�
	public void searchBooksMainMenu() {
		while (true) {
			System.out.println("1.�鿴�����鱾");
			System.out.println("2.����ĳһ���ֶβ�ѯ�鱾��Ϣ");
			System.out.println("3.������һ��");
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

	// �鿴�����鱾��Ϣ
	public void searchAllBooksMenu() {
		ArrayList<Books> al = bb.findAll();
		Util.showArryList(al, "�����鱾��Ϣ");
		if (Util.isGoOn("n")) {
			return;
		}
	}

	// ������˵�
	public void bookInfoMainMenu() {
		while (true) {
			System.out.println("1.�ϼ��鱾");
			System.out.println("2.�鿴���");
			System.out.println("3.������һ��");
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
			System.out.println("��ѡ��Ҫ�ϼܵ��鱾id");
			int id = Util.input(1, 1000000);
			if (bib.addBookInfo(id)) {
				System.out.println("�ϼܳɹ�");
			} else {
				System.out.println("�ϼ�ʧ��");
			}
			if (!Util.isGoOn("n")) {
				break;
			}
			// ���id��bookinfo�е�bid
		}
	}

	public void searchBookInfoMenu() {
		ArrayList<AllInfo> al = bib.findAll();
		Util.showArryList(al, "ͼ�����Ϣ��");
	}
}
