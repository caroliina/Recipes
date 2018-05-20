package main.model;

public class Ing {
	private Amt amt;

	private String item;

	public Amt getAmt() {
		return amt;
	}

	public void setAmt(Amt amt) {
		this.amt = amt;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "ClassPojo [amt = " + amt + ", item = " + item + "]";
	}
}
