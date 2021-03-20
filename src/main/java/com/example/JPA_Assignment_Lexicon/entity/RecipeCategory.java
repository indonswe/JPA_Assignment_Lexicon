package com.example.JPA_Assignment_Lexicon.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;

@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeCategoryId;
    private String category;
    private Collection<Recipe> recipeC;

    public RecipeCategory(int recipeCategoryId,
                          String category,
                          Collection<Recipe> recipeC) {
        this.recipeCategoryId = recipeCategoryId;
        this.category = category;
        this.recipeC = recipeC;
    }
}
