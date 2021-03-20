package com.example.JPA_Assignment_Lexicon.entity;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipeId;
    private String recipeName;

    @OneToMany(
            cascade = {CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    private Collection<RecipeIngredient> recipeIngredientC;

    @OneToOne(
            cascade = {CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    private RecipeInstruction recipeInstruction;

    @ManyToMany(
            cascade = {CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "recipe_and_recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_category_id")
    )
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
