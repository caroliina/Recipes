package main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import main.model.Recipe;
import main.repository.RecipeRepository;

@RestController
public class RecipeController {

	@Autowired
	private RecipeRepository recipeRepository;

	/*
	 * Get all recipes if no parameters specified. Find recipes by exact category if
	 * category parameter is specified. Find recipes by category and name if search
	 * parameter is specified.
	 */
	@RequestMapping(value = "/recipes", method = RequestMethod.GET)
	public ResponseEntity<String> getRecipes(@RequestParam(value = "category", required = false) String category,
			@RequestParam(value = "search", required = false) String search) throws JsonProcessingException {

		List<Recipe> filteredRecipes = new ArrayList<>();

		/*
		 * Search for full matches in categories
		 */
		if (category != null) {
			filteredRecipes = recipeRepository.findRecipesByCategory(category);
			if (filteredRecipes.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No categories like " + category + " found.");
			} else {
				return ResponseEntity.ok(recipesListToJsonObject(filteredRecipes));
			}
		}

		/*
		 * Search for strings in recipe categories and names
		 */
		if (search != null) {
			filteredRecipes.addAll(recipeRepository.findRecipesByCategory(search));
			filteredRecipes.addAll(recipeRepository.findRecipesByName(search));
			if (filteredRecipes.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nothing matched the search string.");
			} else {
				return ResponseEntity.ok(recipesListToJsonObject(filteredRecipes));
			}

		}

		return ResponseEntity.ok(recipesListToJsonObject(recipeRepository.getRecipes()));
	}

	/*
	 * Get all recipe categories.
	 */
	@RequestMapping(value = "/recipes/categories", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getCategories() {
		return ResponseEntity.ok(recipeRepository.getAllCategories());
	}

	/*
	 * Add a new recipe. When a recipe with the same name exists, return error.
	 */
	@RequestMapping(value = "/recipes/addRecipe", method = RequestMethod.POST)
	public HttpEntity<Object> addRecipe(@RequestBody Recipe recipe) {
		List<Recipe> recipes = recipeRepository.getRecipes();
		for (Recipe r : recipes) {
			if (recipe.getHead().getTitle().equalsIgnoreCase(r.getHead().getTitle())) {
				return new ResponseEntity<>("Recipe with the same name already exists!", HttpStatus.BAD_REQUEST);
			}
		}
		recipeRepository.addRecipe(recipe);
		return new ResponseEntity<>(recipe, HttpStatus.OK);
	}

	private String recipesListToJsonObject(List<Recipe> recipes) throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(recipes);
		return json;
	}
}
