package iotek.entity;

import java.io.Serializable;

public class Books implements Serializable {
	private int id;
	private String name;
	private String author;
	private String type;
	private int disCount;
	private int hasLended;
	private int count;

	public Books(int id) {
		super();
		this.id = id;
	}

	public Books(int id, String name, String author, String type, int disCount, int hasLended, int count) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.type = type;
		this.disCount = disCount;
		this.hasLended = hasLended;
		this.count = count;
	}

	public Books(String name, String author, String type, int count) {
		super();
		this.name = name;
		this.author = author;
		this.type = type;
		this.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Books other = (Books) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Books() {
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDisCount() {
		return disCount;
	}

	public void setDisCount(int disCount) {
		this.disCount = disCount;
	}

	public int getHasLended() {
		return hasLended;
	}

	public void setHasLended(int hasLended) {
		this.hasLended = hasLended;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "id:" + id + " name:" + name + " type:" + type + " author:" + author + " count:" + count + " hasLend:"
				+ hasLended + " disCount:" + disCount;
	}

	public String toStringFoBookInfo() {
		return " name:" + name + " type:" + type + " author:" + author + " count:" + count + " hasLend:" + hasLended
				+ " disCount:" + disCount;
	}

}
