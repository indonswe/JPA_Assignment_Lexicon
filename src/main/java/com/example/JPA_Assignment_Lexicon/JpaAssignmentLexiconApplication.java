package com.example.JPA_Assignment_Lexicon;
import com.example.JPA_Assignment_Lexicon.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaAssignmentLexiconApplication {

	public static void main(String[] args) {

		SpringApplication.run(JpaAssignmentLexiconApplication.class, args);

		/*@Autowired
		EntityManager em;

		Ingredient persistedIngredient;

		List<Recipe> recipeC = new ArrayList<>();
		List<RecipeIngredient> recipeIngredientC = new ArrayList<>();
		List<RecipeCategory> recipeCategoryC = new ArrayList<>();

		Ingredient unpersisted = new Ingredient("Deca-durabolin");
		//persistedIngredient = em.persistAndFlush(unpersisted);
		RecipeInstruction recipeInstruction = new RecipeInstruction("Put everything together and hope for the best");
		Recipe recipe = new Recipe("Karl-Alfred",recipeIngredientC,recipeInstruction,recipeCategoryC);
		//public Recipe(String recipeName, Collection<RecipeIngredient> recipeIngredientC, RecipeInstruction recipeInstruction, Collection<RecipeCategory> recipeCategoryC) {
		RecipeCategory recipeCategory = new RecipeCategory("Uppbyggande",recipeC);
		RecipeIngredient recipeIngredient = new RecipeIngredient(5.0,unpersisted,recipe);
		//public RecipeIngredient(double amount, Measurement measurement, Ingredient ingredient, Recipe recipe) {
		em.persist(unpersisted);
		em.persist(recipeInstruction);
		em.persist(recipe);
		em.persist(recipeCategory);
		em.persist(recipeIngredient);
		em.flush();*/
	}
}
