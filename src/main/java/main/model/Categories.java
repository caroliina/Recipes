package main.model;

public class Categories {
	private String[] cat;

	public String[] getCat() {
		return cat;
	}

	public void setCat(String[] cat) {
		this.cat = cat;
	}

	@Override
	public String toString() {
		return "ClassPojo [cat = " + cat + "]";
	}
}
