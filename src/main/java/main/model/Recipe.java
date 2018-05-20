package main.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "recipe")
public class Recipe {
	private Ingredients ingredients;

	private Directions directions;

	private Head head;

	public Ingredients getIngredients() {
		return ingredients;
	}

	public void setIngredients(Ingredients ingredients) {
		this.ingredients = ingredients;
	}

	public Directions getDirections() {
		return directions;
	}

	public void setDirections(Directions directions) {
		this.directions = directions;
	}

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	@Override
	public String toString() {
		return "ClassPojo [ingredients = " + ingredients + ", directions = " + directions + ", head = " + head + "]";
	}
}