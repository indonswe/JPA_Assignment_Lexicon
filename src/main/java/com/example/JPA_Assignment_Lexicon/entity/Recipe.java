package com.example.JPA_Assignment_Lexicon.entity;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipeId;
    private String recipeName;
    @OneToOne(
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    private RecipeInstruction recipeInstruction;
    //@JoinColumn(name = "recipe_instruction_id")
    @OneToMany(
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY,
            mappedBy = "recipe"
    )
    private Collection<RecipeIngredient> recipeIngredientC;
    //Trying to connect ingrdients with recipe, of course dont know what I am doing :)
    /*@JoinTable(
            name = "recipe_id_recipe_ingredient_name",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_ingredient_name")
    )*/


    @ManyToMany(
            cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "recipe_recipe_category",
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

    public Recipe(String recipeName, Collection<RecipeIngredient> recipeIngredientC, RecipeInstruction recipeInstruction, Collection<RecipeCategory> recipeCategoryC) {
        this.recipeName = recipeName;
        this.recipeIngredientC = recipeIngredientC;
        this.recipeInstruction = recipeInstruction;
        this.recipeCategoryC = recipeCategoryC;
    }
}
