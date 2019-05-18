package iotek.entity;

import java.io.Serializable;

public class BookInfo implements Serializable {
	private int id;
	private int bid;
	private int inOrOut;
	private int state;
	private int lost;

	public BookInfo(int id, int bid, int inOrOut, int state, int lost) {
		super();
		this.id = id;
		this.bid = bid;
		this.inOrOut = inOrOut;
		this.state = state;
		this.lost = lost;
	}

	public BookInfo(int bid) {
		super();
		this.bid = bid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getInOrOut() {
		return inOrOut;
	}

	public void setInOrOut(int inOrOut) {
		this.inOrOut = inOrOut;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getLost() {
		return lost;
	}

	public void setLost(int lost) {
		this.lost = lost;
	}

	@Override
	public String toString() {
		return "id:" + id + " bid:" + bid + " state:" + state + " inOrOut:" + inOrOut + " lost:" + lost;

	}

	public String toStringFoBookInfo() {
		return "id:" + id + " state:" + state + " inOrOut:" + inOrOut + " lost:" + lost;

	}

}
