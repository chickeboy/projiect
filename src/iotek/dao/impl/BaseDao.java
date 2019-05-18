package iotek.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class BaseDao {
	private File file;
	private FileInputStream fis;
	private FileOutputStream fos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public BaseDao() {
		// TODO Auto-generated constructor stub
	}

	public BaseDao(File file) {
		super();
		this.file = file;
	}

	// 读取文本
	public <T> ArrayList<T> read() {
		ArrayList<T> al = null;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			al = (ArrayList<T>) ois.readObject();
		} catch (IOException e) {

			al = new ArrayList<T>();// 第一次读取发生eof异常
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return al;
	}

	public <T> void write(ArrayList<T> al) {
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(al);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void close() {
		if (oos != null) {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ois != null) {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
