package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import main.model.Recipe;
import main.repository.RecipeRepository;

@SpringBootApplication
public class RecipesApplication {

	public static void main(String[] args) throws JAXBException {
		SpringApplication.run(RecipesApplication.class, args);

		/*
		 * Put the recipes from xml files to recipeRepository
		 */
		JAXBContext jaxbContext = JAXBContext.newInstance(Recipe.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		List<Recipe> recipes = new ArrayList<>();
		recipes.add((Recipe) jaxbUnmarshaller.unmarshal(new File("recipes/30_Minute_Chili.xml")));
		recipes.add((Recipe) jaxbUnmarshaller.unmarshal(new File("recipes/Amaretto_Cake.xml")));
		recipes.add((Recipe) jaxbUnmarshaller.unmarshal(new File("recipes/Another_Zucchini_Dish.xml")));

		new RecipeRepository(recipes);
	}
}
