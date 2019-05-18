package iotek.util;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 工具类
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
					System.out.println("输入不在范围内");
					continue;
				}
				return n;
			} catch (Exception e) {
				System.out.println("输入有误");
			}
		}
	}

	public static boolean isGoOn(String n) {
		System.out.println("请问是否继续");
		String choice = scanner.next();
		if (choice.equals(n)) {
			return false;
		}
		return true;
	}

	public static <T> void showArryList(ArrayList<T> al, String str) {
		if (al.size() == 0) {
			System.out.println("没有数据");
		} else {
			System.out.println("===============" + str + "===============");
			for (T t : al) {
				System.out.println(t);
				System.out.println("===================================");
			}
		}
	}
}
