# Recipes application

## Technologies
* Java 1.8
* Spring Boot 2.0.2
* Maven 4.0.0
* JUnit 4

## Introduction
The project should be imported as a Spring Boot application and JUnit runner should be used for testing.
The tests class is called RecipesRepositoryTests.


After running the application locally the following endpoints will be available:
* GET http://localhost:8080/recipes Returns all available recipes.
* GET http://localhost:8080/recipes?search=chili Searches for matches in recipe titles and categories.
* GET http://localhost:8080/recipes?category=microwave Searches for categories that have a full match with the parameter string.
* PUT http://localhost:8080/recipes/addRecipe Adds a new recipe if a recipe with the same title does not exist already.

If the request is successful JSON data will be returned; otherwise an error message.

## Example request

An example (can also be found in the Recipes/recipes/test_recipe/ folder) for testing addRecipe functionality (with the *Postman* application for example):
```
<recipe>
    <head>
      <title>Pancakes</title>
      <categories>
        <cat>Sweet</cat></categories>
      <yield>6</yield></head>
    <ingredients>
      <ing>
        <amt>
          <qty>1</qty>
          <unit>pound</unit></amt>
        <item>Flour</item></ing>
      <ing>
        <amt>
          <qty>3</qty>
          <unit>tablespoons</unit></amt>
        <item>Butter or margarine</item></ing>
      <ing>
        <amt>
          <qty>3</qty>
          <unit/></amt>
        <item>Eggs; beaten</item></ing>
      <ing>
        <amt>
          <qty>3</qty>
          <unit>cup</unit></amt>
        <item>Flour</item></ing>
        </ingredients>
    <directions>
      <step>  Mix it all together and fry.
 
</step></directions></recipe>
```
