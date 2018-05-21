# Recipes application

## Technologies
* Java 1.8
* Spring Boot 2.0.2
* Maven 4.0.0
* JUnit 4

The project should be imported as a Spring Boot application and for testing JUnit runner should be used.


After running the application locally the following endpoints will be available:
* http://localhost:8080/recipes // Returns all recipes available.
* http://localhost:8080/recipes?search=chili // Searches for matches is recipe titles and categories.
* http://localhost:8080/recipes?category=microwave // Searches for categories that have a full match with the parameter string.
* PUT localhost:8080/recipes/addRecipe // Adds a new recipe if a recipe with the same title does not exist already.

If the request is successful JSON data will be returned; otherwise an error message.


An example for testing addRecipe functionality (with Postman application for example):
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
