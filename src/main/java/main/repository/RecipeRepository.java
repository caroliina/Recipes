package main.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import main.model.Recipe;

@Component("recipeRepository")
public class RecipeRepository {
	static List<Recipe> recipes = new ArrayList<>();

	public RecipeRepository(List<Recipe> recipes) {
		RecipeRepository.recipes = recipes;
	}

	public List<Recipe> getRecipes() {
		return RecipeRepository.recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		RecipeRepository.recipes = recipes;
	}

	public void addRecipe(Recipe recipe) {
		RecipeRepository.recipes.add(recipe);
	}

	public List<Recipe> findRecipesByCategory(String category) {
		List<Recipe> filteredRecipes = new ArrayList<>();
		recipes.forEach(recipe -> {
			List<String> recipeCategories = Arrays.asList(getRecipeCategories(recipe));
			recipeCategories.forEach(rc -> {
				if (rc.equalsIgnoreCase(category)) {
					filteredRecipes.add(recipe);
				}
			});
		});
		return filteredRecipes;
	}

	public List<Recipe> findRecipesByName(String name) {
		List<Recipe> filteredRecipes = new ArrayList<>();
		recipes.forEach(recipe -> {
			List<String> recipeTitles = Arrays.asList(getRecipeTitles(recipe));
			recipeTitles.forEach(recipeTitle -> {
				if (recipeTitle.toLowerCase().contains(name.toLowerCase())) {
					filteredRecipes.add(recipe);
				}
			});
		});
		return filteredRecipes;
	}

	public List<String> getAllCategories() {
		List<String> categories = new ArrayList<>();
		recipes.forEach(recipe -> {
			List<String> recipeCategories = Arrays.asList(getRecipeCategories(recipe));
			recipeCategories.forEach(category -> categories.add(category));
		});
		return categories;
	}

	private String[] getRecipeCategories(Recipe recipe) {
		return recipe.getHead().getCategories().getCat();
	}

	private String getRecipeTitles(Recipe recipe) {
		return recipe.getHead().getTitle().toLowerCase();
	}
}
