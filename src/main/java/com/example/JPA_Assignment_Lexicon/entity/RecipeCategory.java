package com.example.JPA_Assignment_Lexicon.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipeCategoryId;
    private String category;
    @ManyToMany(
            cascade = {CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "recipe_and_recipe_category",
            joinColumns = @JoinColumn(name = "recipe_category_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private Collection<Recipe> recipeC;

    public RecipeCategory(Integer recipeCategoryId,
                          String category,
                          Collection<Recipe> recipeC) {
        this.recipeCategoryId = recipeCategoryId;
        this.category = category;
        this.recipeC = recipeC;
    }
}
