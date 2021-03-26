package com.example.JPA_Assignment_Lexicon.data;

import com.example.JPA_Assignment_Lexicon.entity.Ingredient;
import com.example.JPA_Assignment_Lexicon.entity.Recipe;

import java.util.Collection;

public interface RecipeDAO {
    Recipe create(Recipe recipe);
    Recipe findById(Recipe recipe);
    Recipe findByRecipeName(String recipeName);
    Recipe update(Recipe recipe);
    void delete(Integer recipeId);
    Collection<Recipe> findAllRecipesContainingIngredient();
    Collection<Recipe> findAllRecipesOfCategory();
}
