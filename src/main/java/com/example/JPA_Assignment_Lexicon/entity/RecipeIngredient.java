package com.example.JPA_Assignment_Lexicon.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class RecipeIngredient {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name= "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String recipeIngredientId;
    //private Ingredient ingredient;
    private double amount;
    private Measurement measurement;
    //private Recipe recipe;


    @ManyToOne(
            cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "ingredient_id", table ="recipe_ingredient")
    Ingredient ingredient;

    @ManyToOne(
            cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )

    @JoinColumn(name = "recipe_id")
    Recipe recipe;


    public RecipeIngredient(String recipeIngredientId,
                            Ingredient ingredient,
                            double amount,
                            Measurement measurement,
                            Recipe recipe) {
        this.recipeIngredientId = recipeIngredientId;
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }
}
