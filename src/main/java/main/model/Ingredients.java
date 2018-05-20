package main.model;

public class Ingredients {
	private Ing[] ing;

	public Ing[] getIng() {
		return ing;
	}

	public void setIng(Ing[] ing) {
		this.ing = ing;
	}

	@Override
	public String toString() {
		return "ClassPojo [ing = " + ing + "]";
	}
}
