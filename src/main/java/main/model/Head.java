package main.model;

public class Head {
	private String title;

	private String yield;

	private Categories categories;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYield() {
		return yield;
	}

	public void setYield(String yield) {
		this.yield = yield;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "ClassPojo [title = " + title + ", yield = " + yield + ", categories = " + categories + "]";
	}
}
