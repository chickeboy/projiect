package iotek.util;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ������
 * 
 * @author lagone
 *
 */
public class Util {
	private static Scanner scanner = new Scanner(System.in);

	public static int input(int min, int max) {
		int n = 0;
		while (true) {
			String num = scanner.next();
			try {
				n = Integer.parseInt(num);
				if (n < min || n > max) {
					System.out.println("���벻�ڷ�Χ��");
					continue;
				}
				return n;
			} catch (Exception e) {
				System.out.println("��������");
			}
		}
	}

	public static boolean isGoOn(String n) {
		System.out.println("�����Ƿ����");
		String choice = scanner.next();
		if (choice.equals(n)) {
			return false;
		}
		return true;
	}

	public static <T> void showArryList(ArrayList<T> al, String str) {
		if (al.size() == 0) {
			System.out.println("û������");
		} else {
			System.out.println("===============" + str + "===============");
			for (T t : al) {
				System.out.println(t);
				System.out.println("===================================");
			}
		}
	}
}
