package com.example.JPA_Assignment_Lexicon.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;


@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipeId;
    private String recipeName;
    private Collection<RecipeIngredient> recipeIngredientC;
    private RecipeInstruction recipeInstruction;
    private Collection<RecipeCategory>  recipeCategoryC;

    public Recipe(Integer recipeId,
                  String recipeName,
                  Collection<RecipeIngredient> recipeIngredientC,
                  RecipeInstruction recipeInstruction,
                  Collection<RecipeCategory> recipeCategoryC) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeIngredientC = recipeIngredientC;
        this.recipeInstruction = recipeInstruction;
        this.recipeCategoryC = recipeCategoryC;
    }
}
