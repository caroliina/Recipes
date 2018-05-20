package main.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import main.model.Recipe;
import main.repository.RecipeRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { RecipeRepository.class, Recipe.class })
public class RecipesRepositoryTests {

	@Autowired
	private RecipeRepository recipeRepository;

	private final String RECIPE = "30_Minute_Chili";
	private final String RECIPE_CATEGORY = "Chili";
	private final String RECIPE_NAME_SEARCH_STRING = "Minute";
	private final String RECIPE_CATEGORIES = "[Main dish, Chili]";

	@Before
	public void initRecipe() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Recipe.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		List<Recipe> recipes = new ArrayList<>();
		recipes.add((Recipe) jaxbUnmarshaller.unmarshal(new File("data/" + RECIPE + ".xml")));

		new RecipeRepository(recipes);
	}

	@Test
	public void getRecipesReturnsOneRecipe() throws Exception {
		List<Recipe> recipes = recipeRepository.getRecipes();
		assertEquals(1, recipes.size());
	}

	@Test
	public void findRecipesByCategoryFindsOneRecipe() throws Exception {
		List<Recipe> recipes = recipeRepository.findRecipesByCategory(RECIPE_CATEGORY);
		assertEquals(1, recipes.size());
	}

	@Test
	public void findRecipesByCategoryFindsZeroRecipes() throws Exception {
		List<Recipe> recipes = recipeRepository.findRecipesByCategory(null);
		assertEquals(0, recipes.size());
	}

	@Test
	public void findRecipesByNameFindsOneRecipe() throws Exception {
		List<Recipe> recipes = recipeRepository.findRecipesByName(RECIPE_NAME_SEARCH_STRING);
		assertEquals(1, recipes.size());
	}

	@Test
	public void getAllCategoriesReturnsTwoCategories() throws Exception {
		List<String> categories = recipeRepository.getAllCategories();
		assertEquals(RECIPE_CATEGORIES, categories.toString());
	}

}
