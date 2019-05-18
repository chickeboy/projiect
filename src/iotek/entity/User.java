package iotek.entity;

import java.io.Serializable;

// µÃÂ¿‡
public class User implements Serializable {
	private int id;
	private String name;
	private String passWord;

	public User(int id, String name, String passWord) {
		super();
		this.id = id;
		this.name = name;
		this.passWord = passWord;
	}

	public User(String name, String passWord) {
		super();
		this.name = name;
		this.passWord = passWord;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", passWord=" + passWord + "]";
	}

}
